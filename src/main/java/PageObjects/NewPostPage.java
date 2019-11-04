package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage {
	
 
	 public NewPostPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
	 }

	 @FindBy(how = How.XPATH, using = "//input[@placeholder='Article Title']") 
	 private WebElement txtbx_ArticleTitle;
	 
	 @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'this article about?')]") 
	 private WebElement txtbx_ArticleAbout;
	 
	 @FindBy(how = How.XPATH, using = "//textarea[contains(@placeholder,'Write your article')]") 
	 private WebElement txtbx_Article;
	 
	 @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter tags']") 
	 private WebElement txtbx_Tags;
	 
	 @FindBy(how = How.XPATH, using = "//button[text()='Publish Article']") 
	 private WebElement btn_PublishArticle;
	 
	 @FindBy(how = How.XPATH, using = "//div[@class='card']/div") 
	 private WebElement txtbx_PostedComments;
	 

	 public void enter_ArticleTitle(String title) {
		 txtbx_ArticleTitle.sendKeys(title);
     }
	 
	 public void enter_ArticleAbout(String articleAbout) {
		 txtbx_ArticleAbout.sendKeys(articleAbout);
     }
	 
	 public void enter_Article(String article) {
		 txtbx_Article.sendKeys(article);
     }
	 
	 public void enter_Tags(String tags) {
		 txtbx_Tags.sendKeys(tags);
     }
	 
	 public void clickOn_PublishArticle() {
		 btn_PublishArticle.click();;
	 }

	 public String getPostedComments() {
		 return txtbx_PostedComments.getText();
	 }

}
