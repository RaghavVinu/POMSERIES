package com.qa.dataproviders;

import com.qa.pojos.ProductDetails;
import org.testng.annotations.DataProvider;

public class ProductDataProvider {

    @DataProvider (name="ProductData")
    public Object[][] loginPojoData(){
        return new Object[][]{
                {new ProductDetails("Iphone 16","Apple Product",10)},
                {new ProductDetails("Galaxy","Samsung Product",15)},
                {new ProductDetails("HTC","HTC Product",100)}
        };

    }
}
