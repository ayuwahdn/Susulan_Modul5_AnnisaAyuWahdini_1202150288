package com.example.android.Susulan_Modul5_AnnisaAyuWahdini_1202150288;


public class ListToDo {
    private int id;
    private String nama, deskripsi, prioritas;

    public ListToDo( int id, String nama, String deskripsi, String prioritas ) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.prioritas= prioritas;
    }
    public int getId(){
        return id;}

    public String getDekripsi() {

        return deskripsi;
    }

    public String getNama() {

        return nama;
    }

    public String getPrioritas() {

        return prioritas;
    }


}


