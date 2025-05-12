package org.kgisl.testScenario;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.kgisl.pageObject.PoForRegister;
import org.kgisl.pageObject.PoForWriteNotes;
import org.kgisl.utils.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase_RegisterPage extends BaseClass {

		@Parameters("browser")
		@BeforeSuite
		public void setup(@Optional("chrome") String browser) {
			SoftAssert s = new SoftAssert();
			try {
				launchBrowser(browser);
				launchUrl("https://notes-mern-hlxh.onrender.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Test
		public void Test_1() {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				Assert.assertTrue(po.getNameField().isDisplayed(), "Name field is not visible");
				Assert.assertTrue(po.getEmailField().isDisplayed(), "Email field is not visible");
				Assert.assertTrue(po.getPasswordField().isDisplayed(), "Password field is not visible");
				Assert.assertTrue(po.getLogin_link().isDisplayed(), "Login link is not visible");
				Assert.assertTrue(po.getRegister_btn().isDisplayed(), "Register button is not visible");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Test
		public void Test_2() {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				String namePadding = po.getNameField().getCssValue("padding");
				String emailPadding = po.getEmailField().getCssValue("padding");
				String passwordPadding = po.getPasswordField().getCssValue("padding");
				
				Assert.assertEquals(namePadding, "6px 12px");  
				Assert.assertEquals(emailPadding, "6px 12px");
				Assert.assertEquals(passwordPadding, "6px 12px");			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Test
		public void Test_3() {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String actualUrl = po.getError_msg().getText();
				Assert.assertEquals(actualUrl, expectedUrl , "Required field is missing");			
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters("name")
		@Test
		public void Test_4(@Optional ("sathiya") String name) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(name, po.getNameField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String email = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[1]")).getText();
				String pass = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[2]")).getText();
				s.assertEquals(email, expectedUrl , "Required is missing email field");
				s.assertEquals(pass, expectedUrl , "Required is missing password field");			
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"name","email"})
		@Test
		public void Test_5(@Optional ("sathiya")String name,@Optional ("sathiya@gmail.com") String email) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(name, po.getNameField());
				passText(email, po.getEmailField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String pass = po.getError_msg().getText();
				s.assertEquals(pass, expectedUrl , "Required is missing password field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters("email")
		@Test
		public void Test_6(@Optional ("sathiya@gmail.com") String email) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(email, po.getEmailField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String name = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[1]")).getText();
				String pass = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[2]")).getText();
				s.assertEquals(name, expectedUrl , "Required is missing name field");
				s.assertEquals(pass, expectedUrl , "Required is missing password field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"email","password"})
		@Test
		public void Test_7(@Optional ("sathiya@gmail.com") String email,@Optional ("Sathiya@123") String password) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(email, po.getEmailField());
				passText(password, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String name = po.getError_msg().getText();
				s.assertEquals(name, expectedUrl , "Required is missing name field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters("password")
		@Test
		public void Test_8(@Optional ("Sathiya@123")String password) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(password, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String name = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[1]")).getText();
				String email = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[2]")).getText();
				s.assertEquals(name, expectedUrl , "Required is missing name field");
				s.assertEquals(email, expectedUrl , "Required is missing email field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"name","password"})
		@Test
		public void Test_9(@Optional ("sathiya") String name,@Optional ("Sathiya@123") String password) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(name, po.getNameField());
				passText(password, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				String expectedUrl = "Required";
				String email = po.getError_msg().getText();
				s.assertEquals(email, expectedUrl , "Required is missing email field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"name","invalidEmail","invalidPassword"})
		@Test
		public void Test_10(@Optional ("sathiya") String name,@Optional ("sathiyagmail.com") String invalidEmail,@Optional ("sathiya12w") String invalidPassword) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(name, po.getNameField());
				passText(invalidEmail, po.getEmailField());
				passText(invalidPassword, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				
				String expectedEmail = "Email doesn't match as format";
				String expectedPass = "Password doesn't match, eg : Example@123";
				String email = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[1]")).getText();
				String password = driver.findElement(By.xpath("(//span[@class=\"text-warning\"])[2]")).getText();
				s.assertEquals(email, expectedEmail , "doesn't match format is missing email field");
				s.assertEquals(password, expectedPass , "doesn't match format is missing password field");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"invalidName","email","invalidPassword"})
		@Test
		public void Test_11(@Optional ("1wsd3322wss") String invalidName,@Optional ("sathiya@gmail.com") String email,@Optional ("s111111111") String invalidPassword) {
			SoftAssert s = new SoftAssert();
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(invalidName, po.getNameField());
				passText(email, po.getEmailField());
				passText(invalidPassword, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				
				String expectedPass = "Password doesn't match, eg : Example@123";
				String password = po.getError_msg().getText();
				s.assertEquals(password, expectedPass , "doesn't match format is missing password field");
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
			}finally {
				s.assertAll();	
			}
		}
		
		@Parameters({"name","email","password"})
		@Test
		public void Test_12(@Optional ("Sathiyaseelan")String name,@Optional ("sathiya123@gmail.com") String email,@Optional ("Sathiya@123") String password) throws IOException {
			SoftAssert s = new SoftAssert();
			Date d = new Date();
			String FileName = d.toString().replace(":", "_").replace(" ", "_") + "_Testcase_Error.png";
			try {
				refreshPage();
				PoForRegister po = new PoForRegister();
				passText(name, po.getNameField());
				passText(email, po.getEmailField());
				passText(password, po.getPasswordField());
				clickBtn(po.getRegister_btn());
				
				String expectedUrl = "https://notes-mern-hlxh.onrender.com/login";
				String actualUrl = BaseClass.pageUrl();
				s.assertEquals(actualUrl, expectedUrl , "Register is failed");		
			}catch(Exception e){
				s.fail("Test fail due to exception" + e.getMessage());
				screenShot(FileName);
			}finally {
				s.assertAll();	
			}
		}
		 
		@AfterSuite
	    public void close() {
			closeEntireBrowser();
	    }
}
