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
import com.training.pom.EditPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProfile {

	private WebDriver driver;
	private String baseUrl;
	private NewPOM newPOM;
	private EditPOM EditPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		newPOM = new NewPOM(driver); 
		EditPOM = new EditPOM(driver);
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
		newPOM.sendUserName("manzoor");
		newPOM.sendPassword("manzoor");
		screenShot.captureScreenShot("3rdTCLoginscreen");
		newPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("3rdTCHomepage");
		Thread.sleep(3000);
		EditPOM.clickEdit();
		screenShot.captureScreenShot("3rdTCEditprofileHomepage");
		Thread.sleep(3000);
		EditPOM.Currpass("manzoor");
		EditPOM.Newpass("mehadi");
		EditPOM.Confpass("mehadi");
		screenShot.captureScreenShot("3rdTCEditprofileSave");
		EditPOM.clickSave();
		screenShot.captureScreenShot("3rdTCEditprofileAfterSave");
	}
}
