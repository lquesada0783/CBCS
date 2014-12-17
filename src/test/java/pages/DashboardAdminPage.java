package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class DashboardAdminPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Dashboard')]")
	private WebElement dashboardLabel;		
	
	@FindBy(xpath="//a[@href='admin#/searchOrderUser']")
	private WebElement submitOrderTab;	
	
	@Override
	public DashboardAdminPage and() {		
		return this;
	}

	@Override
	public DashboardAdminPage then() {		
		return this;
	}
	
	public  SubmissionPage clickSubmitOrderTab(WebDriver driver){			
		submitOrderTab.click();
		SubmissionPage submissionPage= PageFactory.initElements(driver, SubmissionPage.class);
		return submissionPage;		 
	}
	
	public Users selectOneOptionCatalogsMenue(String optionMenue, WebDriver driver){	
    	
		return utils.Utils.selectListOption(By.xpath("(//li[contains(.,'Catalogs')])[2]/a"),By.xpath("//a[text()='"+optionMenue+"']"),driver,Users.class);

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
