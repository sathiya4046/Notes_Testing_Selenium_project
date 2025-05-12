package org.kgisl.pageObject;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PoForWriteNotes extends BaseClass{
	public PoForWriteNotes() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(tagName="input")
	private WebElement title;
	
	@FindBy(tagName = "textarea")
	private WebElement textarea;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement add_btn;
	
	@FindBy(linkText="Logout")
	private WebElement logout;

	public WebElement getTitle() {
		return title;
	}

	public WebElement getTextarea() {
		return textarea;
	}

	public WebElement getAdd_btn() {
		return add_btn;
	}

	public WebElement getLogout() {
		return logout;
	}

}
