package com.cg.wallet.walletDao;


import java.util.HashMap;

import com.cg.wallet.Db.WalletDataBase;
import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;

/**
 * 
 * Class name : WalletDao
 * No. of Methods : 6
 * Purpose :To access the database and retrieve values from database
 * 
 * Author : Narmatha
 * Date of Creation : 13-July-2018
 * 
 * Last Modification Date : 14-July-2018
 *
 */

public class WalletDao implements IWalletDao {
	
	HashMap<String,Wallet> wallMap=WalletDataBase.getWalletMap();
	

	@Override
	public Wallet createAccount(String mobileNo) throws WalletException {
		Wallet wallet=wallMap.get(mobileNo);
		if(wallMap.containsKey(wallet.getMobileNo())){
			throw new WalletException("Customer with mobile number"+mobileNo+
					"already exist in the database");
			
		}
		wallMap.put(wallet.getMobileNo(),wallet );
		return wallet;
	}

	@Override
	public double showBalance(String mobileNo)
			throws WalletException {
		Wallet wallet=wallMap.get(mobileNo);
		if(wallMap.containsKey(wallet.getMobileNo())){
			
			wallet.getBalance();
			
		}else{
			throw new WalletException("Customer with mobile number"+mobileNo+
					"Does not exist");
		}
		return wallet.getBalance();
	}

	@Override
	public Wallet deposit(String mobileNo,double dep)
			throws WalletException {
		
		Wallet wallet=wallMap.get(mobileNo);
		
		if(wallMap.containsKey(wallet.getMobileNo())){
			
			wallet.setBalance(wallet.getBalance()+dep);
		}else{
			throw new WalletException("Mobile number does not exist");
			
		}
		return wallet;
	}

	@Override
	public Wallet withdrawAmount(String mobileNo,double withdraw)
			throws WalletException {
		Wallet wallet=wallMap.get(mobileNo);
		
		if(wallMap.containsKey(wallet.getMobileNo())){
			wallet.setBalance(wallet.getBalance()-withdraw);
		}else{
			if(withdraw<=0){
			throw new WalletException("Amount cannot be Withdrawn");
			}
		}
		return wallet;
	}

	@Override
	public double fundTransfer(String srcMobile, String destMobile,
			double amount) throws WalletException {
		Wallet wallet=wallMap.get(srcMobile);
		Wallet wallet2=wallMap.get(destMobile);
		if(wallMap.containsKey(wallet.getMobileNo())){
			if(wallMap.containsKey(wallet2.getMobileNo())){
				while(wallet.getBalance()>amount)
				wallet.setBalance(wallet.getBalance()-amount);
				wallet2.setBalance(wallet2.getBalance()+amount);
			}
			
		}
		return wallet.getBalance()+wallet2.getBalance();
	}

	@Override
	public Wallet printTransaction(String mobile) throws WalletException {
		Wallet wallet=wallMap.get(mobile);
		if(wallet==null){
			throw new WalletException("Mobile number does not exist");
		}

		return wallet;
	}
	
	
	

}
