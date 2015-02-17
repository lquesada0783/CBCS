package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardAdminPage;
import pages.VariantsPage;

import com.ts.commons.DataSourceXls;

import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_325AsAdminICanEditAVariant extends TestCaseCBCS {
	
	private DashboardAdminPage dashboardPage;
	private VariantsPage variantsPage;
	public static String variant = "";
	 
	 @DataProvider
	 public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(16, 2);
	 }	
	 
	 @Test(dataProvider = "data")
	 public void asAdminICanEditAVariantTest(String userName, String password, String enviroment, String catalogsVariant, String variantName, String newVariantName){
			
		variant=newVariantName;
		  
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
						
				 variantsPage=dashboardPage
				.selectOneOptionCatalogMenue(catalogsVariant, getWebDriver(),VariantsPage.class)  					
						
				)
						
		 .check(
					
				variantsPage.VariantLabelMustBePresent()
						
				)
		 .andUsing(
						
				 variantsPage.clickNewButton(getWebDriver())
				.and()
				.fillFieldsAddVariantModal(variantName)
				.then()
				.clickSaveButton()
				
				)
						
		 .check(
				
			  variantsPage.addedVariantSuccessfullyMessageMustBePresent()
						
			  )
					
		 .andUsing(
					
			  variantsPage
			  .fillSearchField(variantName)
			  .and()
			  .clickSearchButton()
					
			 )
					
		 .check(					

			variantsPage.ValidateIfVariantExist(getWebDriver(), variantName)
					
			)		
			
		.andUsing(
				
			variantsPage
			.clickEditButton(getWebDriver(), variantName)		
			.and()
			.fillFieldsEditVariantModal(newVariantName)
			.then()
			.clickSaveButton()
			
			)
		
		.check(
			
			variantsPage.editVariantSuccessfullyMessageMustBePresent()	
			
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
