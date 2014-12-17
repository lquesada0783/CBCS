package pages;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardShippingPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Dashboard')]")
	private WebElement dashboardLabel;
	
	@FindBy(xpath="//a[@href='admin#/order']")
	private WebElement processOrderLabel;

	@Override
	public DashboardShippingPage and() {		
		return this;
	}

	@Override
	public DashboardShippingPage then() {		
		return this;
	}
	
	public ProcessOrderShippingPage clickProcessOrderLabel(WebDriver driver){
		processOrderLabel.click();
		ProcessOrderShippingPage processOrderShippingPage= PageFactory.initElements(driver, ProcessOrderShippingPage.class);
		return processOrderShippingPage;		 
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
