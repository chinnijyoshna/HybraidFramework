package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.Loginpage;



public class TC_addCustomerTest_003 extends BaseClass{
	
	

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		logger.info("username provide");
		lp.setPassword(password);
		logger.info("password provide");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		logger.info("provide customer details");
		
		addcust.custName("jyoshna");
		addcust.custgender("female");
		addcust.custdob("12", "15", "1993");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("hyd");
		addcust.custstate("tg");
		addcust.custpinno("5000072");
		addcust.custtelephonenum("953621456");
		
		String email=randomString()+"@gmail.com";
		addcust.custemail(email);
		
		addcust.custpassword("fghjk");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		logger.info("validation started");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("testcase passed");
			
		}else
		{
			captureScreen(driver,"TC_addCustomerTest_003");
			logger.info("testcase failed");
			Assert.assertTrue(false);
			
		}
		
	}
	
	

}
