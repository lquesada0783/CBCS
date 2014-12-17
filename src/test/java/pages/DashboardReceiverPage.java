package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardReceiverPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Dashboard')]")
	private WebElement dashboardLabel;
	
	@FindBy(xpath="//a[@href='admin#/order']")
	private WebElement processOrderLabel;
	
	@Override
	public DashboardReceiverPage and() {		
		return this;
	}

	@Override
	public DashboardReceiverPage then() {		
		return this;
	}	
	
	public ProcessOrderReceiverPage processOrderLabelClick(WebDriver driver){
		processOrderLabel.click();
		ProcessOrderReceiverPage processOrderReceiverPage= PageFactory.initElements(driver, ProcessOrderReceiverPage.class);
		return processOrderReceiverPage;		 
	}	
	
	public Validator dashboardLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){
				
				boolean thereIsADashboardLabel = dashboardLabel !=null;
				Assert.assertTrue(thereIsADashboardLabel);
				
			}
		};
	}	

}
