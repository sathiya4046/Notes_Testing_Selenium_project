package org.kgisl.testScenario;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.kgisl.pageObject.PoForLogin;
import org.kgisl.pageObject.PoForWriteNotes;
import org.kgisl.utils.BaseClass;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase_WriteNotes extends BaseClass {

	@Parameters({"browser","email","password"})
	@BeforeMethod
	public void setup(@Optional("chrome") String browser,@Optional("sathiya@gmail.com") String email,@Optional("Sathiya@123") String password) {

		launchBrowser(browser);
		launchUrl("https://notes-mern-hlxh.onrender.com/login");
		driver.manage().window().maximize();
		implicitWait(driver, 30);
		
		PoForLogin po = new PoForLogin();
		passText(email, po.getEmailField());
		passText(password, po.getPasswordField());
		clickBtn(po.getLogin_btn());
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlToBe("https://notes-mern-hlxh.onrender.com/notes"));
    	implicitWait(driver, 30);

	}

	@Test
	public void Test_21() {
		SoftAssert s = new SoftAssert();
		PoForWriteNotes po = new PoForWriteNotes();
		try {
			po.getTitle().click();
			clickBtn(po.getAdd_btn());			
		}catch(Exception e){
			s.fail("Test fail due to exception" + e.getMessage());
		}finally {
			s.assertAll();	
		}	
	}
	
	@Parameters("value1")
	@Test
	public void Test_22(@Optional ("Kgisl") String title) throws IOException {	
		SoftAssert softAssert = new SoftAssert();
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_") + "_Testcasel_Error.png";
        try {
        	PoForWriteNotes po = new PoForWriteNotes();
        	po.getTitle().click();
        	passText(title, po.getTitle());
    		clickBtn(po.getAdd_btn());

            softAssert.assertEquals(po.getTitle().getAttribute("value"), title, "Title input mismatch");

        } catch (Exception e) {
            System.out.println("Test failed due to exception: " + e.getMessage());
            softAssert.fail("Exception occurred during note creation test.");
            screenShot(FileName);
        }
        softAssert.assertAll();
	}

	@Parameters("value2")
	@Test
	public void Test_23(@Optional ("Kgisl is the best institute of tamilnadu") String notes) {	
		SoftAssert softAssert = new SoftAssert();
        try {
        	PoForWriteNotes po = new PoForWriteNotes();
        	po.getTitle().click();
        	passText(notes, po.getTextarea());
    		clickBtn(po.getAdd_btn());

            softAssert.assertEquals(po.getTextarea().getAttribute("value"), notes, "Note input mismatch");

        } catch (Exception e) {
            System.out.println("Test failed due to exception: " + e.getMessage());
            softAssert.fail("Exception occurred during note creation test.");
        }
        softAssert.assertAll();
	}
	
	@Parameters({"value1","value2"})
	@Test
	public void Test_24(@Optional("Kgisl") String title,@Optional("Kgisl is the best institute of tamilnad") String notes) {	
		SoftAssert softAssert = new SoftAssert();
	        try {
	        	PoForWriteNotes po = new PoForWriteNotes();
	        	po.getTitle().click();
	        	passText(title, po.getTitle());
	        	passText(notes, po.getTextarea());
	    		clickBtn(po.getAdd_btn());

	            softAssert.assertEquals(po.getTitle().getAttribute("value"), title, "Title input mismatch");
	            softAssert.assertEquals(po.getTextarea().getAttribute("value"), notes, "Note input mismatch");

	        } catch (Exception e) {
	            System.out.println("Test failed due to exception: " + e.getMessage());
	            softAssert.fail("Exception occurred during note creation test.");
	        }
	        softAssert.assertAll();
	}
	
	@Test
	public void Test_25() {	
		SoftAssert softAssert = new SoftAssert();
        try {
        	PoForWriteNotes po = new PoForWriteNotes();
        	clickBtn(po.getLogout());

        } catch (Exception e) {
            System.out.println("Test failed due to exception: " + e.getMessage());
            softAssert.fail("Exception occurred during note creation test.");
        }
        softAssert.assertAll();		
	}
	 
	@AfterMethod
    public void close() {
		closeEntireBrowser();
    }
}
