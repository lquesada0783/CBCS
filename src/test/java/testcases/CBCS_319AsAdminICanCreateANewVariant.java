package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.VariantsPage;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_319AsAdminICanCreateANewVariant extends TestCaseCBCS {
	
	 private DashboardAdminPage dashboardPage;
	 private VariantsPage variantPage;
	 public static String variant = "";
	 
	 
	 @DataProvider
	public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(16, 2);
	}	

	@Test(dataProvider = "data")
	public void asAdminICanCreateANewVariantTest(String userName, String password, String enviroment, String catalogsVariant, String variantName, String newVariantName){
			
		variant=variantName;	
		
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
						
				variantPage=dashboardPage
				.selectOneOptionCatalogMenue(catalogsVariant, getWebDriver(),VariantsPage.class)  					
						
				)
						
		  .check(
					
				variantPage.VariantLabelMustBePresent()
						
				)
					
			.andUsing(
					
				variantPage.clickNewButton(getWebDriver())
				.and()
				.fillFieldsAddVariantModal(variantName)
				.then()
				.clickSaveButton()					
					
				)
					
			 .check(
					
				 variantPage.addedVariantSuccessfullyMessageMustBePresent()
					
				);
		}
	
	 @Override
	 @AfterMethod (alwaysRun=true)
	 public void close(){
		utils.Utils.searchAndDeleteVariant(variant, getWebDriver());
		driver.close();
		driver.quit();
		}

}
