package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.BulkGradingGraderPage;
import pages.DashboardGraderPage;
import pages.GradingGraderPage;
import pages.ProcessOrderGraderPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS309_AsGraderICanChangeTierStatusToGraded extends TestCaseCBCS {
	
	private DashboardGraderPage dashboardGraderPage;
	private ProcessOrderGraderPage processOrderPage;
	private BulkGradingGraderPage bulkGradingGraderPage;
	private GradingGraderPage gradingGraderPage;
	
	@DataProvider
	public Object[][] data() throws BiffException, IOException {
	 return new DataSourceXls("Parameters.xls").getData(1,2);
	 
	}	
	
	@Test(dataProvider = "data", dependsOnGroups={"changeOrderStatusToInSafe"},groups={"changeTierStatusToGraded"})
	public void asGraderICanChangeTierStatusToGradedTest (String userName, String password, String enviroment,  String invoiceNumber,String qytComics, String tier, String comicNumber, String grade, String pageQuality, String orderStatus, String role) {
		
		using(
				dashboardGraderPage=(DashboardGraderPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName, password)
				.then()
				.signInButtonClick(getWebDriver(),enviroment)
				
			  )
			  
	   .check(
				dashboardGraderPage
				.dashboardLabelMustBePresent()
					
				)
				  
		.andUsing(
				
				processOrderPage=dashboardGraderPage
				.processOrderLabelClick(getWebDriver())				
					 
				 )
					  
		 .check(
				  processOrderPage
				 .processOrderLabelMustBePresent()	
				 
				)
		   
		.andUsing(
				
				processOrderPage
				.fillInvoiceOrOrderNumberField(invoiceNumber)
				.and()
				.clickSearchButton(getWebDriver())				   
				    
				  )
				 
		.check(
				
				processOrderPage
				.orderNumberLabelMustBePresent(invoiceNumber, getWebDriver())
				
			)
	   
	
		 .andUsing(
				 
				 bulkGradingGraderPage=processOrderPage
				 .clickDetailsLink(invoiceNumber, getWebDriver())
				 
				 )
			
		 .check(
				 
		    	bulkGradingGraderPage
		    	.bulkGradingLabelMustBePresent()
		    	
		    		
		    	 )
		    	  
		 .andUsing(
 		    		 
 		    	 gradingGraderPage=bulkGradingGraderPage
 		    	.clickViewLink(comicNumber, getWebDriver())
 		    		 		    		 
 		    	 )
 		    		 
 		    		 
 		  .check( 	 
 				  
 		    	gradingGraderPage
 		    	.gradingLabelMustBePresent()
 		    		
		    	 )
		    	  
		   .andUsing(
		    		
		    	 bulkGradingGraderPage=gradingGraderPage
		    	 .gradeAComic(grade, pageQuality, getWebDriver())	
		    	 .and()
		    	.clickBackLink(getWebDriver())
		    		
		    	 )
		    		
		    .check(
		    		 
		    	bulkGradingGraderPage
		    	.bulkGradingLabelMustBePresent()		    		 
		    		 
		    	 )
		    		 
		    		 
		   .andUsing(
		    		
		    		processOrderPage=bulkGradingGraderPage
		    		.clickBackToOrderButton(getWebDriver())
		    		
		    		)
		    		
		    .check(
		    	
		    	processOrderPage
		    	.checkTierStatus(invoiceNumber, orderStatus, getWebDriver())
		    	
		    	);
	}
				
		  

}
