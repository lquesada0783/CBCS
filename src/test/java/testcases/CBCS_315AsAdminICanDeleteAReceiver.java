package testcases;

import java.io.IOException;

import jxl.read.biff.BiffException;
import object.AdminDataInfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ts.commons.DataSourceXls;

import pages.DashboardAdminPage;
import pages.UsersPage;
import utils.Constant;
import utils.TestCaseCBCS;
import utils.UI;

public class CBCS_315AsAdminICanDeleteAReceiver extends TestCaseCBCS {
	
	  private DashboardAdminPage dashboardPage;
	  private UsersPage usersPage;
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
						
				  usersPage=dashboardPage
				 .selectOneOptionCatalogsMenue(Constant.CATALOGS_USERS, getWebDriver())						
					
				  )
						
		   .check(
					
				  usersPage.UsersLabelMustBePresent()
						
				)				
				
			.andUsing(
					
				usersPage.clickNewButton(getWebDriver())
				.and()
				.fillFieldsAddUserModal(receiverUser,role, getWebDriver())
				.then()
				.clicksaveButton(getWebDriver())
					
				)
					
			.check(
					
				usersPage.addedUserSuccessfullyMessageMustBePresent()
					
				)
				
			.andUsing(
					
				   usersPage.fillSearchField(receiverUser)
				  .and()
				  .clickSearchButton()
					
				  )
					
		   .check(					

				usersPage.ValidateIfUserExist(getWebDriver(), receiverUser)
					
			 )		
			
		.andUsing(
				
			 usersPage.clickDeleteButton(getWebDriver(), receiverUser)
			 .and()
			 .clickYesButton(getWebDriver())
			
			)		 
			
		 .check(					
					
			 usersPage.deletedUserSuccessfullyMessageMustBePresent()
				
			 );
		  
		}


}
