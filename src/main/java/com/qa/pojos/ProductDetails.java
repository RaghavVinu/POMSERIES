package com.qa.pojos;

public class ProductDetails {


    private String product;
    private String productDescription;
    private int quantity;

    public ProductDetails(String product, String productDescription, int quantity){
        this.product = product;
        this.productDescription = productDescription;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Product[Product Key: " + product + " , Product Description: " + productDescription + ", Quantity: " + quantity + "]";
    }

}
