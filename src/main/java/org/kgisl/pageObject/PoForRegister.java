package org.kgisl.pageObject;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoForRegister extends BaseClass {

		public PoForRegister() {
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name="name")
		private WebElement nameField;
		
		@FindBy(name="email")
		private WebElement emailField;
		
		@FindBy(name="password")
		private WebElement passwordField;
		
		@FindBy(linkText="Login")
		private WebElement login_link;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement register_btn;
		
		@FindBy(xpath="//span[@class='text-warning']")
		private WebElement error_msg;

		public WebElement getNameField() {
			return nameField;
		}

		public WebElement getEmailField() {
			return emailField;
		}

		public WebElement getPasswordField() {
			return passwordField;
		}

		public WebElement getLogin_link() {
			return login_link;
		}

		public WebElement getRegister_btn() {
			return register_btn;
		}

		public WebElement getError_msg() {
			return error_msg;
		}
		
		
}
