package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class BulkGradingFinalizerPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Bulk Grading')]")
	private WebElement bulkGradingLabel;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;

	@Override
	public BulkGradingFinalizerPage and() {		
		return this;
	}

	@Override
	public BulkGradingFinalizerPage then() {		
		return this;
	}
	
	
	public GradingFinalizerPage clickViewLink(String comicNumber, WebDriver driver){
			utils.Utils.waitForElemets(1);
			WebElement element = driver.findElement(By.xpath("//td/span[text()='"+comicNumber+"']/../../td/a[text()='View']"));	
			element.click();
			GradingFinalizerPage gradingFinalizerPage = PageFactory.initElements(driver, GradingFinalizerPage.class);
			return gradingFinalizerPage;
	}
	
	 public ProcessOrderFinalizerPage clickBackToOrderButton(WebDriver driver){
			utils.Utils.waitForElemets(3);
			backToOrderButton.click();
			ProcessOrderFinalizerPage processOrderFinalizerPage = PageFactory.initElements(driver, ProcessOrderFinalizerPage.class);
	        return processOrderFinalizerPage;
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
