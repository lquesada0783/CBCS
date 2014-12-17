package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ts.commons.FirefoxDriver;
import com.ts.commons.TestCaseUtil;

public class TestCaseCBCS extends TestCaseUtil {
	
	protected FirefoxDriver driver = null;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		   String path = "C:\\Downloads\\";
		      profile.setPreference("browser.download.folderList", 2);
		      profile.setPreference("browser.download.dir", path);
		      profile.setPreference("browser.helperApps.neverAsksaveToDisk", "application/x-msexcel,application/excel,application/x-excel,application/excel,application/x-excel,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel");
		      driver = new FirefoxDriver(profile);
		
		//driver = new FirefoxDriver();
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
