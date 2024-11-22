package VerificationTests;

import com.microsoft.playwright.Page;
import com.qa.Base.BaseTest;
import com.qa.Pages.AppConstants;
import com.qa.Pages.LoginPage;
import com.qa.Pages.WebPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {



    @Test
    public void homePageLoginTest(){
        loginPage.signUpPage();

    }

    @Test
    public void homePageTitleTest(){
    String actualTitle = loginPage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void homePageUrlTest(){
        String actualUrl = loginPage.getHomePageURL();
        Assert.assertEquals(actualUrl,prop.getProperty("url"));
    }


//    @AfterTest
//    public void closeSession(){
//        page.context().browser().close();
//    }
}
