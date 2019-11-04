package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
	
	 public SignInPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(how = How.XPATH, using = "//input[@placeholder='Email']") 
	 private WebElement txtbx_Email;
	 
	 @FindBy(how = How.XPATH, using = "//input[@placeholder='Password']") 
	 private WebElement txtbx_Password;
	 
	 @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-xs-right']/li[4]") 
	 private WebElement linktxt_User;
	 
	 @FindBy(how = How.XPATH, using = "//button[text()='Sign in']") 
	 private WebElement btn_SignIn;
	 
	 public void enter_Email(String email) {
		 txtbx_Email.sendKeys(email);
     }
	 
	 public void enter_Password(String password) {
		 txtbx_Password.sendKeys(password);
     }
	 
	 public void clickOn_SignIn() {
		 btn_SignIn.click();;
	 }
	 
	 public void navigateTo_UserPage() {
		 linktxt_User.click();
     }
}
