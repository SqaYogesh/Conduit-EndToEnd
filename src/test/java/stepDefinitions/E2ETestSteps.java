package stepDefinitions;


import managers.PageObjectManager;
import managers.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import PageObjects.HomePage;
import PageObjects.SignInPage;
import PageObjects.UserPage;
import Utilities.BDDUtil;
import PageObjects.NewPostPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class E2ETestSteps {
	
	 WebDriver driver;
	 HomePage homePage;
	 SignInPage signInPage;
	 NewPostPage newPostPage;
	 PageObjectManager pageObjectManager;
	 WebDriverManager webDriverManager;
	 UserPage userPage;
	 
	 public static final String emailUserData = "sqayogesh@gmail.com";
	 public static final String passwordUserData = "Test@123";
	 public static final String yourFeed = "Your Feed";
	 
	 @Before
	 public void beforeScenario(Scenario scenario) {
	     Reporter.assignAuthor("Yogesh Kumar - +91-9899799130");
	 }
	 
	 @After(order = 1)
	 public void afterScenario(Scenario scenario) 
	 {
		 if (scenario.isFailed()) 
		 {
		 String screenshotName = scenario.getName().replaceAll(" ", "");
		 try {
				 File sourcePath = ((TakesScreenshot) webDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
				 File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				 Files.copy(sourcePath, destinationPath);   
				 Reporter.addScreenCaptureFromPath(destinationPath.toString());
		 	 } catch (IOException e) {
		 	 } 
		 }
	 }
	 
	 
	 @After(order = 0)
	 public void AfterSteps() {
		webDriverManager.closeDriver();
	 }
	 
	 @Given("^User is on Home Page$")
	 public void user_is_on_Home_Page() throws Throwable {
		 
		 webDriverManager = new WebDriverManager();
		 driver = webDriverManager.getDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 pageObjectManager = new PageObjectManager(driver);
		 homePage = pageObjectManager.getHomePage();
		 homePage.navigateTo_HomePage();
		 
	 }

	 @When("^User Navigate to SignIn Page$")
	 public void user_Navigate_to_SignIn_Page() throws Throwable {
		 homePage.navigateTo_SignInPage();
	 }

	 @When("^User enters valid Email and valid Password$")
	 public void user_enters_valid_Email_and_valid_Password() throws Throwable {
	    signInPage = pageObjectManager.getSignInPage();
		signInPage.enter_Email(emailUserData);
		signInPage.enter_Password(passwordUserData);
		signInPage.clickOn_SignIn();		 
	 }

	 @Then("^Username displayed Successfully$")
	 public void username_displayed_Successfully() throws Throwable {
		userPage = pageObjectManager.getUserPage();
	    Assert.assertTrue("User is able to logged in.", userPage.getYourFeed().equals(yourFeed));
	 }

	 @When("^User Navigate to New Post Page$")
	 public void user_Navigate_to_New_Post_Page() throws Throwable {
		 homePage.navigateTo_NewPostPage();
	 }

	 @When("^User enters Article Title, About, Article and Tags$")
	 public void user_enters_Article_Title_About_Article_and_Tags() throws Throwable {
		newPostPage = pageObjectManager.getNewPostPage();
		newPostPage.enter_ArticleTitle(BDDUtil.randomAutomatedArticleTitle());
		newPostPage.enter_ArticleAbout(BDDUtil.randomAutomatedArticleAbout());
		newPostPage.enter_Article(BDDUtil.randomAutomatedArticle());
		newPostPage.enter_Tags(BDDUtil.randomAutomatedTags());
  
	 }

	 @When("^clicked to publish Article$")
	 public void clicked_to_publish_Article() throws Throwable {
		 newPostPage.clickOn_PublishArticle();
	 }

	 @When("^move to logged in username$")
	 public void move_to_logged_in_username() throws Throwable {
		 Thread.sleep(5000);
		 signInPage.navigateTo_UserPage();
	 }

	 @When("^select My Articles$")
	 public void select_My_Articles() throws Throwable {
		 Thread.sleep(5000);
		 userPage = pageObjectManager.getUserPage();
		 userPage.clickOn_MyArticle();
	 }

	 @When("^move to publised article$")
	 public void move_to_publised_article() throws Throwable {
		 userPage.clickOn_PublisedArticle();
	 }

	 @When("^post comments$")
	 public void post_comments() throws Throwable {
		 userPage.enter_Comment(BDDUtil.randomAutomatedComments());
		 userPage.clickOn_PostComment();
	 }

	 @Then("^posted comments displayed Successfully$")
	 public void posted_comments_displayed_Successfully() throws Throwable {
		 Assert.assertTrue("Posted Comments not found.", newPostPage.getPostedComments().contains("Automated Comments"));
	 }

}
