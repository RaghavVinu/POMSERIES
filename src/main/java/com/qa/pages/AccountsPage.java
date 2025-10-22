package com.qa.pages;

import com.qa.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    By logout = By.xpath("//div/a[contains(text(),'Logout')]");
    public AccountsPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public boolean validateLogOutLink(){
        return elementUtil.checkElementIsDisplayed(logout);
        //return driver.findElement(logout).isDisplayed();
    }



}
