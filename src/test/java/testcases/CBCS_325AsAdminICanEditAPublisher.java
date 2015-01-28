package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardAdminPage;
import pages.PublisherPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_325AsAdminICanEditAPublisher extends TestCaseCBCS {
	
	private DashboardAdminPage dashboardPage;
	private PublisherPage publisherPage;
	public static String publisher = "";
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(17, 2);
	 }	
	 
	 @Test(dataProvider = "data")
	 public void asAdminICanEditAPublisherTest(String userName, String password, String enviroment, String catalogsPublisher, String publisherName, String newPublisherName){
			
		publisher=newPublisherName;
		  
		using(
				dashboardPage=(DashboardAdminPage) UI.goToAdminLoginPage(getWebDriver())
				.fillFieldsForLogin(userName , password)
				.and()
				.signInButtonClick(getWebDriver(), enviroment)
					
				)
					
		.check(
				
				dashboardPage
				.dashboardLabelMustBePresent()
							
				 )
			
		 .andUsing(
						
				publisherPage=dashboardPage
				.selectOneOptionCatalogMenue(catalogsPublisher, getWebDriver(),PublisherPage.class)  					
						
				)
						
		 .check(
					
			publisherPage.PublisherLabelMustBePresent()
						
				)
		 .andUsing(
						
				publisherPage.clickNewButton(getWebDriver())
				.and()
				.fillFieldsAddPublisherModal(publisherName)
				.then()
				.clickSaveButton(getWebDriver())
				
				)
						
		 .check(
				
			publisherPage.addedPublisherSuccessfullyMessageMustBePresent()
						
			  )
					
		 .andUsing(
					
			publisherPage.fillSearchField(publisherName)
			.and()
			.clickSearchButton(getWebDriver())
					
			 )
					
		 .check(					

			publisherPage.ValidateIfPublisherExist(getWebDriver(), publisherName)
					
			)		
			
		.andUsing(
				
			publisherPage.clickEditButton(getWebDriver(), publisherName)		
			.and()
			.fillFieldsEditPublisherModal(newPublisherName)
			.then()
			.clickSaveButton(getWebDriver())
			
			)
		
		.check(
			
			publisherPage.editPublisherSuccessfullyMessageMustBePresent()	
			
			);
		}
	 
	 @Override
	 @AfterMethod (alwaysRun=true)
	 public void close(){
		utils.Utils.searchAndDeletePublisher(publisher, getWebDriver());
		driver.close();
		driver.quit();
		
	 }

}
