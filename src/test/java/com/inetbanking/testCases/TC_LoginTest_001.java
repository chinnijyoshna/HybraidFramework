package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws IOException {
		
	
		
		logger.info("URL is opened");
		
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		
		logger.info("Entered Username");
		lp.setPassword(password);
		
		logger.info("Entered Password");
		lp.clicksubmit();
		
		if(driver.getTitle().equals(" Guru99 Bank Manager HomePage123"))
		{
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
			
		}else {
			
		
			captureScreen(driver,"loginTest");
			Assert.assertFalse(false);
			logger.info("Login test failed");
		
		
	}
	
	}

	
		
	}


