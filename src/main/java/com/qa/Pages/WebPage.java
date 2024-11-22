package com.qa.Pages;

import com.microsoft.playwright.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;

public class WebPage {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page launchBrowser(Properties prop){

        String browserName = prop.getProperty("browser").trim();
        System.out.println("browser name is : "+ browserName);
        playwright= Playwright.create();

        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                System.out.println("please pass the browser name ");
                break;
        }

        Dimension screemSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screemSize.getWidth();
        int height = (int)screemSize.getHeight();

        //Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
        page = context.newPage();
        page.navigate(prop.getProperty("loginUrl").trim());
        return page;

    }

    //https://www.saucedemo.com/v1/index.html

    /**
     * this method is used to initialize the properties from config file
     */

    public  Properties init_prop(){
        try
        {
            FileInputStream ip = new FileInputStream("src/test/config/config.properties");
            prop = new Properties();
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
