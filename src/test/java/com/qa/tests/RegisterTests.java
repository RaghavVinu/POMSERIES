package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.dataproviders.RegisterLoginData;
import com.qa.utils.ExcelUtilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTests extends BaseTest {

    @BeforeClass
    public void preRequisites(){
        accountsPage = loginPage.doLogin(properties.getProperty("username"),properties.getProperty("pwd") );
    }


    @Test(dataProvider = "RegisterDataLogin",dataProviderClass = RegisterLoginData.class)
    public void RegisterDataTest(String firstName, String lastName, String DOB, String city) throws IOException {
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("DOB:" + DOB);
        System.out.println("City:" + city);

    }
}
