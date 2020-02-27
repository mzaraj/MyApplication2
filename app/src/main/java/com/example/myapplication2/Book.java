package com.example.myapplication2;

public class Book {

    private String title;

    private String description;

    private String photoAdress;

    public Book(String title, String description, String photoAdress) {
        this.title = title;
        this.description = description;
        this.photoAdress = photoAdress;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoAdress() {
        return photoAdress;
    }

    public void setPhotoAdress(String photoAdress) {
        this.photoAdress = photoAdress;
    }
}
