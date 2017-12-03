package com.dicka.spring.restfullandroid.entities;

import java.io.Serializable;

/**
 * Created by java-spring on 01/12/17.
 */

public class Product implements Serializable{

    private int idproduct;
    private String nama;
    private int jumlah;
    private int price;

    public Product(){

    }

    public Product(String nama, int jumlah, int price){
        super();
        this.nama = nama;
        this.jumlah = jumlah;
        this.price = price;
    }

    public int getIdproduct(){
        return idproduct;
    }

    public void setIdproduct(int idproduct){
        this.idproduct = idproduct;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public int getJumlah(){
        return jumlah;
    }

    public void setJumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
