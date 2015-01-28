package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.PedigreesPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_323AsAdminICanCreateANewPedigree extends TestCaseCBCS {
	
	 private DashboardAdminPage dashboardPage;
	 private PedigreesPage pedigreesPage;
	 public static String pedigree = "";
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(18, 2);
	 }	
	 
	 @Test(dataProvider = "data")
	 public void asAdminICanCreateANewPedigreeTest(String userName, String password, String enviroment, String catalogsPedigree, String pedigreeName, String newPedigreeName){
			
		    pedigree=pedigreeName;
		    
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
						
					 pedigreesPage=dashboardPage
					 .selectOneOptionCatalogMenue(catalogsPedigree, getWebDriver(),PedigreesPage.class)  					
						
					)
						
			  .check(
					  
				   pedigreesPage.PedigreesLabelMustBePresent()
						
					)
					
			 .andUsing(
					
					 pedigreesPage.clickNewButton(getWebDriver())
					.and()
					.fillFieldsAddPedigreeModal(pedigreeName)
					.then()
					.clickSaveButton(getWebDriver())					
					
					)
					
			 .check(
					 
					pedigreesPage.addedPedigreesSuccessfullyMessageMustBePresent()
					
					);
		  }
	 
	 @Override
	 @AfterMethod (alwaysRun=true)
	 public void close(){
		utils.Utils.searchAndDeletePedigree(pedigree, getWebDriver());
		driver.close();
		driver.quit();
		}
	 
}
