package com.testpractices.drivers;

import com.testpractices.enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Objects;

public class DriverManagers {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void createDriver(final Browser browser){
        switch (browser){
            case CHROME -> setUpChromeDriver();
            default -> setUpChromeDriver();
        }
        setupBrowserTimeouts();

    }

    public static <D extends WebDriver> D getDriver(){
        return (D) DriverManagers.DRIVER.get();
    }
    public static void quitDriver(){
        if(null != DRIVER.get()){
            getDriver().quit();
            DRIVER.remove();
        }
    }

    public static void setDriver(final WebDriver driver){
        DriverManagers.DRIVER.set(driver);
    }

    private static void setupBrowserTimeouts(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    private static void setUpChromeDriver(){
       final ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--no-sandbox");
        options.addArguments ("--disable-dev-shm-usage");
        options.addArguments ("--window-size=1050,600");
        options.addArguments ("--safebrowsing-disable-download-protection");
        setDriver(WebDriverManager.chromedriver().capabilities(options).create());
    }
}
