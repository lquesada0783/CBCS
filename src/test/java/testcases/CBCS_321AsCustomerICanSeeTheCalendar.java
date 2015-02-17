package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardCustomerPage;
import pages.EventsCalendarPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_321AsCustomerICanSeeTheCalendar extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;	
	private EventsCalendarPage eventsCalendarPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	return new DataSourceXls("Parameters.xls").getData(7, 2);
	}	
	
	@Test(dataProvider = "data")
	public void asCustomerICanSeeEventsCalendarTest(String email, String password){
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.fillFieldsForLogin(email , password)
				.and()
				.clickSignInButton(getWebDriver())
				
				)
				
		 .check(
			
				 dashboardCustomerPage
				 .welcomeLabelMustBePresent()
						
			  )
			  
		
		.andUsing(
				
				eventsCalendarPage=dashboardCustomerPage
				.clickCalendarTab(getWebDriver())
				)
				
		.check(
						
				eventsCalendarPage
				.calendarLabelMustBePresent()
				
				);		
	}	

}
