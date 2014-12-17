package pages;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardQCPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Dashboard')]")
	private WebElement dashboardLabel;
	
	@FindBy(xpath="//a[@href='admin#/order']")
	private WebElement processOrderLabel;


	@Override
	public DashboardQCPage and() {
		return this;
	}

	@Override
	public DashboardQCPage then() {
		return this;
	}
	
	public ProcessOrderQCPage processOrderLabelClick(WebDriver driver){
		processOrderLabel.click();
		ProcessOrderQCPage processOrderQCPage= PageFactory.initElements(driver, ProcessOrderQCPage.class);
		return processOrderQCPage;		 
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
