package com.qa.tests;

import com.qa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountsPageTests extends BaseTest {

    @BeforeClass
    public void preRequisites(){

        accountsPage =loginPage.doLogin(properties.getProperty("username"),properties.getProperty("pwd"));

    }

    @Test
    public void verifyLogOutLink(){
        boolean islogoutlink = accountsPage.validateLogOutLink();
        Assert.assertTrue(islogoutlink);
    }



}
