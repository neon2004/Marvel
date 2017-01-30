
package com.example.marvel.marvel.Comics;

import java.util.List;

public class Events {

    private int available;
    private String collectionURI;
    private List<Object> items = null;
    private int returned;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Events() {
    }

    /**
     * 
     * @param items
     * @param collectionURI
     * @param available
     * @param returned
     */
    public Events(int available, String collectionURI, List<Object> items, int returned) {
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

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

}
