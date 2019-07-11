package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SessCategories {

	private WebDriver driver;
	private String baseUrl;
	private NewPOM newPOM;
	private AdminPOM adminPOM;
	private CategoryPOM categoryPOM;
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
		categoryPOM = new CategoryPOM(driver);
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
		adminPOM.clickAdmin();
		categoryPOM.clickSesscat();
		categoryPOM.validateSessCategorytitle();
		categoryPOM.clickAddcat();
		categoryPOM.validateAddCategorytitle();
		Thread.sleep(3000);
		categoryPOM.sendCatname("Testing3");
		Thread.sleep(3000);
		categoryPOM.clickSubmitcat();
		Thread.sleep(3000);
		categoryPOM.getCatMessage();
		categoryPOM.clickSesslist();
		Thread.sleep(3000);
		categoryPOM.validateSessListtitle();
		categoryPOM.clickAddsession();
		Thread.sleep(3000);
		categoryPOM.sendSessname("Selennium3");
		Thread.sleep(3000);
		categoryPOM.clickAdvsettings();
		Thread.sleep(3000);
		categoryPOM.SelectCategory();
		Thread.sleep(3000);
		categoryPOM.clicknextstep1();
		Thread.sleep(3000);
		categoryPOM.validateAddCoursetitle();
		categoryPOM.SelectCourse();
		Thread.sleep(3000);
		categoryPOM.clickaddcourse();
		Thread.sleep(3000);
		categoryPOM.clicknextstep2();
		Thread.sleep(3000);
		categoryPOM.validateSubscribeusertitle();
		categoryPOM.sendUsername("Sathyashree");
		Thread.sleep(3000);
		categoryPOM.clickusername();
		Thread.sleep(3000);
		categoryPOM.clickfinish();
	}
}
