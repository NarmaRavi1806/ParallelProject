package com.cg.wallet.Db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.wallet.bean.Wallet;

public class WalletDataBase {
	
	private static HashMap<String,Wallet> walletMap=new HashMap<String,Wallet>();
	
	
	
	public static HashMap<String, Wallet> getWalletMap() {
		return walletMap;
	}



	static{
		walletMap.put("1234567890", new Wallet("Akanksha","1234567890", "akakaka123@gmail.com",7000.0,LocalDateTime.now()));
		walletMap.put("9087654321", new Wallet("Aasha","9087654321", "aasha123@gmail.com",10000.0,LocalDateTime.now()));
		walletMap.put("8899556644", new Wallet("Sruthi","8899556644", "sruthi123@gmail.com",10000.0,LocalDateTime.now()));
		walletMap.put("9870654321", new Wallet("Chris","9870654321", "chris123@gmail.com",7000.0,LocalDateTime.now()));
		walletMap.put("5432167890", new Wallet("Evans","5432167890", "evans123@gmail.com",4500.0,LocalDateTime.now()));
		
	}

}

