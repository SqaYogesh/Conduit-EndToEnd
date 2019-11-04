package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

	 public UserPage(WebDriver driver) {
		   PageFactory.initElements(driver, this);
		 }
		 
		 @FindBy(how = How.XPATH, using = "//a[text()='My Articles']") 
		 private WebElement linktxt_MyArticle;
		 
		 @FindBy(how = How.XPATH, using = "//a[@class='preview-link']/h1") 
		 private WebElement linktxt_PublisedArticle;
		 
		 @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Write a comment...']") 
		 private WebElement txtbx_Comment;
		 
		 @FindBy(how = How.XPATH, using = "//button[text()='Post Comment']") 
		 private WebElement linktxt_PostComment;
		 
		 @FindBy(how = How.XPATH, using = "//a[text()='Your Feed']") 
		 private WebElement linktxt_YourFeed;
		 
		 public void clickOn_MyArticle() {
			 linktxt_MyArticle.click();
	     }
		 
		 public void clickOn_PublisedArticle() {
			 linktxt_PublisedArticle.click();
	     }
		 
		 public void enter_Comment(String comment) {
			 txtbx_Comment.sendKeys(comment);
	     }
		 
		 public void clickOn_PostComment() {
			 linktxt_PostComment.click();
	     }
		 
		 public String getYourFeed() {
			 return linktxt_YourFeed.getText();
	     }
		 
}
