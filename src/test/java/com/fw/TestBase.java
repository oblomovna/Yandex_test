package com.fw;

import com.fw.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));



    @BeforeClass
    public void setUp(){

        app.Init();

    }

    @AfterClass(enabled = false)
    public void tearDown(){

        app.stop();
    }



}
