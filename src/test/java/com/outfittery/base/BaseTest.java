package com.outfittery.base;

import org.junit.After;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    private static void setSystemPathForDrivers() {
        String os = null;
        String osFullName = System.getProperty("os.name");
        String driver = "chromedriver";

        if (osFullName.toLowerCase().contains("mac")) {
            os = "mac";
        } else if (osFullName.toLowerCase().contains("linux")) {
            os = "linux";
        } else if (osFullName.toLowerCase().contains("windows")) {
            os = "windows";
            driver = "chromedriver.exe";
        } else {
            throw new IllegalStateException("OS not supported");
        }

        System.setProperty("webdriver.chrome.driver", "src/main/resources/" + os + "/" + driver);
    }

    @Before
    public void setUp() {
        setSystemPathForDrivers();

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("disable-infobars");
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-extensions");
        driver = new ChromeDriver(opt);
        driver.get("http://www.outfittery.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        if( !(null==(driver)) ) {
            driver.close();
            driver.quit();
        }
    }



}
