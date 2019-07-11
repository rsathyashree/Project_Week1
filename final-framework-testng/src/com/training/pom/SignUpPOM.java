package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPOM {
	private WebDriver driver; 
	
	public SignUpPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
	@FindBy(xpath="//section/div/div[2]/div[2]/div/div/div/ul/li[1]/a")
	private WebElement SignUp;
	
	@FindBy(name="firstname")
	private WebElement Firstname;
	
	@FindBy(name="lastname")
	private WebElement Lastname;
	
	@FindBy(name="email")
	private WebElement Email;
	
	@FindBy(name="username")
	private WebElement Username;
	
	@FindBy(name="pass1")
	private WebElement Password;
	
	@FindBy(name="pass2")
	private WebElement ConfPassword;
	
	@FindBy(name="phone")
	private WebElement Phone;
	
	@FindBy(name="language")
	private WebElement Language;
	
	@FindBy(xpath="//section/div/div[2]/div/form/fieldset/div/div/div[2]/label/input")
	private WebElement Profile;
	
	@FindBy(name="submit")
	private WebElement Submit;
	
		
	public void clickSignup() {
		this.SignUp.click();
	}
	
	public void ClickProfile() {
		this.Profile.click();
		
		}
	
	public void sendFirstName(String firstName) {
		this.Firstname.clear();
		this.Firstname.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.Lastname.clear();
		this.Lastname.sendKeys(lastName);
	}
	
	public void sendEmail(String email) {
		this.Email.clear();
		this.Email.sendKeys(email);
	}
	
	public void sendUserName(String username) {
		this.Username.clear();
		this.Username.sendKeys(username);
	}
	
	public void sendPassword(String password) {
		this.Password.clear();
		this.Password.sendKeys(password);
	}
	
	public void sendConfPassword(String confpassword) {
		this.ConfPassword.clear();
		this.ConfPassword.sendKeys(confpassword);
	}
	
	public void sendPhone(String phone) {
		this.Phone.clear();
		this.Phone.sendKeys(phone);
	}
	
	public void selectLanguage() {
		Select langlist = new Select(Language);
		langlist.selectByVisibleText("English");
	}
	
	public void ClickSubmit() {
		this.Submit.click();
		
		}
}
