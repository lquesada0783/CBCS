package pages;

import org.testng.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ts.commons.Page;
import com.ts.commons.Validator;

public class EventsCalendarPage extends Page {	
	
	@FindBy(xpath="//h2[text()='Events Calendar']")
	private WebElement calendarLabel;

	@Override
	public EventsCalendarPage and() {
		
		return this;
	}

	@Override
	public EventsCalendarPage then() {
		
		return this;
	}
	
	
	public Validator calendarLabelMustBePresent(){
		return new Validator()
		{
			@Override
			public void Validate(){	
					
				boolean thereIsACalendarLabel = calendarLabel !=null;
				Assert.assertTrue(thereIsACalendarLabel);
				
			}
		};
	}	

}
