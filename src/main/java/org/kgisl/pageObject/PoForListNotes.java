package org.kgisl.pageObject;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoForListNotes extends BaseClass{

	public PoForListNotes() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login_btn;
}
