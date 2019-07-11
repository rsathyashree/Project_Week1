package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.NewPOM;
import com.training.pom.AdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Administration {

	private WebDriver driver;
	private String baseUrl;
	private NewPOM newPOM;
	private AdminPOM adminPOM;
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
		screenShot.captureScreenShot("4TCAdminHomepage");
		Thread.sleep(5000);
		adminPOM.clickAdmin();
		adminPOM.clickUsers();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		adminPOM.sendUserText("Sathyashree");
		adminPOM.clickSearch();
		adminPOM.clickEdit();
		Thread.sleep(3000);
		adminPOM.EditEmail("sathyar@gmail.com");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,750)");
		 /*Thread.sleep(5000);
		adminPOM.clickActive();
		Thread.sleep(5000);*/
		js.executeScript("window.scrollBy(0,1700)");
		adminPOM.clickSubmit();
		String actual = adminPOM.getmessage();
		String exp = "User updated: Sathyashree R (sathyashree)";
		Assert.assertEquals(exp, actual);
			System.out.println("User details are modified and the message is displayed correctly");
	
		
	}
}
