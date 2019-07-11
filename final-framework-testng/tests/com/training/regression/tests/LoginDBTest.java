package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.SignUpPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginDBTest {
	private WebDriver driver;
	private String baseUrl;
	private SignUpPOM signupPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		signupPOM = new SignUpPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password, String firstName, String lastName) throws InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		signupPOM.clickSignup();	
		signupPOM.ClickProfile();
		Thread.sleep(3000);
		signupPOM.sendFirstName(firstName);
		signupPOM.sendLastName(lastName);
		signupPOM.sendEmail("manzoor@gmail.com");
		signupPOM.sendUserName(userName);
		screenShot.captureScreenShot(userName);
		Thread.sleep(3000);
		signupPOM.sendPassword(password);
		screenShot.captureScreenShot("screenshot1");
		signupPOM.sendConfPassword("manzoor");
		Thread.sleep(3000);
		signupPOM.sendPhone("9876543210");
		Thread.sleep(3000);
		signupPOM.selectLanguage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		signupPOM.ClickSubmit();
		screenShot.captureScreenShot(userName);

	}

}