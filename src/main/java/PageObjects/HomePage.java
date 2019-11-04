package PageObjects;

import managers.FileReaderManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	 WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using = "//a[text()='Sign in']") 
	 private WebElement linktxt_SignIn;
	 
	 @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-xs-right']/li[2]") 
	 private WebElement linktxt_NewPost;
	 
	 public HomePage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
	 }
	 
	 public void navigateTo_HomePage() {
	   driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	 }
	 
	 public void navigateTo_SignInPage() {
		 linktxt_SignIn.click();
     }
	 
	 public void navigateTo_NewPostPage() {
		 linktxt_NewPost.click();
	 }
	 
}
