package com.training.pom;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CategoryPOM {
	private WebDriver driver; 
	
	public CategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
	@FindBy(xpath="//section/section[1]/div[4]/div/div[2]/div[2]/ul/li[3]/a")
	private WebElement SessCategory;
	
	@FindBy(xpath="//section/div/div[2]/div/div/a/img")
	private WebElement AddCategory;
	
	@FindBy(name="name")
	private WebElement Categoryname;
	
	@FindBy(xpath="//section/div/div[2]/div/form/div[4]/div[1]/button")
	private WebElement SubmitCategory;
	
	@FindBy(xpath="//section/div/div[2]")
	private WebElement categoryAddMessage;
	
	
	@FindBy(xpath="//section/div/div[3]/div/div/a[2]/img")
	private WebElement Sessionlist;
	
	@FindBy(xpath="//section/div/div[2]/a[1]/img")
	private WebElement AddSession;
	
	@FindBy(id="add_session_name")
	private WebElement SessionName;
	
	@FindBy(id="advanced_params")
	private WebElement Advsettings;
	
	@FindBy(xpath="//fieldset/div[5]/div[2]/div[1]/div/select")
	private WebElement Category;
	
	@FindBy(id="add_session_submit")
	private WebElement NextStep1;
	
	@FindBy(id="origin")
	private WebElement Courselist;
	
	@FindBy(name="add_course")
	private WebElement AddCourse;
	
	@FindBy(name="next")
	private WebElement NextStep2;
	
	@FindBy(id="user_to_add")
	private WebElement UserAdd;
	
	@FindBy(xpath="//section/div/form/div/div[1]/div/div/a")
	private WebElement AddUsername;
	
	@FindBy(name="next")
	private WebElement Finish;
		
	public void clickSesscat() {
		this.SessCategory.click();
	}
	
	public void validateSessCategorytitle() {
		String Actualtitle = driver.getTitle();
		/*System.out.println(Actualtitle);*/
		assertTrue(Actualtitle.contains("Sessions categories"));
		System.out.println("Navigated to the Sessions categories Page");
		
	}
	
	
	public void clickAddcat() {
		this.AddCategory.click();
	}
	
	public void validateAddCategorytitle() {
		String Actualtitle4 = driver.getTitle();
		System.out.println(Actualtitle4);
		assertTrue(Actualtitle4.contains("Add category"));
		System.out.println("Navigated to the Add Category Page");
		
	}
	
	public void sendCatname(String catName) {
		this.Categoryname.clear();
		this.Categoryname.sendKeys(catName);
		System.out.println("Adding the Category" + "\t"  + catName);
	}
	
	public void clickSubmitcat() {
		this.SubmitCategory.click();
		
	}
	
	public String getCatMessage() {
		String catmsg = this.categoryAddMessage.getText();
		System.out.println(catmsg);
		String Expmsg = "The category has been added";
		assertEquals(Expmsg, catmsg);
		System.out.println(catmsg);
		return catmsg;
	}
	
	public void clickSesslist() {
		this.Sessionlist.click();
	}
	
	public void validateSessListtitle() {
		String Actualtitle1 = driver.getTitle();
		/*System.out.println(Actualtitle1);*/
		assertTrue(Actualtitle1.contains("Session list"));
		System.out.println("Navigated to the Session list Page");
		
	}
	
	public void clickAddsession() {
		this.AddSession.click();
	}
	
	public void validateAddSesstitle() {
		String Actualtitle2 = driver.getTitle();
		/*System.out.println(Actualtitle2);*/
		assertTrue(Actualtitle2.contains("Add a training session"));
		System.out.println("Navigated to the Add a training session Page");
		
	}
	
	public void sendSessname(String sessName) {
		this.SessionName.clear();
		this.SessionName.sendKeys(sessName);
	}
	
	public void clickAdvsettings() {
		this.Advsettings.click();
	}
	
	
	public void SelectCategory() {
		Select categorylist = new Select(Category);
		categorylist.selectByVisibleText("Testing3");
	}
	
	public void clicknextstep1() {
		this.NextStep1.click();
	}
	
	public void validateAddCoursetitle() {
		String Actualtitle3 = driver.getTitle();
		System.out.println(Actualtitle3);
		assertTrue(Actualtitle3.contains("Add courses to this session"+ "(" + SessionName.getText() + ")"));
		System.out.println("Navigated to the Add courses to this session" + "(" + SessionName.getText() + ")");
		
	}
	
	public void SelectCourse() {
		Select courselist = new Select(Courselist);
		String coursename = this.SessionName.getText();
		courselist.selectByVisibleText(coursename);
	}
	
	public void clickaddcourse() {
		this.AddCourse.click();
	}
	
	public void clicknextstep2() {
		this.NextStep2.click();
	}
	
	public void validateSubscribeusertitle() {
		String Actualtitle4 = driver.getTitle();
		System.out.println(Actualtitle4);
		assertTrue(Actualtitle4.contains("Subscribe users to this session"+ "(" + SessionName.getText() + ")"));
		System.out.println("Navigated to the Subscribe users to this session" + "(" + SessionName.getText() + ")");
		
	}
	
	public void sendUsername(String userName) {
		this.UserAdd.clear();
		this.UserAdd.sendKeys(userName);
	}
	
	public void clickusername() {
		this.AddUsername.click();
	}
	
	public void clickfinish() {
		this.Finish.click();
	}
}
