package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardQCPage;
import pages.ProcessOrderQCPage;
import pages.TierDetailsQCPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_86AsQCICanMarkATierLikeShipping extends TestCaseCBCS {
	
	private DashboardQCPage dashboardQCPage;
	private ProcessOrderQCPage processOrderQCPage;
	private TierDetailsQCPage tierDetailsQCPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(4, 2);
	}	
		
	@Test(dataProvider = "data", dependsOnGroups={"printLabelsOfAllComicBooks"},groups={"markATierLikeQCFinished"})
	public void asQCICanMarkATierLikeQCFinishedTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		using(
				dashboardQCPage=(DashboardQCPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName ,password)
				.and()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			
		 .check(
					
				 dashboardQCPage
				.dashboardLabelMustBePresent()
				
			   )
			   
		 .andUsing(
				 
				 processOrderQCPage=dashboardQCPage
				 .processOrderLabelClick(getWebDriver())
				 .then()
				 .fillInvoiceOrOrderNumberField(CBCS_316AsCustomerICanCreateAOrder.orderNumber)
				 .and()
				 .clickSearchButton()				 
				 				 
				 )				 
				 
		  .check(
				  
				  processOrderQCPage
				  .validateOrderNumber(CBCS_316AsCustomerICanCreateAOrder.orderNumber, getWebDriver())				
				 
				 )
				 
		   .andUsing(
				   
				   tierDetailsQCPage=processOrderQCPage
				   .clickDetailsLink(tier, getWebDriver())
				   
				   )
				   
		   .check(
					
				  tierDetailsQCPage
				 .tierDetailsLabelMustBePresent()
					
				)
				
				
		   .andUsing(
				   
				   tierDetailsQCPage
				   .clickQCFinishedCheckbox(getWebDriver())
				   .and()
				   .clickSentToShippingButton(getWebDriver())
				   
				    )
				    
		   .check(
				  
				  tierDetailsQCPage
				  .messageLabelMustBePresent()
				   
				  )
			
			.andUsing(
					
					processOrderQCPage=tierDetailsQCPage
					.clickBackToOrderButton(getWebDriver())
					 
					 )
			 
			.check(
					
				processOrderQCPage
				.checkTierStatus(CBCS_316AsCustomerICanCreateAOrder.orderNumber, orderStatus, getWebDriver())
				
				 );		
		
		
	}

}
