package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import net.bytebuddy.utility.RandomString;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	

	public String baseUrl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public WebDriver driver;
	public static Logger logger;
	
	@Parameters("broswer")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger(BaseClass.class);
		//PropertyConfigurator.configure("log4J2.properties");
		DOMConfigurator.configure("log4j2.xml");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
			
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			
			
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIePath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
					
		driver.get(baseUrl);
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty(("user.dir")+ "/screenshot/" + tname + ".png"));
	FileUtils.copyDirectory(source, target);
	System.out.println("screenshot taken");
	
	

}
	
	public String randomString() 
	{
		String generatedString=RandomStringUtils.randomAlpabet(8);
	    return (generatedString);
	}
      
	public String randomNum() 
	{
		String generatedString2=RandomStringUtils.randomNumeric(4);
	    return (generatedString2);
	
}
}
