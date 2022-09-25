package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
       public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	WebElement txtCustomerNamer;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdGender;
	
	@FindBy(how=How.NAME,using="dob")
	WebElement txtdob;
	
	@FindBy(how=How.NAME,using="addr")
	WebElement txtaddress;
	
	@FindBy(how=How.NAME,using="city")
	WebElement txtcity;
	
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement txtpinno;
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement telephn;
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement emailid;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@FindBy(how=How.NAME,using="sub")
	WebElement btnsubmit;
	
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerNamer.sendKeys(cname);
		
	}
	
	public void custgender(String cgender) {
		rdGender.click();
		
	}
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	
	}
	
	public void custpinno(String string) {
		txtstate.sendKeys(String.valueOf(string));
	
	}
	public void custtelephonenum(String ctelephone) {
		txtstate.sendKeys(ctelephone);
	
	}
	public void custemail(String cemail) {
		emailid.sendKeys(cemail);
	
	}
	public void custpassword(String cpassword) {
		password.sendKeys(cpassword);
	
	}
	public void custsubmit() {
		btnsubmit.click();
	
	}


}
