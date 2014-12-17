package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class BulkGradingGraderPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Bulk Grading')]")
	private WebElement bulkGradingLabel;
	
	@FindBy(xpath="//a[@id='lnkNext']")
	private WebElement nextTierButton;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;
	
	@Override
	public BulkGradingGraderPage and() {		
		return this;
	}

	@Override
	public BulkGradingGraderPage then() {		
		return this;
	}
	
	public GradingGraderPage clickViewLink(String comicNumber, WebDriver driver){
		utils.Utils.waitForElemets(1);
		WebElement element = driver.findElement(By.xpath("//td/span[text()='"+comicNumber+"']/../../td/a[text()='View']"));	
		element.click();
		GradingGraderPage gradingGraderPage = PageFactory.initElements(driver, GradingGraderPage.class);
		return gradingGraderPage;
	}
		
	 public ProcessOrderGraderPage clickBackToOrderButton(WebDriver driver){
		utils.Utils.waitForElemets(3);
		backToOrderButton.click();
        ProcessOrderGraderPage processOrderGraderPage = PageFactory.initElements(driver, ProcessOrderGraderPage.class);
        return processOrderGraderPage;
	}	 
	
	public Validator bulkGradingLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
							
				boolean thereIsABulkGradingLabel = bulkGradingLabel !=null;
				Assert.assertTrue(thereIsABulkGradingLabel);
				
			}
		};
	}

}
