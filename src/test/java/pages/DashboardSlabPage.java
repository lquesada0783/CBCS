package pages;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardSlabPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Dashboard')]")
	private WebElement dashboardLabel;
	
	@FindBy(xpath="//a[@href='admin#/order']")
	private WebElement processOrderLabel;

	@Override
	public DashboardSlabPage and() {
		return this;
	}

	@Override
	public DashboardSlabPage then() {
		return this;
	}
	
	public ProcessOrderSlabPage processOrderLabelClick(WebDriver driver){
		processOrderLabel.click();
		ProcessOrderSlabPage processOrderSlabPage= PageFactory.initElements(driver, ProcessOrderSlabPage.class);
		return processOrderSlabPage;		 
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
