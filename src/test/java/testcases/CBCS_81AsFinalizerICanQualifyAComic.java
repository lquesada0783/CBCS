package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.BulkGradingFinalizerPage;
import pages.DashboardFinalizerPage;
import pages.GradingFinalizerPage;
import pages.ProcessOrderFinalizerPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_81AsFinalizerICanQualifyAComic extends TestCaseCBCS {
	
	private DashboardFinalizerPage dashboardFinalizerPage;
	private ProcessOrderFinalizerPage processOrderPage;
	private BulkGradingFinalizerPage bulkGradingFinalizerPage;
	private GradingFinalizerPage gradingFinalizerPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(2, 2);
	}	
	
	@Test(dataProvider = "data", dependsOnGroups={"changeTierStatusToGraded"},groups={"FinalizerICanQualifyAComic"})
	public void asFinalizerICanQualifyAComicTest (String userName, String password, String enviroment, String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality,String orderStatus, String role) {
		
		using(
				dashboardFinalizerPage=(DashboardFinalizerPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.then()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			  
		 .check(
				dashboardFinalizerPage
				.dashboardLabelMustBePresent()
					
				)
				  
		.andUsing(
				
				processOrderPage=dashboardFinalizerPage
				.processOrderLabelClick(getWebDriver()))
				
		.check(
				  processOrderPage
				 .processOrderLabelMustBePresent()	
				 
				)
				
		.andUsing(
				
				processOrderPage				
				.fillInvoiceOrOrderNumberField(CBCS_316AsCustomerICanCreateAnOrder.orderNumber)
				.and()
				.clickSearchButton()
					 
				 )
					  
		  .check(
				  processOrderPage
				  .orderNumberLabelMustBePresent(CBCS_316AsCustomerICanCreateAnOrder.orderNumber, getWebDriver())				
				)
		   
		.andUsing(
				   
				  bulkGradingFinalizerPage=processOrderPage
				  .clickDetailsLink(CBCS_316AsCustomerICanCreateAnOrder.orderNumber, getWebDriver())	
				   
				   )
			
		 .check(
				 
		    	bulkGradingFinalizerPage
		    	.bulkGradingLabelMustBePresent()
		    		
		    
				)
		    	  
		 .andUsing(
 		    		 
 		    	 gradingFinalizerPage=bulkGradingFinalizerPage
 		    	.clickViewLink(comicNumber, getWebDriver())
 		    		 		    		 
 		    	 )
 		    		 
 		    		 
 		  .check(
 		    		
 		    	gradingFinalizerPage
 		    	.gradingLabelMustBePresent()
 		    		
		    	 )
		    	  
		 .andUsing(
				    		
				    bulkGradingFinalizerPage=gradingFinalizerPage
				    .gradeAComic(grade, pageQuality, getWebDriver())	
				    .and()
				    .clickBackLink(getWebDriver())
				    		
				    )
				    		
		  .check(
				    		 
				  bulkGradingFinalizerPage
				 .bulkGradingLabelMustBePresent()		    		 
				    		 
				 )
				    		 
				    		 
		   .andUsing(
				    		
				    processOrderPage=bulkGradingFinalizerPage
				    .clickBackToOrderButton(getWebDriver())
				    		
				    )
				    		
		     .check(
				    	
				   processOrderPage
				    .checkTierStatus(CBCS_316AsCustomerICanCreateAnOrder.orderNumber, orderStatus, getWebDriver())
				    	
				    );
			}

}
