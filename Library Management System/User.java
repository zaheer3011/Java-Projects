package com.management.library;

public class User {

    private String name;
    private int borrowedBook;

    private static int nextBorrowedBook = 0;

    public User(String name, int borrowedBook) {

        this.name = name;
        this.borrowedBook = borrowedBook;
    }

    public String getUserName() {
        return name;
    }

    public int getBorrowedBook() {
        return borrowedBook;
    }

    public void setBorrowedBook(int nextBorrowedBook) {
        borrowedBook = nextBorrowedBook;
    }

    @Override
    public String toString() {
        return "username : " + name + "\n" + "Borrowed Book : " + borrowedBook + "\n";
    }


}
