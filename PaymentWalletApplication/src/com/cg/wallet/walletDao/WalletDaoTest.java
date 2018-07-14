package com.cg.wallet.walletDao;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.wallet.Db.WalletDataBase;
import com.cg.wallet.bean.Wallet;
import com.cg.wallet.walletException.WalletException;
import com.cg.wallet.walletService.WalletServiceImpl;

/**
 * 
 * Class name : WalletDaoTest
 * No. of Methods : 33
 * Purpose :Test cases to Check the Methods that are implemented
 * 
 * Author : Narmatha
 * Date of Creation : 13-July-2018
 * 
 * Last Modification Date : 14-July-2018
 *
 */
public class WalletDaoTest {
	
	@Before
	public void testException()throws WalletException{
		
	}
	
	@After
	public void testException1()throws WalletException{
		
	}
	
	Wallet wallet=new Wallet();
	HashMap<String,Wallet> walletMap=WalletDataBase.getWalletMap();
	WalletServiceImpl service=new WalletServiceImpl();
	

	@Test
	public void testInvalidMobileNo() {
		try {
			assertFalse(service.validateMoblieNo("2345"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		
	}
	
	@Test
	public void testValidMobileNoNot(){
		
		try {
			assertTrue(service.validateMoblieNo("9008005643"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}
	
	@Test
	public void testCustomerNameNull(){
		try {
			assertTrue(service.validateCustomerName(""));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	

	@Test
	public void testInvalidCustomerName(){
		try {
			assertTrue(service.validateCustomerName("ravi"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCustomerNameNotNull(){
		try {
			assertTrue(service.validateCustomerName("Ravi"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testEmailIdNull(){
		
		try {
			assertTrue(service.validateEmailId(""));
		} catch (WalletException e) {
			System.out.println();
			System.out.println("Email Id is empty"+e.getMessage());
			System.out.println();
		}
		
	}
	
	@Test
	public void testInvalidEmailId(){
		try {
			assertTrue(service.validateEmailId("efjndjf@123"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testValidEmailId(){
		try {
			assertTrue(service.validateEmailId("ravi123@gmail.com"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidAccount(){
		wallet.setMobileNo("1238");
		wallet.setName("banu");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccount(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(6000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	
	}
	@Test
	public void testCreateAccountForInvalidCustomerName(){
		wallet.setMobileNo("7788665544");
		wallet.setName("banu234");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForCustomerNameNull(){
		wallet.setMobileNo("7788665544");
		wallet.setName("");
		wallet.setEmailId("abcd12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidMobileNo(){
		wallet.setMobileNo("778866");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(1000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidMobileNo(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(2000.0);
		try {
			assertTrue(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidEmailId(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@1234gmail.com");
		wallet.setBalance(2000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidEmailId(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(2000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForInvalidBalance(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testCreateAccountForValidBalance(){
		wallet.setMobileNo("7788665533");
		wallet.setName("Ramya");
		wallet.setEmailId("ramya12345@gmail.com");
		wallet.setBalance(6000.0);
		try {
			assertFalse(service.validateAccount(wallet));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testShowBalanceForInvalidMobileNo(){
		wallet.setMobileNo("2345");
		try {
			service.showBalance(wallet.getMobileNo());
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testShowBalanceForMobileNoExist(){
		wallet.setMobileNo("5432167890");
		try {
			service.showBalance(wallet.getMobileNo());
		} catch (WalletException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	
	@Test
	public void testDepositForInvalidMobileNo(){
		wallet.setMobileNo("2345");
		try {
			service.deposit("2345",0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testDepositForMobileNoExist(){
		wallet.setMobileNo("5432167890");
		try {
			wallet=service.deposit(wallet.getMobileNo(),500.0);
			assertNotNull(wallet);
			//assertSame(5000.0,service.deposit(wallet.getMobileNo(),500.0));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	
	@Test
	public void testDepositInvalidAmount(){
		wallet.setMobileNo("5432167890");
		try {
			service.deposit(wallet.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Invalid amount",e.getMessage());
		}
	}
	
	@Test
	public void testDepositAmount(){
		wallet.setMobileNo("5432167890");
		try {
			wallet=service.deposit(wallet.getMobileNo(),500.0);
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testWithdrawForInvalidMobileNo(){
		wallet.setMobileNo("2345");
		try {
			service.withdrawAmount("2345",0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawInvalidAmount(){
		wallet.setMobileNo("5432167890");
		try {
			service.withdrawAmount(wallet.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Insufficient balance",e.getMessage());
		}
	}
	
	@Test
	public void testWithdrawValidAmount(){
		wallet.setMobileNo("5432167890");
		try {
			service.withdrawAmount(wallet.getMobileNo(),500.0);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testWithdrawForMobileNoExist(){
		wallet.setMobileNo("5432167890");
		try {
			wallet=service.withdrawAmount(wallet.getMobileNo(),500.0);
			assertNotNull(wallet);
			
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testFundTransferForInvalidMobileNo(){
		wallet.setMobileNo("2345");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("3456");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),0);
		} catch (WalletException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferForMobileNoExist(){
		wallet.setMobileNo("5432167890");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("1234567890");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),500.0);
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testFundTransferInvalidAmount(){
		wallet.setMobileNo("5432167890");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("1234567890");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),-500.0);
		} catch (WalletException e) {
			assertEquals("Invalid amount",e.getMessage());
		}
	}
	
	@Test
	public void testFundTransferValidAmount(){
		wallet.setMobileNo("5432167890");
		Wallet wallet1=new Wallet();
		wallet1.setMobileNo("1234567890");
		try {
			service.fundTransfer(wallet.getMobileNo(),wallet1.getMobileNo(),500.0);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testPrintTransaction(){
		wallet.setMobileNo("5432167890");
		
		try {
			wallet=service.printTransaction(wallet.getMobileNo());
			assertNotNull(wallet);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}

}
