package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class GradingGraderPage extends Page {	
	

	@FindBy(xpath="//h1[contains(.,'Grading')]")
	private WebElement gradingLabel;
	
	@FindBy(xpath="//button[@id='btnGrade']")
	private WebElement gradeButton;
	
	@FindBy(xpath="//label[contains(.,'Book Status')]/../label[contains(.,'Graded')]")
	private WebElement gradedLabel;
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,'Comic updated successfully.') and @style='display: block;']")
	private WebElement comicUpdatedSuccessfullyMessage;
	
	@FindBy(xpath="//a[@id='lnkNext']")
	private WebElement nextLink;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backLink;	
	
	@Override
	public GradingGraderPage and() {		
		return this;
	}

	@Override
	public GradingGraderPage then() {		
		return this;
	}
	
	public GradingGraderPage selectOneOptionGradeDropdown(String grade, WebDriver driver){		
			
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Score')]"),grade,driver,GradingGraderPage.class);
		
	}
	
    public GradingGraderPage selectOneOptionPageQualityDropdown(String pageQuality, WebDriver driver){	
    	
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Page Quality')]"),pageQuality,driver,GradingGraderPage.class);

	}
  
    
    public GradingGraderPage gradeAComic(String grade, String pageQuality, WebDriver driver){   	
    		
    	    utils.Utils.waitForElemets(5); 
    	   	while(nextLink.isDisplayed()){    	   		
    	   		utils.Utils.waitForElemets(10); 
    	   		selectOneOptionGradeDropdown( grade,driver);	
    	   		selectOneOptionPageQualityDropdown( pageQuality,driver);    	   		
    	   		gradeButton.click();  		
    	   		
    	   		nextLink = driver.findElement(By.xpath("//a[@id='lnkNext']"));	
    	   		nextLink.click();
    	   		
    	   		gradeButton = driver.findElement(By.xpath("//button[@id='btnGrade']"));
    	   		nextLink= driver.findElement(By.xpath("//a[@id='lnkNext']"));    	   		
    	   	    utils.Utils.waitForElemets(10);    	   		
    	   		
    	  }
    	
    	   	selectOneOptionGradeDropdown( grade,driver);	
    	   	selectOneOptionPageQualityDropdown( pageQuality,driver);
    	   	gradeButton.click();     	
    	   	return this;      
    }

    public BulkGradingGraderPage clickBackLink(WebDriver driver){
    	utils.Utils.waitForElemets(3);
        backLink.click();
        BulkGradingGraderPage bulkGradingGraderPage = PageFactory.initElements(driver, BulkGradingGraderPage.class);
        return bulkGradingGraderPage;
	} 
    
    public GradingGraderPage clickGradeButton(){
    	gradeButton.click();
		return this;
	} 
    
    
    public Validator gradingLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){			
			
				boolean thereIsAGradingLabel = gradingLabel !=null;
				Assert.assertTrue(thereIsAGradingLabel);		
				
			}
		};
	}
    
    public Validator gradedASuccessfullyMessageMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
					
				boolean thereIsAComicUpdatedSuccessfullyMessage = comicUpdatedSuccessfullyMessage !=null;
				Assert.assertTrue(thereIsAComicUpdatedSuccessfullyMessage);
				
				boolean thereIsAGradedLabel = gradedLabel !=null;
				Assert.assertTrue(thereIsAGradedLabel);
				
				
				
			}
		};
	}
        	
}
