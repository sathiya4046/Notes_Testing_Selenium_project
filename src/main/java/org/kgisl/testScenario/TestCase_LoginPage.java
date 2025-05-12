package org.kgisl.testScenario;

import java.time.Duration;

import org.kgisl.pageObject.PoForLogin;
import org.kgisl.pageObject.PoForWriteNotes;
import org.kgisl.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase_LoginPage extends BaseClass {

	@Parameters("browser")
	@BeforeSuite
	public void setup(@Optional("chrome") String browser) {
		SoftAssert s = new SoftAssert();
		try {
			launchBrowser(browser);
			launchUrl("https://notes-mern-hlxh.onrender.com/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			driver.manage().window().maximize();			
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	
	@Test
	public void Test_13() {	
		SoftAssert s = new SoftAssert();
		try {
			PoForLogin po = new PoForLogin();
			Assert.assertTrue(po.getEmailField().isDisplayed(), "Email field is not visible");
			Assert.assertTrue(po.getPasswordField().isDisplayed(), "Password field is not visible");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	
	@Test
	public void Test_14() {
		SoftAssert s = new SoftAssert();
		try {
			PoForLogin po = new PoForLogin();
			String emailPadding = po.getEmailField().getCssValue("padding");
			String passwordPadding = po.getPasswordField().getCssValue("padding");
			
			Assert.assertEquals(emailPadding, "6px 12px");
			Assert.assertEquals(passwordPadding, "6px 12px");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	
	@Test
	public void Test_15() {
		SoftAssert s = new SoftAssert();
		try {
			PoForLogin po = new PoForLogin();
			clickBtn(po.getLogin_btn());

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to notes page failed both are empty.");			
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
		
//        boolean isEmailValid = (Boolean) ((JavascriptExecutor) driver)
//                .executeScript("return arguments[0].checkValidity();", po.getEmailField());
//
//        Assert.assertFalse(isEmailValid, "Email field should be required and invalid.");
//
//        String validationEmail = (String) ((JavascriptExecutor) driver)
//                .executeScript("return arguments[0].validationMessage;", po.getEmailField());
//
//        System.out.println("Validation Message: " + validationEmail);
//        Assert.assertTrue(validationEmail.contains("fill out"), "Expected required field validation message.");
//        
//        boolean isPasswordValid = (Boolean) ((JavascriptExecutor) driver)
//                .executeScript("return arguments[0].checkValidity();", po.getPasswordField());
//
//        Assert.assertFalse(isPasswordValid, "Password field should be required and invalid.");
//
//        String validationPassword = (String) ((JavascriptExecutor) driver)
//                .executeScript("return arguments[0].validationMessage;", po.getPasswordField());
//
//        System.out.println("Validation Message: " + validationPassword);
//        Assert.assertTrue(validationPassword.contains("fill out"), "Expected required field validation message.");
	}
	@Parameters("email")
	@Test
	public void Test_16(@Optional ("sathiya@gmail.com") String email) {
		SoftAssert s = new SoftAssert();
		try {
			refreshPage();
			PoForLogin po = new PoForLogin();
			passText(email, po.getEmailField());
			clickBtn(po.getLogin_btn());

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to notes page failed, notes field empty.");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	
	@Parameters("password")
	@Test
	public void Test_17(@Optional ("Sathiya@123") String password) {
		SoftAssert s = new SoftAssert();
		try {
			refreshPage();
			PoForLogin po = new PoForLogin();
			passText(password, po.getPasswordField());
			clickBtn(po.getLogin_btn());

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to notes page failed, email field empty.");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	

	@Parameters({"email","invalidPassword"})
	@Test
	public void Test_18(@Optional ("sathiya@gmail.com") String email,@Optional ("Sathiya23")  String invalidPassword) {
		SoftAssert s = new SoftAssert();
		try {
			refreshPage();
			PoForLogin po = new PoForLogin();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    
			passText(email, po.getEmailField());
			passText(invalidPassword, po.getPasswordField());
			clickBtn(po.getLogin_btn());
			
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = BaseClass.pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to login page failed.");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}		
	}
	
	@Parameters({"invalidEmail","password"})
	@Test
	public void Test_19(@Optional ("shiy@mail.com") String invalidEmail,@Optional ("Sathiya@123")  String password) {
		SoftAssert s = new SoftAssert();
		try {
			refreshPage();
			PoForLogin po = new PoForLogin();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    
			passText(invalidEmail, po.getEmailField());
			passText(password, po.getPasswordField());
			clickBtn(po.getLogin_btn());
			
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = BaseClass.pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to login page failed.");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}		
	}
	
	@Parameters({"email","password"})
	@Test
	public void Test_20(@Optional ("sathiya@gmail.com") String email,@Optional ("Sathiya@123")  String password) {
		SoftAssert s = new SoftAssert();
		try {
			refreshPage();
			PoForLogin po = new PoForLogin();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    
			passText(email, po.getEmailField());
			passText(password, po.getPasswordField());
			clickBtn(po.getLogin_btn());
			
			String expectedUrl = "https://notes-mern-hlxh.onrender.com/notes";
			wait.until(ExpectedConditions.urlToBe(expectedUrl));
			String actualUrl = BaseClass.pageUrl();
			s.assertEquals(actualUrl, expectedUrl , "Redirection to login page failed.");		
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	 
	@AfterSuite
    public void close() {
		closeEntireBrowser();
    }
}
