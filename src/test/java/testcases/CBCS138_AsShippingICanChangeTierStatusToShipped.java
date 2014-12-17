package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardShippingPage;
import pages.ProcessOrderShippingPage;
import pages.TierDetailsShippingPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS138_AsShippingICanChangeTierStatusToShipped extends TestCaseCBCS {
	
	private DashboardShippingPage dashboardShippingPage;
	private ProcessOrderShippingPage processOrderShippingPage;
	private TierDetailsShippingPage tierDetailsShippingPage;
	
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(5, 2);
	}	
	
	@Test(dataProvider = "data")
	public void changeTierStatusToShippedTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus,String trackingNumber, String role) {
		
		using(
				dashboardShippingPage=(DashboardShippingPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName ,password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			
		 .check(
					
				 dashboardShippingPage
				.dashboardLabelMustBePresent()
				
			   )
			   
		 .andUsing(
				 
				 processOrderShippingPage=dashboardShippingPage
				 .clickProcessOrderLabel(getWebDriver())
				 .then()
				 .fillInvoiceOrOrderNumberField(invoiceNumber)
				 .and()
				 .clickSearchButton()				 
				 				 
				 )				 
				 
		  .check(
				  
				  processOrderShippingPage
				  .validateOrderNumber(invoiceNumber, getWebDriver())				
				 
				 )
				 
		   .andUsing(
				   
				   tierDetailsShippingPage=processOrderShippingPage
				   .clickDetailsLink(invoiceNumber, getWebDriver())
				   
				   )
				   
		   .check(
					
				  tierDetailsShippingPage
				 .tierDetailsLabelMustBePresent()
					
				)
				
		   .andUsing(
				   
				   tierDetailsShippingPage
				   .clickChangeStatusButton(getWebDriver())
				   
				   )
				   
		  .check(
				  
				tierDetailsShippingPage
				.tierWasChangedToShippingMessageLabelMustBePresent())
				
				
		   .andUsing(
				   
				   tierDetailsShippingPage
				   .fillTrackingNumberField(trackingNumber, getWebDriver())
				   .clickSaveTrackingNumberButton() 
				   
				   
				    )
				    
		   .check(
				  
				   tierDetailsShippingPage
				  .trakingSuccessfullyMessageLabelMustBePresent()
				   
				  )
			
			.andUsing(
					
					tierDetailsShippingPage
					.clicknotifyClientButton()
					
					 )
			 
			.check(
					
					tierDetailsShippingPage
					.sendNotificationMessageLabelMustBePresent()
				   
				
				 )
				 
			.andUsing(
					
					processOrderShippingPage=tierDetailsShippingPage
					.clickBackButton(getWebDriver())
					
					)
			
		    .check(
		    		
		    		processOrderShippingPage
					.checkTierStatus(invoiceNumber, orderStatus, getWebDriver())
					
		    		
		    	);
		
	}					

}
