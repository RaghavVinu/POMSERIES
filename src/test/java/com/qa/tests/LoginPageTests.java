package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.dataproviders.ProductDataProvider;
import com.qa.pojos.ProductDetails;
import com.qa.utils.AppConstants;
import com.qa.utils.ElementUtil;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Epic("Login Epic")
@Feature("Login Feature")
public class LoginPageTests extends BaseTest {

    @Story("Validate Login Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyEmailIDDisplayed(){
        boolean isEmailDisplayed = loginPage.isEmailIdDisplayed();
        Assert.assertTrue(isEmailDisplayed);
    }

    @Test
    public void verifyPasswordElementDisplayed(){
        boolean ispwdDisplayed = loginPage.isPasswordFieldDisplayed();
        Assert.assertTrue(ispwdDisplayed);
    }

    @Test
    public void yverifyLoginApp(){
        loginPage.doLogin(properties.getProperty("username"),properties.getProperty("pwd"));

    }

    @Test
    public void verifyLoginPageTitle(){
        softAssert.assertEquals(loginPage.getPageTitle(AppConstants.LOGIN_PAGE_TITLE,AppConstants.WAIT_SHORT_TIME),AppConstants.LOGIN_PAGE_TITLE);
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] loginTestData(){
          return new Object[][]{
                {"Raghav"},
                {"Unnam"},
                {"Veera"}
        };
    }



    @Test(dataProvider = "ProductData", dataProviderClass = ProductDataProvider.class)
    public void testvalidatePojoDetails(ProductDetails prd){
        System.out.println(prd.getProduct() + " --------> " + prd.getProductDescription() + " -----> " + prd.getQuantity());
    }

    @Test(dataProvider = "loginTestData")
    public void sampleTestDataTest(String name){
       System.out.println("Test Data - " + name);
    }
}
