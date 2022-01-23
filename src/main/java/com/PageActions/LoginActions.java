package com.PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginActions {
	private WebDriver driver;
	
	//constructor
	public LoginActions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy (id="email")
	private WebElement email;
	
	@CacheLookup
	@FindBy (id="pass")
	private WebElement password;
	

	@CacheLookup
	@FindBy (xpath = "//*[@class='_6ltj']")
	private WebElement createnewAccount;
	
	
	public String gettitle() {
		return driver.getTitle();
	}
	
	public boolean createnewAccountlinkenabled() {
		return createnewAccount.isEnabled();
	}
	
	
	
	
	
}
