package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.AdminDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.Users;
import utils.Constant;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS315_AsAdminICanDeleteAReceiver extends TestCaseCBCS {
	
	  private DashboardAdminPage dashboardPage;
	  private Users users;
	  AdminDataInfo receiverUser;
	  
	  @DataProvider
		public Object[][] data() throws BiffException, IOException {
		return new DataSourceXls("Parameters.xls").getData(13, 2);
		}	
		
		@Test(dataProvider = "data")		
		public void asAdminIMayDeleteAReceiverTest(String userName, String password, String enviroment, String role){
		  
		    receiverUser=new AdminDataInfo();
			receiverUser.fillDataReceiverRole(receiverUser,password,role);
		  
		  using(
				 dashboardPage=(DashboardAdminPage) UI.goToAdminLoginPage(getWebDriver())
				 .fillFieldsForLogin(userName ,password)
				 .and()
				 .signInButtonClick(getWebDriver(),enviroment)
					
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
				.fillFieldsAddUserModal(receiverUser,role, getWebDriver())
				.clicksaveButton(getWebDriver())
					
				)
					
			.check(
					
				users.addedUserSuccessfullyMessageMustBePresent()
					
				)
			
			.andUsing(
					
					users.deletedUser(receiverUser, driver)
					
			       )
			
			.check(					
					
			    users.deletedUserSuccessfullyMessageMustBePresent()
				
				 );
		  
			}


}
