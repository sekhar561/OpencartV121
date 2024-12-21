package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testClass.BaseClass;

public class TC001_RegistrationTest extends BaseClass{
	
	@Test(groups = {"Sanity","Regression","Master"})
	public void test_AccountVerify() {
		
		logger.info("*****Started TC001_RegistrationTest ******");
		
		try {
			HomePage hp = new HomePage(driver);
			
			logger.info("*****Clicked the MyAccount Link******");
			hp.clickMyAccount();
			
			logger.info("*****Clicked the Register Link ******");
			hp.clickRegister();
			
			AccountRegistrationPage reg = new AccountRegistrationPage(driver);
			
			logger.info("*****Providing the Customer details  ******");
			
			reg.setFirstName(RandomeString().toUpperCase());
			reg.setLastName(RandomeString().toUpperCase());
			reg.setEmailAddress(RandomeString()+"@gmail.com");
			reg.setTelePhoneNumber(RandomeNumbers());
			
			String password = RandomeAlphaNumaric();
			
			reg.setPassword(password);
			reg.setConfirmPassword(password);
			reg.selectRadioBtn();
			
			logger.info("*****Here Submitting the customer details ******");
			reg.submitform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Test Failed...");
//			logger.debug("Debug log..");
			Assert.fail();
		}
		logger.info("*****Finished TC001_RegistrationTest ******");

		
	}

	
}