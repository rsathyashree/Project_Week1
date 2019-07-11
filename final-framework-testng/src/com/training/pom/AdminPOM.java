package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPOM {
	private WebDriver driver; 
	
	public AdminPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
	@FindBy(xpath="//li[7]/a")
	private WebElement Admintab;
	
	@FindBy(xpath="/html/body/main/section/div/div[2]/div/section/section[1]/div[1]/div/div[2]/div[2]/ul/li[1]/a")
	private WebElement Users;
	
	@FindBy(name="keyword")
	private WebElement Entrybox;
	
		
	@FindBy(id="search_simple_submit")
	private WebElement Search;
	
	@FindBy(xpath="//form[2]/div/table/tbody/tr[2]/td[11]/a[6]/img")
	private WebElement Edit;
	
		
	@FindBy(id="user_edit_email")
	private WebElement Email;
	
	@FindBy(xpath="//fieldset/div[20]/div/div/label/input")
	private WebElement Active;
	
	@FindBy(id="user_edit_submit")
	private WebElement Submit;
	
	
	@FindBy(xpath="//section/div/div[2]/div/div[2]")
	private WebElement finalmessage;
		
	public void clickAdmin() {
		this.Admintab.click();
	}
	
	public void clickUsers() {
		this.Users.click();
	}
	
	public void sendUserText(String usertext) {
		this.Entrybox.clear();
		this.Entrybox.sendKeys(usertext);
	}
	
	public void clickSearch() {
		this.Search.click();
	}
	public void clickEdit() {
		this.Edit.click();
	}
	
	public void clickActive() {
		this.Active.click();
	}
	
	public void EditEmail(String useremail) throws InterruptedException {
		this.Email.clear();
		Thread.sleep(3000);
		this.Email.sendKeys(useremail);
	}
	
	public void clickSubmit() {
		this.Submit.click();
	}
	
	public String getmessage() {
		String msg = this.finalmessage.getText();
		System.out.println(msg);
		return msg;
	}
	
	
	
}
