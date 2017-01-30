
package com.example.marvel.marvel.Comics;

import java.util.List;

public class Creators {

    private int available;
    private String collectionURI;
    private List<Item> items = null;
    private int returned;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Creators() {
    }

    /**
     * 
     * @param items
     * @param collectionURI
     * @param available
     * @param returned
     */
    public Creators(int available, String collectionURI, List<Item> items, int returned) {
        super();
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

}
