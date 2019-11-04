package managers;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.SignInPage;
import PageObjects.UserPage;
import PageObjects.NewPostPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private NewPostPage newPostPage;
	private UserPage userPage;
	
	
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
	}
    
    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
   	}

    public SignInPage getSignInPage(){
        return (signInPage == null) ? signInPage = new SignInPage(driver) : signInPage;
   	}

    public NewPostPage getNewPostPage(){
        return (newPostPage == null) ? newPostPage = new NewPostPage(driver) : newPostPage;
   	}
    
    public UserPage getUserPage(){
        return (userPage == null) ? userPage = new UserPage(driver) : userPage;
   	}

}
