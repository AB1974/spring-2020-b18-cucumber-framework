package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.LogManager;

public class Driver {

    //1-Make constructor private
    private Driver() {
    }

    //InhertirableThreadLocal-->this is like a container,bag pool
    //   IN this pool we can have seperate objects for each thread
    //driver class will provide seperate webdriver object per thread
    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    // private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver.get() == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());

                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;

                case "chrome-remote":

                    try {
                        //same as ChromeOptions
                        //to request selenium Grid to run test on firefox
                        //   DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        //    desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                        //desiredCapabilities.setPlatform(Platform.LINUX)
                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://18.206.13.27:4444/wd/hub");
                        driver.set(new RemoteWebDriver(url, chromeOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox-remote":

                    try {
                        //to request selenium Grid to run test on firefox
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        URL url = new URL("http://18.206.13.27:4444/wd/hub");
                        driver.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }


                default:
                    throw new RuntimeException("Wrong browser name: " + browser);

            }
        }

        return driver.get();

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.get().quit();
            driver = null;
        }
    }


}
