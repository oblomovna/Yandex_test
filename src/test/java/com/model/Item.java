package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Item {
    private String itemType;
    private  String priceFrom;
    private  String priceTo;
    private  String brand;

    public Item setItemType(String itemType) {
        this.itemType = itemType;
        return  this;
    }

    public Item setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
        return  this;
    }

    public Item setPriceTo(String priceTo) {
        this.priceTo = priceTo;
        return  this;
    }

    public Item setBrand(String brand) {
        this.brand = brand;
        return  this;
    }
   /* public void click(By locator) {
        wd.findElement(locator).click();
    }*/


    public String getItemType() {
        return itemType;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public String getBrand() {
        return brand;
    }
}
