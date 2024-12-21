package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testClass.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups = {"Sanity","Regression","Master"})
	public void verify_login() {
		
		 logger.info("****Starting TC002_LoginTest ******");
		 
		 try
		 {
//		 HomePage
		 HomePage hp = new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLoginBtn();
		 
//		 LoginPage
		LoginPage lp = new LoginPage(driver); 
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPassword(p.getProperty("password"));
		lp.clicklLoginBtn();
		
//		MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage, true,"Login Pass ");
		 }
		 catch(Exception e) {
			 
			 Assert.fail();
		 }
		 
		 logger.info("****Finished TC002_LoginTest ******");

	}

}
