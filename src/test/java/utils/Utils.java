package utils;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import object.AdminDataInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ts.commons.Until;
import com.ts.commons.FirefoxDriver;
import com.ts.commons.Validator;

public class Utils {
	
		
	public static <T> T selectListOption(By selectorList, By selectorOption, WebDriver driver, Class<T> expectedPage){
        
        driver.findElement(selectorList).click();
        driver.findElement(selectorOption).click();
    
     return PageFactory.initElements(driver, expectedPage);
	}
 	
	public static <T> T selectDropDownOption(By selector, String option, WebDriver driver, Class<T> expectedPage){
		
		new Select(driver.findElement(selector)).selectByVisibleText(option);                 
        return PageFactory.initElements(driver, expectedPage);
    }		 	

   	public static <T> T selectBillingAddressOption(String option, WebDriver driver, Class<T> expectedPage){
		
		driver.findElement(By.xpath("//input[@id='"+option+"']")).click();                 
        return PageFactory.initElements(driver, expectedPage);
    }
	
	public static <T> T selectShippingAddressOption(String option, WebDriver driver, Class<T> expectedPage){
		
		driver.findElement(By.xpath("//input[@id='"+option+"']")).click();                 
        return PageFactory.initElements(driver, expectedPage);
    }
	
	public static <T> T clickPaymentMethodCheckbox(String option, WebDriver driver, Class<T> expectedPage){
		
		driver.findElement(By.xpath("//input[@value='"+option+"']")).click();                 
        return PageFactory.initElements(driver, expectedPage);
    }	
	
	public static void deleteUser(AdminDataInfo user, WebDriver driver){                  
        
        WebElement element;       
        while(!Utils.iselementPresent(driver, By.xpath("//tr/td/span[text()='"+user.getUserName()+"']"))){                 
        	   driver.findElement(By.xpath("//li[@class='next']")).click();             
        }            
       
       element = driver.findElement(By.xpath("//tr/td/span[text()='"+user.getUserName()+"']/../../td/a[contains(.,'Delete')]" ));
       element.click();
       
       driver.findElement(By.xpath("//button[text()='Yes']")).click();       
     
       
	}
	
	public static Validator validateOrderNumber(final String orderNumber, final WebDriver driver){
		return new Validator()
		{
			@Override
			public void Validate(){
		
				 Assert. assertTrue(driver.findElement(By.xpath("//label[contains(.,'"+orderNumber+"')]")).getText().toString().equalsIgnoreCase(orderNumber));
		
			}
		};
	}			
	
	public static Validator validateTierStatus(final String invoiceNumber, final String orderStatus, final WebDriver driver){
		return new Validator()
		{
			@Override
			public void Validate(){
		
				 Assert. assertTrue(driver.findElement(By.xpath("//td/span[text()='"+invoiceNumber+"']/../../td/span[contains(.,'"+orderStatus+"')]")).getText().toString().equalsIgnoreCase(orderStatus));
		
			}
		};
	}
	

	public static boolean iselementPresent(WebDriver driver, By by) {
	  
		try {
		  
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(by);		   
	   
			return true;		  
	   
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean waitForJQueryProcessing(final WebDriver driver) {  
		
		boolean jQcondition = false;
	      TestCaseCBCS.wait(new Until() {
	    
	    @Override
	    public boolean execute() {
	     return (Boolean) ((FirefoxDriver)driver).executeScript("return window.jQuery != undefined && jQuery.active === 0");
	    }
	   });
	   
	   return jQcondition;
	  }

	
	/*public static void waitForPageLoaded(WebDriver driver, String failMessage) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return Integer.parseInt(((JavascriptExecutor) driver)
						.executeScript("return $.active").toString()) == 0;
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 100);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			
		}
	}*/
	
	
	public static void waitForElemets(final long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException ex) {
       
        }
    }
	
	
	public static void write(WebDriver driver, String orderNumber) 
	{		
		try {
			reportGenerator(orderNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void reportGenerator(String order) throws Exception {
		new CreateAndWriteExcel ("Parameters.xls").inDirectory("src/test/resources")
		.createWorkbook(order)
		.addRow(order);
	}
	
		
	
	public static void refreshPage(WebDriver driver){
		  driver.navigate().refresh();
		
	}	
	
	public static String substringOrderNumber(String orderNumber){
		return orderNumber.substring(3, 7);
		
		
	}
	
}
