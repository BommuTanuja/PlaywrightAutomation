package com.qa.Base;

import com.microsoft.playwright.Page;
import com.qa.Pages.LoginPage;
import com.qa.Pages.WebPage;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    WebPage webPage;
    Page page;
    protected  Properties prop;
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp(){
        webPage = new WebPage();
        prop=webPage.init_prop();
        page = webPage.launchBrowser(prop);
        loginPage = new LoginPage(page);

    }
}
