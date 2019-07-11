package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPOM {
	private WebDriver driver; 
	
	public ReportPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
	@FindBy(xpath="//nav/div/div[2]/ul[1]/li[4]/a")
	private WebElement Reportingtab;
	
	@FindBy(xpath="//*[contains(text(), 'Followed students')]")
	private WebElement Followstu;
	
	@FindBy(id="search_user_keyword")
	private WebElement Keyword;
	
	@FindBy(id="search_user_submit")
	private WebElement Search;
	
	@FindBy(xpath="//section/div/div[3]/table/tbody/tr[2]/td[5]/a[2]/img")
	private WebElement Arrowuser;
	
	@FindBy(xpath="//section/div/div[7]/table/tbody/tr[1]/td[7]/a/img")
	private WebElement Arrowcourse;
	
	@FindBy(xpath="//section/div/div[8]/table/tbody/tr/td[5]/a/img")
	private WebElement Test;
	
	@FindBy(name="send_notification")
	private WebElement Sendemail;
	
	@FindBy(id="form-email_submit")
	private WebElement Correcttest;
	
	@FindBy(xpath="//section/div/ul/li[1]/a")
	private WebElement Sessionlink;
		
	public void clickReporting() {
		this.Reportingtab.click();
	}
	
	public void clickFollowstu() {
		this.Followstu.click();
	}
	
	public void SendStuname(String stuname)  {
		this.Keyword.clear();		
		this.Keyword.sendKeys(stuname);
	}
	
	public void clickSearch() {
		this.Search.click();
	}
	
	public void clickArrowuser() {
		this.Arrowuser.click();
	}
	
	public void clickArrowcourse() {
		this.Arrowcourse.click();
	}
	
	public void clickTest() {
		this.Test.click();
	}
	
	public void clickSendemail() {
		this.Sendemail.click();
	}
	
	public void clickCorrecttest() {
		this.Correcttest.click();
	}
	
	public void clickSessionlink() {
		this.Sessionlink.click();
	}
}
