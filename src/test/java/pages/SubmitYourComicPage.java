package pages;

import org.testng.Assert;

import object.OrderDataInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class SubmitYourComicPage extends Page {
	
	
	@FindBy(xpath="//h2[text()='Submit your Comic']")
	private WebElement submitYourComicLabel;
	
	@FindBy(xpath="//input[@name='txtTitleComic' and not(@disabled)]")
	private WebElement titleComicField;	
		
	@FindBy(xpath="(//input[@name='txtIssueNumber'])[1]")
	private WebElement issueNumberField;
	
	@FindBy(xpath="(//input[@name='txtYear'])[1]")
	private WebElement yearField;
	
	@FindBy(xpath="(//input[@name='txtPublisher'])[1]")
	private WebElement publisherField;
	
	@FindBy(xpath="(//input[@name='txtVariant'])[1]")
	private WebElement variantField;
	
	@FindBy(xpath="(//input[@name='txtQuantity'])[1]")
	private WebElement quantityField;
	
	@FindBy(xpath="(//input[@name='txtInsuranceValue'])[1]")
	private WebElement insuranceValueField;	
	
	@FindBy(xpath="(//label[@class='labelStyle' and text()='Grade Screening']/../../div/label[contains(.,'Yes')])[1]")
	private WebElement gradeScreeningCheckbox;
	
	@FindBy(xpath="(//label[text()='Fast Pass']/../..//input)[1]")
	private WebElement fastPassCheckbox;
	
	@FindBy(xpath="(//label[text()='Slideshow']/../..//input)[1]")
	private WebElement slideshowCheckbox;
	
	@FindBy(xpath="(//label[text()='Image']/../..//input)[1]")
	private WebElement imageCheckbox;
	
	@FindBy(xpath="(//label[text()='Verified Signature']/../..//input)[1]")
	private WebElement verifiedSignatureCheckbox;

	@FindBy(xpath="(//label[text()='Authenticated Signature']/../..//input)[1]")
	private WebElement authenticatedSignatureCheckbox;
	
	@FindBy(xpath="//button[@name='Save']")
	private WebElement nextButton;	
	
	
	@Override
	public SubmitYourComicPage and() {
		return this;
	}

	@Override
	public SubmitYourComicPage then() {
		return this;
	}
	
	public SubmitYourComicPage fillAllFields(OrderDataInfo order, String pedigree, String tier, WebDriver driver){
		utils.Utils.iselementPresent(driver, By.xpath("(//label[text()='Comic Title'])[1]"));
		
		titleComicField.sendKeys(order.getComicTitle());
		issueNumberField.sendKeys(order.getIssueNumber());
		yearField.sendKeys(order.getYear());
		publisherField.sendKeys(order.getPublisher());
		variantField.sendKeys(order.getVariant());
		selectOneOptionPedigreeDropdown(pedigree, driver);
		selectOneOptionTierDropdown(tier, driver);
		quantityField.clear();
		quantityField.sendKeys(order.getQty());
		insuranceValueField.sendKeys(order.getInsuredValue());		
		return this;		
	}
	
	public SubmitYourComicPage fillAllFieldsWithDataForTierRules(OrderDataInfo order, String qtyComics,String issueNumber, String year, String isuredValue, WebDriver driver){
		utils.Utils.iselementPresent(driver, By.xpath("(//label[text()='Comic Title'])[1]"));
		titleComicField.sendKeys(order.getComicTitle());
		issueNumberField.sendKeys(issueNumber);
		yearField.sendKeys(year);
		publisherField.sendKeys(order.getPublisher());
		variantField.sendKeys(order.getVariant());		
		quantityField.clear();
		quantityField.sendKeys(qtyComics);
		insuranceValueField.sendKeys(isuredValue);		
		return this;		
	}
	

	public SubmitYourComicPage selectOneOptionPedigreeDropdown(String option, WebDriver driver){		
			
		return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'Select Pedigree')])[1]"),option,driver,SubmitYourComicPage.class);
			
	}
	   
	public SubmitYourComicPage selectOneOptionTierDropdown(String option, WebDriver driver){		
			
		WebElement tierdropdown=driver.findElement(By.xpath("//select[contains(.,'Select Tier') and not(@disabled)]"));
		
		for(WebElement optionE : tierdropdown.findElements(By.tagName("option")))
		{
				if(optionE.getText().equals(option))		
			{
				optionE.click();
				break;
			}
			
		}
			return this;
		
		
	  // return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Tier') and not(@disabled)]"),option,driver,SubmitYourComicPage.class);
		
	}
	
	public  OrderSummaryCustomerPage clickNextButton(WebDriver driver){
		nextButton.click();
		OrderSummaryCustomerPage orderSummaryCustomerPage= PageFactory.initElements(driver, OrderSummaryCustomerPage.class);
		return orderSummaryCustomerPage;		 
	}
	
	public  SubmitYourComicPage clickGradeScreeningCheckbox(WebDriver driver){
		gradeScreeningCheckbox.click();		
		return this;		 
	}
	
	public SubmitYourComicPage selectOneOptionGradeScreeningDropdown(String option, WebDriver driver){	
	    	
			return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'?')])[1]"),option,driver,SubmitYourComicPage.class);

	}
	
	public  SubmitYourComicPage clickFastPassCheckbox(WebDriver driver){
		fastPassCheckbox.click();		
		return this;		 
	}
	
	public  SubmitYourComicPage clickSlideshowCheckbox(WebDriver driver){
		slideshowCheckbox.click();		
		return this;		 
	}
	
	public  SubmitYourComicPage clickImageCheckbox(WebDriver driver){
		imageCheckbox.click();		
		return this;		 
	}
	
	public Validator submitYourComicLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsASubmitYourComicLabel = submitYourComicLabel !=null;
				Assert.assertTrue(thereIsASubmitYourComicLabel);
				
			}
		};
	}	
	
	public Validator validateExpandedCustomerLabelsAreCorrect(final WebDriver driver, final String amountFastPass,final String amountVideo,final String amountImage,final String amountSubTotal){
		
		return new Validator()
		{
			@Override
			public void Validate(){					
				
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountFastPass+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountVideo+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountImage+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalStyle ng-binding' and text()='"+amountSubTotal+"']")).isDisplayed());	
	
			}
		};
	}	
	
	public Validator validateTooltip(final WebDriver driver, final String amountFastPass,final String amountVideo,final String amountImage,final String amountSubTotal){
		
		return new Validator()
		{
			@Override
			public void Validate(){					
				
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountFastPass+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountVideo+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalVideoStyle ng-binding' and text()='"+amountImage+"']")).isDisplayed());	
				Assert.assertTrue(driver.findElement(By.xpath("//div[@class='subTotalStyle ng-binding' and text()='"+amountSubTotal+"']")).isDisplayed());	
	
			}
		};
	}	
}
