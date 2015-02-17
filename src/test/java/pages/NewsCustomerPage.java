package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.Utils;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class NewsCustomerPage extends Page {

	@Override
	public NewsCustomerPage and() {		
		return this;
	}

	@Override
	public NewsCustomerPage then() {		
		return this;
	}
	
	public Validator validateNewsIsDisplayed (final WebDriver driver){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//h2[@class='ng-binding']")));
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//div[@id='divImage']")));
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//div[@class='col-md-12 ng-binding']")));
			}
		};
	}

}
