package com.spring11.model;

public class ModelPhone {

    private String  name          ; //VARCHAR2(20)    NOT NULL ENABLE
    private String  manufacturer  ; //VARCHAR2(40)    NOT NULL ENABLE
    private Integer price         ; //NUMBER(10)      DEFAULT 0 NOT NULL ENABLE
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    
    public ModelPhone() {
        super();
    }
    public ModelPhone(String name, String manufacturer, Integer price) {
        super();
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }
    
    
    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacturer=" + manufacturer
                + ", price=" + price + "]";
    }
}
