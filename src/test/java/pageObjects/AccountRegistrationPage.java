package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
//	Constructor
	
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement emailID;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telePhone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirm_Password;
	
	@FindBy(xpath = "//input[@value='0']")
	WebElement select_NoRadioBtn;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement clickAgree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement clickContinue;
	

public void setFirstName(String fname) {
	
	firstName.sendKeys(fname);
	
}

public void setLastName(String lname) {
	lastName.sendKeys(lname);
	
}
public void setEmailAddress(String email) {
	emailID.sendKeys(email);
	
}
public void setTelePhoneNumber(String telephone) {
	telePhone.sendKeys(telephone);
	
}
public void setPassword(String pwd) {
	password.sendKeys(pwd);
	
}

public void setConfirmPassword(String confimpwd) {
	password.sendKeys(confimpwd);
	
}

public void selectRadioBtn() {
	select_NoRadioBtn.click();
}
public void clAgree() {
	clickAgree.click();
		
}
public void submitform() {
	clickContinue.click();
}
	
	}

