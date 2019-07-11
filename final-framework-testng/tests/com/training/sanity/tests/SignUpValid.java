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
import com.training.pom.CategoryPOM;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SignUpValid {

	private WebDriver driver;
	private String baseUrl;
	private SignUpPOM signupPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM = new SignUpPOM(driver);
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
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws InterruptedException {
		signupPOM.clickSignup();
		signupPOM.ClickProfile();
		Thread.sleep(2000);
		signupPOM.sendFirstName("Mark");
		Thread.sleep(2000);
		signupPOM.sendLastName("Angel");
		Thread.sleep(2000);
		screenShot.captureScreenShot("signupvalid1");
		signupPOM.sendEmail("mark@gmail.com");
		Thread.sleep(2000);
		signupPOM.sendUserName("mark");
		Thread.sleep(2000);
		signupPOM.sendPassword("mark");
		Thread.sleep(2000);
		signupPOM.sendConfPassword("mark");
		Thread.sleep(2000);
		signupPOM.sendPhone("9876543213");
		screenShot.captureScreenShot("signupvalid2");
		Thread.sleep(2000);
		signupPOM.selectLanguage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 signupPOM.ClickSubmit();
		 screenShot.captureScreenShot("signupvalid3");
	}
}
