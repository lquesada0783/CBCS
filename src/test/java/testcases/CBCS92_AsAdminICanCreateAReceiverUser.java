package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.AdminDataInfo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.Users;
import utils.Constant;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS92_AsAdminICanCreateAReceiverUser extends TestCaseCBCS {
	
  private DashboardAdminPage dashboardPage;
  private Users users;
  AdminDataInfo receiverUser;
	
    @DataProvider
	public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(13, 2);
	}	

	@Test(dataProvider = "data")
	public void asAdminIMayCreateAReceiverUserTest(String userName, String password, String enviroment, String role){
		
		receiverUser=new AdminDataInfo();
		receiverUser.fillDataReceiverRole(receiverUser,password,role);
		
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
					
				 users=dashboardPage
				.selectOneOptionCatalogsMenue(Constant.CATALOGS_USERS, getWebDriver())
					
					)
					
		  .check(
				
				 users.UsersLabelMustBePresent()
					
				)
			
		   .andUsing(
					
				users.clickNewButton(getWebDriver())
				.fillFieldsAddUserModal(receiverUser,role , getWebDriver())
				.clicksaveButton(getWebDriver())
					
				)
					
			.check(
					
				users.addedUserSuccessfullyMessageMustBePresent()
					
				);					
	  }
	
	 @Override
	 @AfterMethod(alwaysRun = true)
	 public void close(){
	 users.deletedUser(receiverUser, driver);
	 driver.close();
	 driver.quit();
	  
	 }


}
