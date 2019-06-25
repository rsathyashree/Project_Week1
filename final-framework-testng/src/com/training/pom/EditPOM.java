package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPOM {
	private WebDriver driver; 
	
	public EditPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
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
