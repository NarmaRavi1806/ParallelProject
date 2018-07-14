package com.cg.wallet.walletDao;

import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;

public interface IWalletDao {
	
	Wallet createAccount(String mobileNo) throws WalletException;
	double showBalance(String mobileNo) throws WalletException;
	Wallet deposit(String mobileNo,double dep)throws WalletException;
	Wallet withdrawAmount(String mobileNo,double withdraw)throws WalletException;
	double fundTransfer(String srcMobile,String destMobile,double amount)throws WalletException;
	Wallet printTransaction(String mobile)throws WalletException;
	

}
