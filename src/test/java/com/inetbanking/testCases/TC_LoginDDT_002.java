package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.Loginpage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
	public void logininDDT(String user,String pwd)
	{
		
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
			
		}
	}
	
	
	
	public boolean isAlertPresent() { //user defines method created to check alert is present or not
		try {
			
		   driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			
			return false;
		}
		
		
}
	
	@DataProvider(name="LoginData")
	String[][] getData()
	{
		
		String path=System.getProperty(("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx");
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int cocount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][cocount];
		
		for(int i=1;i<=rownum;i++) {
			
			for(int j=0;j<cocount;j++) {
				
				logindata[i-1][j]=XLUtils.getcelldata(path,"Sheet1",i,j);
				
			}
			
		}
		return logindata;
		
		
	}
	

}
