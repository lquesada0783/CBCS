package pages;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class GradingFinalizerPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Grading')]")
	private WebElement gradingLabel;
	
	@FindBy(xpath="//button[@id='btnGrade']")
	private WebElement gradeButton;
	
	@FindBy(xpath="//div[@id='operationResult']")
	private WebElement message;
	
	@FindBy(xpath="//label[contains(.,'Book Status')]/../label[contains(.,'Finalized')]")
	private WebElement finalizedLabel;
	
	@FindBy(xpath="//div[@id='operationResult']")
	private WebElement comicUpdatedSuccessfullyLabel;
	
	@FindBy(xpath="//a[@id='lnkNext']")
	private WebElement nextLink;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backToOrderButton;
	
	@FindBy(xpath="//a[@id='lnkBack']")
	private WebElement backLink;

	@Override
	public GradingFinalizerPage and() {		
		return this;
	}

	@Override
	public GradingFinalizerPage then() {		
		return this;
	}
	
	public GradingFinalizerPage selectOneOptionGradeDropdown(String option, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Score')]"),option,driver,GradingFinalizerPage.class);
		
	}
	
    public GradingFinalizerPage selectOneOptionPageQualityDropdown(String option, WebDriver driver){	
    	
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Page Quality')]"),option,driver,GradingFinalizerPage.class);

	}
    
    public GradingFinalizerPage gradeAComic(String grade, String pageQuality, WebDriver driver){   	
		
    	utils.Utils.waitForElemets(10); 
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
    
    public BulkGradingFinalizerPage clickBackLink(WebDriver driver){
    	utils.Utils.waitForElemets(3);
        backLink.click();
        BulkGradingFinalizerPage bulkGradingFinalizerPage = PageFactory.initElements(driver, BulkGradingFinalizerPage.class);
        return bulkGradingFinalizerPage;
	} 
    
    public GradingFinalizerPage clickGradeButton(){
    	gradeButton.click();
		return this;
	} 
    
    public ProcessOrderFinalizerPage clickBackToOrderButton(WebDriver driver){
		utils.Utils.waitForElemets(3);
		backToOrderButton.click();
		ProcessOrderFinalizerPage processOrderFinalizerPage = PageFactory.initElements(driver, ProcessOrderFinalizerPage.class);
        return processOrderFinalizerPage;
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
    
    public Validator finalizedASuccessfullyLabelsMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsAComicUpdatedSuccessfullyLabel = comicUpdatedSuccessfullyLabel !=null;
				Assert.assertTrue(thereIsAComicUpdatedSuccessfullyLabel);
				
				boolean thereIsAFinalizedLabel= finalizedLabel !=null;
				Assert.assertTrue(thereIsAFinalizedLabel);
				
				
				
			}
		};
	}

}
