package com.qa.base;

import com.beust.jcommander.Parameter;
import com.qa.driverfactory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;
    protected DriverFactory driverFactory;

    protected Properties properties;

    protected SoftAssert softAssert;

    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browserName){
        driverFactory = new DriverFactory();
        properties = driverFactory.initProperties();
        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }
        driver = driverFactory.initDriver(properties);
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();

        //to get the current driver session id
       /* RemoteWebDriver rdriver = (RemoteWebDriver) driver;
        Capabilities caps = rdriver.getCapabilities();
        System.out.println("The driver session id is:" + rdriver.getSessionId());*/

    }

    @AfterTest
    public void tear(){
        driver.quit();
    }
}
