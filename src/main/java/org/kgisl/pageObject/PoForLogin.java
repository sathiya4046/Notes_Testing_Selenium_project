package org.kgisl.pageObject;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoForLogin extends BaseClass{
	public PoForLogin() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login_btn;
	
	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

}
