
package com.example.marvel.marvel.common.rest.comics;


public class Price {

    private String type;
    private float price;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Price() {
    }

    /**
     * 
     * @param price
     * @param type
     */
    public Price(String type, float price) {
        super();
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
