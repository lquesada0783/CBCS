package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.OrderDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardCustomerPage;
import pages.SubmitYourComicPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_322ValidateTooltipOnSubmissionPage extends TestCaseCBCS {
	
	private DashboardCustomerPage dashboardCustomerPage;
	private SubmitYourComicPage submitYourComicPage;
		
	@DataProvider
	 public Object[][] data() throws BiffException, IOException {
	        return new DataSourceXls ("Parameters.xls" ).getData(8,2);
	       
	   }  
	
	@Test(dataProvider = "data")
	public void asCustomerICanCreateAOrderTest(String email, String password, String qtyComics, String amountCoupon, String pedigree, String tier,String billing, String shipping, String provider, String paymentMethod){
		
	
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
				
				submitYourComicPage=dashboardCustomerPage
				.clickSubmitYourComicTab(getWebDriver())
				
				)
				
		.check(
				
				submitYourComicPage.submitYourComicLabelMustBePresent()
				
				);
		}


}
