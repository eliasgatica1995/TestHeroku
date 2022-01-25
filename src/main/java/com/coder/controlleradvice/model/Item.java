package com.coder.controlleradvice.model;

public class Item {
    private String title;
    private int id;
    private String thumbnail;
    private double price;

    public Item(){}
    public Item(int id,String title, double price, String thumbnail) {
        this.id=id;
        this.title=title;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }


    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {return title;}


    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getThumbnail() {
        return thumbnail;
    }

}
