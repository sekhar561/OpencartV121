package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
//	Constructor
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}

//	Locators
	
@FindBy(xpath ="//span[contains(text(),'My Account')]")
WebElement InkMyaccount;

@FindBy(xpath ="//a[contains(text(),'Register')]")
WebElement InkRegister;


@FindBy(xpath = "//a[contains(text(),'Login')]")
WebElement LoginBtn;
	
//	Actions

public void clickMyAccount() {
	InkMyaccount.click();
}
public void clickRegister() {
	
	InkRegister.click();
}

public void clickLoginBtn() {
	LoginBtn.click();
}

}
