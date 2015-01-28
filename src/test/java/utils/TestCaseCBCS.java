package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;

public class TestCaseCBCS extends TestCaseUtil {
	
	protected WebDriver driver = null;
	//protected FirefoxDriver driver = null;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();		 
		
		//driver = new FirefoxDriver();
			
		driver = new FirefoxDriver(profile);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize(); 
	   
	 }
	   
	@AfterMethod
	public void close(){		
		driver.close();
		driver.quit();
	}
	
	public WebDriver getWebDriver(){		
		return driver;
	}

}
