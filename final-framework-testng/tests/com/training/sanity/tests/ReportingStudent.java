package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.NewPOM;
import com.training.pom.AdminPOM;
import com.training.pom.ReportPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReportingStudent {

	private WebDriver driver;
	private String baseUrl;
	private NewPOM newPOM;
	private AdminPOM adminPOM;
	private ReportPOM reportPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		newPOM = new NewPOM(driver); 
		adminPOM = new AdminPOM(driver);
		reportPOM = new ReportPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	/*@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}*/
	
	/*@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	@Test
	public void validLoginTest() throws InterruptedException {
		newPOM.sendUserName("admin");
		newPOM.sendPassword("admin@123");
		newPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("5TCAdminHomepage");
		Thread.sleep(5000);
		reportPOM.clickReporting();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(5000);
		reportPOM.clickFollowstu();
		reportPOM.SendStuname("Sathyashree");
		reportPOM.clickSearch();
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(5000);
		reportPOM.clickArrowuser();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 js2.executeScript("window.scrollBy(0,650)");
		 Thread.sleep(5000);
		 reportPOM.clickArrowcourse();
		 JavascriptExecutor js3 = (JavascriptExecutor) driver;
		 js3.executeScript("window.scrollBy(0,850)");
		 Thread.sleep(3000);
		 reportPOM.clickTest();
		 Thread.sleep(3000);
		 reportPOM.clickSendemail();
		 Thread.sleep(3000);
		  reportPOM.clickCorrecttest();
		 Thread.sleep(3000);
		 reportPOM.clickSessionlink();
	}
}
