package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPOM {
	private WebDriver driver; 
	
	public NewPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div/following-sibling::nav/div/div[2]/ul[2]/li[2]/a")
	private WebElement toggle;
	
	@FindBy(id="logout_button")
	private WebElement logout;
	
	@FindBy(xpath="//section/div/div[2]/div[2]/div/div[2]/div/div[2]/div/ul//li[5]/a")
	private WebElement Editprof;
	
	@FindBy(id="profile_password0")
	private WebElement currpass;
	
	@FindBy(id="password1")
	private WebElement newpass;
	
	@FindBy(id="profile_password2")
	private WebElement confpass;
	
	@FindBy(name="apply_change")
	private WebElement save;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickToggle(){
		this.toggle.click();
	}
	public void clickLogout() {
		this.logout.click();
	}
	
	public void clickEdit() {
		this.Editprof.click();
	}
	
	public void Currpass(String currpass) {
		this.currpass.clear();
		this.currpass.sendKeys(currpass);
	}
	
	public void Newpass(String newpass) {
		this.newpass.clear();
		this.newpass.sendKeys(newpass);
	}
	
	public void Confpass(String confpass) {
		this.confpass.clear();
		this.confpass.sendKeys(confpass);
	}
	
	public void clickSave() {
		this.save.click();
	}
}
