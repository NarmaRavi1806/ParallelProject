package com.cg.wallet.walletService;


import java.time.LocalDateTime;

import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletDao.IWalletDao;
import com.cg.wallet.walletDao.WalletDao;
import com.cg.wallet.walletException.WalletException;

/**
 * 
 * Class name : WalletServiceImpl
 * No. of Methods : 10
 * Purpose :To implement the Service of Wallet
 * 
 * Author : Narmatha
 * Date of Creation : 13-July-2018
 * 
 * Last Modification Date : 14-July-2018
 *
 */

public class WalletServiceImpl implements IWalletService {
	IWalletDao walletDao=new WalletDao();
	Wallet wallet1=new Wallet();

	@Override
	public Wallet createAccount(String mobileNo) throws WalletException {
		validateAccount(wallet1);
		return walletDao.createAccount(mobileNo);
		
	}

	@Override
	public double showBalance(String mobileNo) throws WalletException {
		validateMoblieNo(mobileNo);
		return  walletDao.showBalance(mobileNo);
	}

	@Override
	public Wallet deposit(String mobileNo,double dep) throws WalletException {
		validateMoblieNo(mobileNo);
		if(dep<=0){
			throw new WalletException("Invalid amount");
		}else{
			//wallet1.setBalance(wallet1.getBalance()+dep);
			//dep=wallet1.getBalance()+dep;
			wallet1.setDate(LocalDateTime.now());
		}
		
		return walletDao.deposit(mobileNo,dep);
	}
	
	@Override
	public Wallet withdrawAmount(String mobileNo, double withdraw)
			throws WalletException {
		validateMoblieNo(mobileNo);
		if(wallet1.getBalance()>withdraw){
			wallet1.setBalance(wallet1.getBalance()-withdraw);
			wallet1.setDate(LocalDateTime.now());
		}else{
			throw new WalletException("Insufficient balance");
		}
		return walletDao.withdrawAmount(mobileNo, withdraw);
	}
	
	@Override
	public double fundTransfer(String srcMobile, String DestMobile,
			double amount) throws WalletException {
		validateMoblieNo(srcMobile);
		validateMoblieNo(DestMobile);
		if(amount<=0){
			throw new WalletException("Invalid amount");
		}
		wallet1.setDate(LocalDateTime.now());
		
		return walletDao.fundTransfer(srcMobile, DestMobile, amount);
	}
	
	
	public boolean validateCustomerName(String name) throws WalletException{
		if(name.isEmpty()|| name==null){
			throw new WalletException("Customer name cannot be empty");
		}
		else{
			if(!name.matches("[A-Z][A-Za-z]{3,}")){
				throw new WalletException("Name should start with a "
						+ "capital letter and should be only of alphabets");
			}
		}
		return true;
	}
	
	
	public boolean validateMoblieNo(String mobileNo) throws WalletException{
		if(!mobileNo.matches("\\d{10}")){
			throw new WalletException("Mobile number should contain 10 digits");
		}
		return true;
	}
	
	public boolean validateEmailId(String emailId)throws WalletException{
		
		if(!emailId.matches("[a-z0-9]{8,}[@][a-z]{5}\\.{1}[com]")){
			throw new WalletException("Invalid Email Id");
		}
		
		return true;
	}

	@Override
	public boolean validateAccount(Wallet wallet) throws WalletException {
		if(validateCustomerName(wallet.getName())&& validateMoblieNo(wallet.getMobileNo())
				&& validateEmailId(wallet.getEmailId())){
			return true;
		}else{
			throw new WalletException("Invalid Data");
			
		}
		
	}

	@Override
	public Wallet printTransaction(String mobile) throws WalletException {
		
		return walletDao.printTransaction(mobile);
	}

	

	

}
