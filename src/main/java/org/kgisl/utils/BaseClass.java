package org.kgisl.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser(String type) {
            
    	switch (type.toLowerCase()) {
	    	case "chrome" :
	    		WebDriverManager.chromedriver().setup();
	    		ChromeOptions chromeOptions = new ChromeOptions();
	    		chromeOptions.addArguments("--incognito");
	    		driver = new ChromeDriver(chromeOptions);
	            break;
	    	case "firefox" :
	    		WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	            break;
	    	case "edge" :
	    		WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	            break;
	        default:
	        	throw new IllegalArgumentException("Unsupported browser: " + type);
    	}	
    }

    public static void launchUrl(String url) {
            driver.get(url);
    }
    
    public static void implicitWait(WebDriver driver, int seconds) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

    public static void pageTitle() {
            String title = driver.getTitle();
            System.out.println(title);
    }

    public static String pageUrl() {
            String url = driver.getCurrentUrl();
            System.out.println(url);
			return url;
    }

    public static void passText(String txt, WebElement ele) {
            ele.sendKeys(txt);
    }
    
    public static void clickBtn(WebElement ele) {
        ele.click();
    }
    
    public static void refreshPage() {
    	driver.navigate().refresh();
	}   

    public static void closeEntireBrowser() {
            driver.quit();
    }

    public void screenShot(String imgName) throws IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File image = ts.getScreenshotAs(OutputType.FILE);
            File f = new File("target/screenshots/" + imgName+ ".png");
            FileUtils.copyFile(image, f);
    }
}

