package com.example.litepaltest;


import org.litepal.crud.DataSupport;

/**
 * Created by 她是龙 on 2018/3/13.
 */

public class Book extends DataSupport {

    private int id;

    private String name;

    private String author;

    private double price;

    private int pages;

    public Book ( ){

    }

    public Book (int id, String name, String author, double price, int pages) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.pages = pages;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getAuthor() {
        return author;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
