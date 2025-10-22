package com.qa.driverfactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
     OptionsManager opsManager;

     public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
    public WebDriver initDriver(Properties properties){
        String browserName = properties.getProperty("browser");
        opsManager = new OptionsManager(properties);
        switch(browserName.toLowerCase()){
            case "chrome":
                //driver = new ChromeDriver(opsManager.getChromeOptions());
                threadLocal.set(new ChromeDriver(opsManager.getChromeOptions()));
                break;
            case "edge":
                //driver = new EdgeDriver(opsManager.getEdgeOptions());
                threadLocal.set(new EdgeDriver(opsManager.getEdgeOptions()));
                break;
            case "firefox":
                //driver = new FirefoxDriver(opsManager.getFirefoxOptions());
                threadLocal.set(new FirefoxDriver(opsManager.getFirefoxOptions()));
                break;
            default:
                System.out.println("Enter correct browser");
        }
        threadLocal.get().manage().window().maximize();
        threadLocal.get().manage().deleteAllCookies();
        threadLocal.get().get(properties.getProperty("appUrl"));
        return threadLocal.get();

    }

    public synchronized static WebDriver getDriver(){
        return threadLocal.get();
    }

    /*public static void main(String[] args){
        initProperties();
    }*/

    public Properties initProperties() {
        Properties properties = new Properties();
        FileInputStream fs = null;
        String envName= System.getProperty("env");
        System.out.println("Environment is:" + envName);
        try{
            if (envName == null)
                fs = new FileInputStream("./src/main/resources/config/qa_config.properties");
            else{
                fs = new FileInputStream("./src/main/resources/config/" + envName + "_config.properties");
            }
            properties.load(fs);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }


    public static String getScreenshot(){

        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destFile = new File(path);

        try{
            FileUtils.moveFile(srcFile,destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
