package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testClass.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)//Getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		
		logger.info("*****Started TC003_LoginDDT********"); 
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

/*
 * Data is Valid -login success-test pass - logout
 * 				login failed - test fail
 * 
 * Data is Invalid - login success - test fail - logout
 * 					login failed - test pass
 * */
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(targetpage==true) {
			
			macc.clickonLogoutBtn();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("InValid"))
	{
		if(targetpage==true) 
		{
			macc.clickonLogoutBtn();
			Assert.assertTrue(false);
		}
		
		else
		{
			Assert.assertTrue(true);
		}
	}
	
		}
	catch(Exception e) {
		Assert.fail();
	}
		
		logger.info("*****Finished TC003_LoginDDT********");
	}
}

