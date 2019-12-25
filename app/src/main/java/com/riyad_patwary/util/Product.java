package com.riyad_patwary.util;

public class Product {
    private int product_id;
    private String product_Name;
    private String product_Category;
    private String product_Description;
    private String product_Price;

    public Product() {
    }

    public Product(int product_id, String product_Name, String product_Category, String product_Description, String product_Price) {
        this.product_id = product_id;
        this.product_Name = product_Name;
        this.product_Category = product_Category;
        this.product_Description = product_Description;
        this.product_Price = product_Price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getProduct_Category() {
        return product_Category;
    }

    public void setProduct_Category(String product_Category) {
        this.product_Category = product_Category;
    }

    public String getProduct_Description() {
        return product_Description;
    }

    public void setProduct_Description(String product_Description) {
        this.product_Description = product_Description;
    }

    public String getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(String product_Price) {
        this.product_Price = product_Price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_Name='" + product_Name + '\'' +
                ", product_Category='" + product_Category + '\'' +
                ", product_Description='" + product_Description + '\'' +
                ", product_Price='" + product_Price + '\'' +
                '}';
    }
}
