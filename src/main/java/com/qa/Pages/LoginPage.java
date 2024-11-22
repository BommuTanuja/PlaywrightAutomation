package com.qa.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {

     private Page page;

     //1. String Locators

    private String userName="#user-name";
    private String password = "#password";
    private String loginButton ="#login-button";
    private String header = "//div[text()='Products']";

    //2. page Constructor
    public LoginPage (Page page){
        this.page =page;
    }

    //3. page action/methods

    public String signUpPage(){
        page.fill(userName,"standard_user");
        page.fill(password,"secret_sauce");
        page.click(loginButton);
        String pageHeader= page.locator(header).textContent();
        System.out.println("page Header is:"+ pageHeader);
        return pageHeader;
    }
    public String getHomePageTitle(){
        String title= page.title();
        System.out.println("page title :"+ title);
        return  title;
    }

    public String getHomePageURL(){
        String url = page.url();
        System.out.println("page url is :"+ url);
        return url;
    }


//    public String getHeadingOfPage(String headerName){
//    page.fill
//    }



}
