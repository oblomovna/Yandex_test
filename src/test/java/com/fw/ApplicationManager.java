package com.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String browser;
    WebDriver wd;
    MainPageHelper mainPage;
    MarketItemHelper marketItem;
    MarketHeaderHelper marketHeader;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    public void openSite(String url) {
        wd.navigate().to(url);
    }



    public void Init() {
      /*  if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.SAFARI)){
            wd = new SafariDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", "//Users/korypaev/Desktop/Tools/chromedriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://yandex.ru/");
        wd.manage().window().maximize();



        mainPage = new MainPageHelper(wd);
        marketItem = new MarketItemHelper(wd);
        marketHeader = new MarketHeaderHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public MainPageHelper mainPage() {
        return mainPage;
    }

    public MarketItemHelper marketItem() {
        return marketItem;
    }

    public MarketHeaderHelper marketHeader() {
        return marketHeader;
    }
}
