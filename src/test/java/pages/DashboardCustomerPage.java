package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardCustomerPage extends Page {
	
	@FindBy(xpath="//a[contains(.,'Welcome,')]")
	private WebElement welcomeLabel;
	
	@FindBy(xpath="//div/a[text()='SUBMIT YOUR COMIC']")
	private WebElement submitYourComicTab;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccountTab;
	
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement calendarTab;
	
	@FindBy(xpath="//a[@href='#/news/' and text()='News']")
	private WebElement newsTab;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[@href='#/events' and text()='Events']")
	private WebElement eventsTab;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[@href='#/about/faq/' and text()='FAQ']")
	private WebElement faqTab;

	@Override
	public DashboardCustomerPage and() {
		return this;
	}

	@Override
	public DashboardCustomerPage then() {
		return this;
	}
	
	public SubmitYourComicPage clickSubmitYourComicTab(WebDriver driver){				
		utils.Utils.waitForElemets(1);
		submitYourComicTab.click();		
		SubmitYourComicPage submitYourComicPage= PageFactory.initElements(driver, SubmitYourComicPage.class);
		return submitYourComicPage;		 
	}
	
	public MyAccountPage clickMyAccountTab(WebDriver driver){		
		utils.Utils.waitForElemets(1);			
		myAccountTab.click();		
		MyAccountPage myAccountPage= PageFactory.initElements(driver, MyAccountPage.class);
		return myAccountPage;		 
	}
	
	public EventsCalendarPage clickCalendarTab(WebDriver driver){		
		utils.Utils.waitForElemets(1);			
		calendarTab.click();		
		EventsCalendarPage eventsCalendarPage= PageFactory.initElements(driver, EventsCalendarPage.class);
		return eventsCalendarPage;		 
	}
	
	public NewsCustomerPage clickNewsTab(WebDriver driver){		
		utils.Utils.waitForElemets(1);			
		newsTab.click();		
		NewsCustomerPage newsCustomerPage= PageFactory.initElements(driver, NewsCustomerPage.class);
		return newsCustomerPage;		 
	}
	
	public EventsCustomerPage clickEventsTab(WebDriver driver){		
		utils.Utils.waitForElemets(1);			
		eventsTab.click();		
		EventsCustomerPage eventsCustomerPage= PageFactory.initElements(driver, EventsCustomerPage.class);
		return eventsCustomerPage;		 
	}
	
	public FAQPage clickFAQTab(WebDriver driver){		
		utils.Utils.waitForElemets(1);			
		faqTab.click();		
		FAQPage faqPage = PageFactory.initElements(driver, FAQPage.class);
		return faqPage;		 
	}
	
	public Validator welcomeLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsAWelcomeLabel = welcomeLabel !=null;
				Assert.assertTrue(thereIsAWelcomeLabel);
				
			}
		};
	}	

}
