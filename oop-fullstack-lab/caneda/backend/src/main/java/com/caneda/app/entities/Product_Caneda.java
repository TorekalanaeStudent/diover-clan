package com.caneda.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "Product")
public class Product_Caneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String productName;
    private String description;
    private Double price;
    private String category;
    private int quantity;


    //Default Constructor if no product input
    public Product_Caneda() {
        setProductName("Default");
        setDescription("No Description");
        setPrice(0.0);
        setCategory("No Category");
        setQuantity(0);
    }

    //Parameterized Constructor if product has inputed some data
    public Product_Caneda(String productName, String description, Double price, int quantity, String category) {
        setProductName(productName);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
        setCategory(category);
    }

    //Getters

    //Gets id
    public long getProductId(){
        return id;
    }

    //Gets productName
    public String getProductName(){
        return productName;
    }

    //Gets description
    public String getDescription() {
        return description;
    }

    //Gets price
    public Double getPrice() {
        return price;
    }

    //Gets category
    public String getCategory() {
        return category;
    }

    //Gets quantity
    public int getQuantity() {
        return quantity;
    }

    //Setters

    //Sets Id
    public void setId(long id) {
        this.id = id;
    }

    //Sets product name if empty then no name
    public void setProductName(String productName) {
        if(productName == null || productName.isEmpty()) {
            this.productName = "No Name";
        }
        else {
            this.productName = productName;
        }
    }

    //Sets description if empty then no description
    public void setDescription(String description) {
        if(description == null || description.isEmpty()){
            this.description = "No Description";
        }
        else{
            this.description = description;
        }
    }

    //Sets price if below 0 then 0
    public void setPrice(Double price) {
        if(price == null || price <= 0) {
            this.price = 0.0;
        }
        else {
            this.price = price;
        }
    }

    //Sets category if empty then no category
    public void setCategory(String category) {
        if(category == null || category.isEmpty()){
            this.category = "No Category";
        }
        else {
            this.category = category;
        }
    }

    //Sets quantity if below 0 then 0
    public void setQuantity(int quantity) {
        if(quantity < 0){
            this.quantity = 0;
        }
        else {
            this.quantity = quantity;
        }
    }
}
