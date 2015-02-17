package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.Utils;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class FAQPage extends Page {

	@Override
	public FAQPage and() {		
		return this;
	}

	@Override
	public FAQPage then() {		
		return this;
	}
	
	public Validator validateFAQPageIsDisplayed (final WebDriver driver){
		
		return new Validator()
		{
			@Override
			public void Validate(){	
				
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//div[@ng-switch-when='faq']/h2")));
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//strong[text()='What is certification? ']")));
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//strong[text()='How do I package my books for shipment? ']")));
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//strong[text()='How do I package my books for shipment? ']")));				
				Assert.assertTrue(Utils.iselementPresent(driver, By.xpath("//p[contains(.,'CBCS customer service at 727-803-6822')]")));
				
			}
		};

	}

}
