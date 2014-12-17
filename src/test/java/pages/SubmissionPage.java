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

public class SubmissionPage extends Page {
	
	@FindBy(xpath="//h1[contains(.,'Submission')]")
	private WebElement submissionLabel;
	
	@FindBy(xpath="//input[@id='searchId']")
	private WebElement searchUserField;
	
	@FindBy(xpath="//input[@id='txtPaperOrderNumber']")
	private WebElement paperSubmissionInvoiceField;
	
	@FindBy(xpath="(//input[@name='txtTitleComic'])[1]")
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
	
	//@FindBy(xpath="(//label[text()='Grade Screening']/../..//input)[1]")
	//private WebElement gradeScreeningCheckbox;
	
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
	
	@FindBy(xpath="//a[contains(.,'7524-Test Collector-qatestcecro@gmail.com')]")
	private WebElement typeUserOption;	
	
	@Override
	public SubmissionPage and() {
		return this;
	}

	@Override
	public SubmissionPage then() {
		return this;
	}
	
	public SubmissionPage fillAllFields(OrderDataInfo order, String pedigree, String tier, WebDriver driver){
		searchUserField.sendKeys(order.getTypeUser());
		//typeUserOption.click();
		titleComicField.sendKeys(order.getComicTitle());
		issueNumberField.sendKeys(order.getIssueNumber());
		yearField.sendKeys(order.getYear());
		publisherField.sendKeys(order.getPublisher());
		variantField.sendKeys(order.getVariant());
		selectOneOptionPedigreeDropdown(pedigree, driver);
		selectOneOptionTierDropdown(tier, driver);
		//quantityField.sendKeys(order.getQty());
		insuranceValueField.sendKeys(order.getInsuredValue());		
		return this;		
	}
	
	public  OrderSummaryPage clickNextButton(WebDriver driver){
		nextButton.click();
		OrderSummaryPage orderSummaryPage= PageFactory.initElements(driver, OrderSummaryPage.class);
		return orderSummaryPage;		 
	}
	
   public SubmissionPage selectOneOptionPedigreeDropdown(String option, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'Select Pedigree')])[1]"),option,driver,SubmissionPage.class);
		
	}
   
   public SubmissionPage selectOneOptionTierDropdown(String option, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'Select Tier')])[1]"),option,driver,SubmissionPage.class);
		
	}   
   
   public Validator submissionLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsASubmissionLabel = submissionLabel !=null;
				Assert.assertTrue(thereIsASubmissionLabel);
				
			}
		};
	}	

}
