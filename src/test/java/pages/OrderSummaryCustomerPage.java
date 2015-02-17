package pages;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class OrderSummaryCustomerPage extends Page {	
	
	@FindBy(xpath="//h2[text()='Order Summary']")
    private WebElement orderSummaryLabel;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement iGreeTermsAndConditionsCheckbox;
	
	@FindBy(xpath="//button[@id='btnNext']")
	private WebElement nextButton;
	
	@FindBy(xpath="//input[@name='txtCouponHere']")
	private WebElement cuponField;
	
	@FindBy(xpath="//button[@name='Apply']")
	private WebElement applyButton;
	
	@FindBy(xpath="//button[text()='Accept']")
	private WebElement acceptButton;
	
	@FindBy(xpath="//div[text()='Coupon']/../..//div[text()='USD $50.00']")
	private WebElement couponLabel;	
	
	@FindBy(xpath="//div[text()='SubTotal']/../../../div/div/a[contains(.,'Remove')]")
	private WebElement removeCouponLink;	
	
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Yes']")	
	private WebElement yesButton;	
	
	@FindBy(xpath="//div[@id='operationResult' and contains(.,Coupon deleted successfully.') and @style='display: block;']")
	private WebElement deletedCouponSuccessfulMessage;
	
	@Override
	public OrderSummaryCustomerPage and() {
		return this;
	}

	@Override
	public OrderSummaryCustomerPage then() {
		return this;
	}
	
	public  OrderSummaryCustomerPage clickIGreeTermsAndConditionsCheckbox(WebDriver driver ){
		utils.Utils.iselementPresent(driver,By.xpath("//label[text()='Title of Comic: ']"));
		iGreeTermsAndConditionsCheckbox.click();		
		return this;		 
	}
	
	public  OrderSummaryCustomerPage fillCuponField(String amount, WebDriver driver ){
		
		 while(!utils.Utils.iselementPresent(driver, By.xpath("//h4[contains(.,'Invoice Number')]"))){
				utils.Utils.waitForElemets(1);
			}	
		cuponField.sendKeys(amount);		
		return this;		 
	}
	
	public  OrderSummaryCustomerPage clickApplyButton( ){
		utils.Utils.waitForElemets(2);
		applyButton.click();		
		return this;		 
	}
	
	public  OrderSummaryCustomerPage clickAcceptButton(){
		utils.Utils.waitForElemets(2);
		acceptButton.click();		
		return this;		 
	}
	
	
	public  AddressesInformationCustomerPage clickNextButton(WebDriver driver){
		utils.Utils.waitForElemets(2);	
		nextButton.click();
		AddressesInformationCustomerPage addressesInformationCustomerPage = PageFactory.initElements(driver, AddressesInformationCustomerPage.class);
		return addressesInformationCustomerPage;		 
	}
	
	public  OrderSummaryCustomerPage clickRemoveCouponLink( ){
		utils.Utils.waitForElemets(2);	
		removeCouponLink.click();		
		return this;		 
	}
	
	public  OrderSummaryCustomerPage clickYesButton( ){
		yesButton.click();
		utils.Utils.waitForElemets(2);
		return this;		 
	}
	
	 public Validator orderSummaryLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){				
					
					boolean thereIsAnOrderSummaryLabel = orderSummaryLabel !=null;
					Assert.assertTrue(thereIsAnOrderSummaryLabel);
					
				}
			};
		}
	 
		public boolean  isCouponLabelPresent( String text, WebDriver driver) {
			utils.Utils.waitForElemets(1);	
			List<WebElement> list = driver.findElements(By.xpath("//div[text()='Coupon']/../..//div[text()='"+text+"']"));

			for(WebElement element : list){
				if(element.getText().toString().equals(text))
				{
					return true;
				}
			}
			
			
			return false;
		}	
		

	 public Validator couponLabelMustBePresent(final String amount,final WebDriver driver ){
			
			return new Validator()
			{
				@Override
				public void Validate(){				
					
				Assert.assertTrue(isCouponLabelPresent(amount,driver));
					
				}
			};
		}
	 
	 public Validator couponLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){				
					
					boolean thereIsACouponLabel = couponLabel !=null;
					Assert.assertTrue(thereIsACouponLabel);
					
				}
			};
		} 

	 
	 public Validator validateSuccessfulMessageIsPresentAndCouponDoesNotMustBePresent(final WebDriver driver){		
	 
			return new Validator()
			{
				@Override
				public void Validate(){	
					
					boolean thereIsADeletedCouponSuccessfullyMessage = deletedCouponSuccessfulMessage !=null;
					Assert.assertTrue(thereIsADeletedCouponSuccessfullyMessage);
					
					Assert.assertFalse(Utils.iselementPresent(driver, By.xpath("//div[text()='Coupon']/../..//div[text()='USD $50.00']")));
					
					
				}
			};
		} 


}
