package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardReceiverPage;
import pages.ProcessOrderReceiverPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS306_AsReceiverICanChangeOrderStatusToInSafe extends TestCaseCBCS {
	
private DashboardReceiverPage dashboardPage;
private ProcessOrderReceiverPage processOrderPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(0,2);
	}

	@Test(dataProvider = "data")
	public void changeOrderStatusToInSafeTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		
		
		using(
				dashboardPage=(DashboardReceiverPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName ,password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			 )
			
		.check(
				
				dashboardPage
				.dashboardLabelMustBePresent()
				
			   )
		
		.andUsing(
				  
				processOrderPage=dashboardPage
				.processOrderLabelClick(getWebDriver())
				.then()
				.fillInvoiceOrOrderNumberField(invoiceNumber)
				.and()
				.clickSearchButton() 
				   
				 )
				   
		   .check(
		    	 
				  processOrderPage
				  .orderNumberLabelMustBePresent(invoiceNumber, getWebDriver())
		    	 
				  )
		    	   
		  .andUsing(
				   
				   processOrderPage
				   .clickPrintAllBarcodesButton()
				   .and()
				   .clickYesButton()								   
				  )			  
		  			
		 
		   .check(
				   
				   processOrderPage
				   .checkTierStatus(invoiceNumber, orderStatus, getWebDriver())
				   
				  );
		}
	

}
