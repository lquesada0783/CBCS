package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardCustomerPage;
import pages.EventsCustomerPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_332AsCustomerICanSeeTheEventsPage extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private EventsCustomerPage eventsPage;
	
	@DataProvider
	 public Object[][] data() throws BiffException, IOException {
	        return new DataSourceXls ("Parameters.xls" ).getData(7,2);
	       
	   }  
	
	
	@Test(dataProvider = "data")
	public void asCustomerICanSeeTheEventsPageTest(String email, String password){
		
		using(
				dashboardCustomerPage=(DashboardCustomerPage) UI.goToCustomerLoginPage(getWebDriver())
				.clickLoginLink(getWebDriver())
				.then()
				.fillFieldsForLogin(email,password)
				.and()
				.clickSignInButton(getWebDriver())
				
				)
				
		 .check(
			
				 dashboardCustomerPage.welcomeLabelMustBePresent()
						
			  )
			  
		.andUsing(
				
				eventsPage=dashboardCustomerPage
				.clickEventsTab(getWebDriver())
				
				)
				
		.check(
				
				eventsPage.validateEventsIsDisplayed(getWebDriver())
			
			);
			  
		
	}

}
