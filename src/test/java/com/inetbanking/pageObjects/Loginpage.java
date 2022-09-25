package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver){
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}	
		
	
	    @FindBy(name="uid")
		WebElement txtUserName;
	    
	    @FindBy(name="password")
		WebElement txtPassword;
	    
	    @FindBy(name="btnLogin")
		WebElement btnLogin;
	    
	    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	    WebElement lnklogout;
	    
	    
	    public void setUserName(String uname) {
	    	txtUserName.sendKeys(uname);
	    	
	    }
	    
	    public void setPassword(String pwd) {
	    	txtPassword.sendKeys(pwd);
	    	
	    }
	    
	    
	    public void clicksubmit() {
	    	btnLogin.click();
	    	
	    }
		
	    public void clickLogout() {
	    	lnklogout.click();
	    }
		
	
	
	

}
