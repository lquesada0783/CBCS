package pages;

import java.util.List;

import object.CustomerDataInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class AddressesInformationCustomerPage extends Page {
	
	@FindBy(xpath="//h2[contains(.,'Addresses Information')]")
    private WebElement addressesInformationLabel;
	
	@FindBy(xpath="//a[@href='' and text()='Add Billing Address']")
	private WebElement addBillingAddressLink;	
	
	@FindBy(xpath="//h2[text()='Add new billing information']")
	private WebElement newBillingLabelOnModal;	
	
	@FindBy(xpath="//h2[text()='Add new shipping information']")
	private WebElement newShippingLabelOnModal;
	
	@FindBy(xpath="//h2[text()='Edit billing information']")
	private WebElement editBillingInformationLabelOnModal;	
	
	@FindBy(xpath="//a[@href='' and text()='Add Shipping Address']")
	private WebElement addShippingAddressLink;	
	
	@FindBy(xpath="//input[@name='txtName']")
	private WebElement nameField;
	
	@FindBy(xpath="//input[@name='txtCompany']")
	private WebElement companyField;
	
	@FindBy(xpath="//input[@name='txtEmail']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='txtPhoneNumber']")
	private WebElement phoneNumberField;
	
	@FindBy(xpath="//input[@name='txtAddress']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@name='txtApptOrUnit']")
	private WebElement apptOrUnitField;
	
	@FindBy(xpath="//input[@name='txtCity']")	
	private WebElement cityField;
	
	@FindBy(xpath="//input[@name='txtZipCode']")	
	private WebElement zipCodeField;
	
	@FindBy(xpath="//input[@name='useAsShippingInformation']")
	private WebElement usebillingAsShippingCheckbox;
	
	@FindBy(xpath="//button[@data-dismiss='modal' and text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@id='btnNext']")	
	private WebElement nextButton;
	
	@FindBy(xpath="(//div[@class='col-md-12 ng-binding'])[1]")
	private WebElement usernameLabel;	
	
	@FindBy(xpath="(//div[@class='row col-md-12 rowStyle']/a[@ng-click='deleteAddressInformation(billing.BillingInfoId, true)']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary' and text()='Yes']")
	private WebElement yesButton;	
	
	@FindBy(xpath="//label[contains(.,'Pick up at CBCS')]/input")
	private WebElement pickUpAtACBCSRadio;
	
	@FindBy(xpath="//label[contains(.,'Pick up at convention')]/input")
	private WebElement pickUpAtConventionRadio;
	
	@FindBy(xpath="//button[text()='Accept']")
	private WebElement acceptButton;
	
	@Override
	public AddressesInformationCustomerPage and() {
		return this;
	}

	@Override
	public AddressesInformationCustomerPage then() {
		return this;
	}
	
   public AddressesInformationCustomerPage cleanFieldsOnAddNewBillingInformationModal(){
		
		nameField.clear();
		companyField.clear();
		emailField.clear();
		phoneNumberField.clear();
		addressField.clear();
		apptOrUnitField.clear();
		cityField.clear();
		zipCodeField.clear();
		
		return this;
	}
	
	public AddressesInformationCustomerPage fillFieldsOnAddNewBillingInformationModal(CustomerDataInfo customer, String country, String state, WebDriver driver){
		cleanFieldsOnAddNewBillingInformationModal();		
		nameField.sendKeys(customer.getName());
		companyField.sendKeys(customer.getCompany());
		emailField.sendKeys(customer.getEmail());
		phoneNumberField.sendKeys(customer.getPhoneNumber());
		addressField.sendKeys(customer.getAddress());
		apptOrUnitField.sendKeys(customer.getApptOrUnit());
		selectCountry(country,driver);
		cityField.sendKeys(customer.getCity());
		selectState(state, driver);
		zipCodeField.sendKeys(customer.getZipCode());
		
		return this;
	}
	
	
	public AddressesInformationCustomerPage fillFieldsOnAddNewBillingInformationModal(CustomerDataInfo customer, WebDriver driver){
		cleanFieldsOnAddNewBillingInformationModal();		
		nameField.sendKeys(customer.getName());
		companyField.sendKeys(customer.getCompany());
		emailField.sendKeys(customer.getEmail());
		phoneNumberField.sendKeys(customer.getPhoneNumber());
		addressField.sendKeys(customer.getAddress());
		apptOrUnitField.sendKeys(customer.getApptOrUnit());
		selectCountry(customer.getCountry(),driver);
		cityField.sendKeys(customer.getCity());
		selectState(customer.getState(), driver);
		zipCodeField.sendKeys(customer.getZipCode());
		
		return this;
	}
	
	public AddressesInformationCustomerPage fillFieldsOnAddNewBillingInformationModal(CustomerDataInfo customer,String email, WebDriver driver){
		cleanFieldsOnAddNewBillingInformationModal();		
		nameField.sendKeys(customer.getName());
		companyField.sendKeys(customer.getCompany());
		emailField.sendKeys(email);
		phoneNumberField.sendKeys(customer.getPhoneNumber());
		addressField.sendKeys(customer.getAddress());
		apptOrUnitField.sendKeys(customer.getApptOrUnit());
		selectCountry(customer.getCountry(),driver);
		cityField.sendKeys(customer.getCity());
		selectState(customer.getState(), driver);
		zipCodeField.sendKeys(customer.getZipCode());
		
		return this;
	}
	
	public AddressesInformationCustomerPage clickUsebillingAsShippingCheckbox(){		
		usebillingAsShippingCheckbox.click();
		return this;
		
	}
	
	public AddressesInformationCustomerPage fillFieldsOnAddNewShippingInformationModal(CustomerDataInfo customer,String email, WebDriver driver){
		cleanFieldsOnAddNewBillingInformationModal();		
		nameField.sendKeys(customer.getName());
		companyField.sendKeys(customer.getCompany());
		emailField.sendKeys(email);
		phoneNumberField.sendKeys(customer.getPhoneNumber());
		addressField.sendKeys(customer.getAddress());
		apptOrUnitField.sendKeys(customer.getApptOrUnit());
		selectCountry(customer.getCountry(),driver);
		cityField.sendKeys(customer.getCity());
		selectState(customer.getState(), driver);
		zipCodeField.sendKeys(customer.getZipCode());
		
		return this;
	}
	
	public AddressesInformationCustomerPage editBillingInformationOnModal(CustomerDataInfo customer, WebDriver driver){
		
		
		customer.generateNewData(customer);
		utils.Utils.waitForElemets(5);	
		
   		nameField = driver.findElement(By.xpath("//input[@name='txtName']"));
   		nameField.clear();  		
   		
   		companyField = driver.findElement(By.xpath("//input[@name='txtCompany']"));	
   		companyField.clear(); 		
   		
   		emailField = driver.findElement(By.xpath("//input[@name='txtEmail']"));	
   		emailField.clear();   		
   		
   		phoneNumberField = driver.findElement(By.xpath("//input[@name='txtPhoneNumber']"));	
   		phoneNumberField.clear();   		
   		
   		addressField = driver.findElement(By.xpath("//input[@name='txtAddress']"));	
   		addressField.clear();   		
   		
   		apptOrUnitField = driver.findElement(By.xpath("//input[@name='txtApptOrUnit']"));	
   		apptOrUnitField.clear();   	   		
   		
   		cityField = driver.findElement(By.xpath("//input[@name='txtCity']"));	
   		cityField.clear();   		
   		
   		zipCodeField = driver.findElement(By.xpath("//input[@name='txtZipCode']"));	
   		zipCodeField.clear();
   		
   		utils.Utils.waitForElemets(5);	
   		nameField.sendKeys(customer.getName());
   		companyField.sendKeys(customer.getCompany());
   		emailField.sendKeys(customer.getEmail());
   		phoneNumberField.sendKeys(customer.getPhoneNumber());
   		addressField.sendKeys(customer.getAddress());
   		apptOrUnitField.sendKeys(customer.getApptOrUnit());
   		selectCountry(customer.getCountry(),driver);
   		cityField.sendKeys(customer.getCity());
   		selectState(customer.getState(), driver);
   		zipCodeField.sendKeys(customer.getZipCode());		
		
		return this;
	}
	
	public AddressesInformationCustomerPage clickpickUpAtCBCSRadio(){		
		pickUpAtACBCSRadio.click();
		return this;
		
	}
	
	public AddressesInformationCustomerPage clickPickUpAtConventionRadio(){		
		pickUpAtConventionRadio.click();
		return this;
		
	}
	
	public AddressesInformationCustomerPage clickAcceptButton(){
		utils.Utils.waitForElemets(1);
		acceptButton.click();
		return this;
		
	}
	
	  
	public AddressesInformationCustomerPage selectAConvention(String convention, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Convention')]"),convention,driver,AddressesInformationCustomerPage.class);		
	
	}
   
		
	public AddressesInformationCustomerPage selectCountry(String country, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select Country')]"),country,driver,AddressesInformationCustomerPage.class);		
	
	}
   
    public AddressesInformationCustomerPage selectState(String state, WebDriver driver){		
		
		return utils.Utils.selectDropDownOption(By.xpath("//select[contains(.,'Select State')]"),state,driver,AddressesInformationCustomerPage.class);		
	
	}
    
	public AddressesInformationCustomerPage selectBillingAddress(String option, WebDriver driver){			
		utils.Utils.iselementPresent(driver, By.xpath("//input[@id='"+option+"']"));
		return utils.Utils.selectBillingAddressOption(option,driver,AddressesInformationCustomerPage.class);		
	
	}
	
	public AddressesInformationCustomerPage selectShippingAddress(String option, WebDriver driver){		
		
		return utils.Utils.selectShippingAddressOption(option,driver,AddressesInformationCustomerPage.class);		
	
	}
	
	 public AddressesInformationCustomerPage selectOneOptionShippingProviderDropdown(String option, WebDriver driver){	
	    	
			return utils.Utils.selectDropDownOption(By.xpath("(//select[contains(.,'Shipping Provider')])[1]"),option,driver,AddressesInformationCustomerPage.class);

	}
	 
	public  PaymentMethodCustomerPage clickNextButton(WebDriver driver){
		
		    utils.Utils.iselementPresent(driver, By.xpath("//input[@id='chkBilling1']"));
		    while(utils.Utils.iselementPresent(driver, By.xpath("//button[@id='btnNext' and @disabled='disabled']"))){
				utils.Utils.waitForElemets(1);
			}
		    nextButton.click();	
			PaymentMethodCustomerPage paymentMethodCustomerPage= PageFactory.initElements(driver, PaymentMethodCustomerPage.class);
			return paymentMethodCustomerPage;		 
	}
	
	
	public  AddressesInformationCustomerPage clickAddBillingAddressLink(WebDriver driver){		
		addBillingAddressLink.click();	
		return this;		 
    }
	
	public  AddressesInformationCustomerPage ClickAddShippingAddressLink(WebDriver driver){		
		addShippingAddressLink.click();	
		return this;		 
    }
	
	public  AddressesInformationCustomerPage clickSaveButton(){		
		utils.Utils.waitForElemets(2);	
		saveButton.click();	
		return this;		 
    }
	

   public AddressesInformationCustomerPage deleteBillingAddress(CustomerDataInfo customer, WebDriver driver){             
        
       WebElement element = driver.findElement(By.xpath("(//div[@class='col-md-12 ng-binding' and contains(.,'"+customer.getName()+"')])[1]/../..//div/../..//div/../a[text()='Delete']"));
       element.click();       
       driver.findElement(By.xpath("//button[text()='Yes']")).click(); 
       return this;
     
      	}	
   
   public AddressesInformationCustomerPage clickEditBillingAddressLink(CustomerDataInfo customer, WebDriver driver){             
       
       WebElement element = driver.findElement(By.xpath("(//div[@class='col-md-12 ng-binding' and contains(.,'"+customer.getName()+"')])[1]/../..//div/../..//div/../a[text()='Edit']"));
       element.click();          
       return this;
     
      	}	
	
	
	public Validator addressesInformationLabelMustBePresent(){
			return new Validator()
			{
				@Override
				public void Validate(){				
					
					boolean thereIsAnAddressesInformationLabel = addressesInformationLabel !=null;
					Assert.assertTrue(thereIsAnAddressesInformationLabel);
					
				}
			};
		}
	
	public Validator newBillingLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsALabelModal = newBillingLabelOnModal !=null;
				Assert.assertTrue(thereIsALabelModal);
				
			}
		};
	}
	
	public Validator newShippingLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){				
				
				boolean thereIsANewShippingLabel = newShippingLabelOnModal !=null;
				Assert.assertTrue(thereIsANewShippingLabel);
				
			}
		};
	}
	
	public boolean  isTextPresentInShippingAddress( String text, WebDriver driver) {
		utils.Utils.waitForElemets(2);	
		List<WebElement> list = driver.findElements(By.xpath("//div[@ng-repeat='shipping in shippingList']//div[@class='col-md-12 ng-binding']"));

		for(WebElement element : list){			
			if(element.getText().toString().equals(text))
			{
				return true;
			}
		}
		
		
		return false;
	}	
	
	public boolean  isTextPresentInBillingAddress( String text, WebDriver driver) {
		utils.Utils.waitForElemets(2);	
		List<WebElement> list = driver.findElements(By.xpath("//div[@ng-repeat='billing in billingList']//div[@class='col-md-12 ng-binding']"));

		for(WebElement element : list){
			if(element.getText().toString().equals(text))
			{
				return true;
			}
		}
		
		
		return false;
	}		
		
	public Validator userNameOnBillingAddressIsPressent(final String value, final WebDriver driver){
		
		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(isTextPresentInBillingAddress(value,driver));
				
			}
		};
	}
	
	public Validator userNameOnShippingAddressIsPressent(final String value, final WebDriver driver){
		
		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(isTextPresentInShippingAddress(value,driver));
				
			}
		};
	}
	
	public boolean  billingAddressDoesNotExist( CustomerDataInfo customer, WebDriver driver) {
		
		utils.Utils.waitForElemets(2);		    
		while(utils.Utils.iselementPresent(driver, By.xpath("(//div[@class='col-md-12 ng-binding' and contains(.,'"+customer.getName()+"')])[1]"))){
			
			return false;		
		} 
		return true;
		
	}
	
	public Validator validateBillingAddressDoesNotExist(final CustomerDataInfo customer, final WebDriver driver){
		
		return new Validator()
		{
			@Override
			public void Validate(){				
				
			Assert.assertTrue(billingAddressDoesNotExist(customer,driver));
				
			}
		};
	}

}
