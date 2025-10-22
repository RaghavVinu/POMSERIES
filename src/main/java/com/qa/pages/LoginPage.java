package com.qa.pages;

import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver= null;
    private ElementUtil elementUtil;
    private By emailId = By.id("input-email");
    private By password = By.id("input-password");

    private By loginButton = By.xpath("//input[@value='Login']");
    public LoginPage(WebDriver driver)    {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);

    }

    public boolean  isEmailIdDisplayed(){
        return elementUtil.IsElementDisplayed(emailId);
        //return driver.findElement(emailId).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed(){
        return elementUtil.checkElementIsDisplayed(password);
        //return driver.findElement(password).isDisplayed();
    }

    public AccountsPage doLogin(String userName,String pwd){
        elementUtil.doSendKeys(emailId,userName);
        elementUtil.doSendKeys(password,pwd);
        elementUtil.doClick(loginButton);
        //driver.findElement(emailId).sendKeys(userName);
        //driver.findElement(password).sendKeys(pwd);
        //driver.findElement(loginButton).click();
        return new AccountsPage(driver);
    }

    public ElementUtil getElementUtil() {
        return elementUtil;
    }

    public String getPageTitle(String title, int timeDuration){
        return elementUtil.waitForFullTitleAndCapture(title,timeDuration);
    }
}
