package com.management.library;

public class Book {

    private String title;
    private String author;
    private String genre;

    private boolean isAvailable;

    public Book(String title, String author, String genre, boolean isAvailable) {

        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {

        return "Title : " + title + "\n" + "Author : " + author + "\n" +
                "Genre : " + genre + "\n" + "Available : " + isAvailable + "\n";
    }
}
