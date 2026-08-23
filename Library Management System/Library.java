package com.management.library;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Library {

    // To store the books details
    private List<Book> bookList = new ArrayList <> ();

    // To store the User details
    private List<User> userList = new ArrayList <> ();

    // To store the user borrowed books
    private Map<String, List<Book>> borrowedBook = new HashMap <> ();


    private static Library library;

    private Library() {}

    public static Library getInstance() {

        if(library == null) {
            library = new Library();
        }

        return library;
    }

    public void addBookList(Book newBook) {
        bookList.add(newBook);
    }

    public Book checkBookAvailability(String title) {

        for(Book book : bookList) {
            if(book.getTitle().equals(title))
                return book;
        }

        return null;
    }

    public void removeBookInLibrary(Book book) {

        bookList.remove(book);
    }

    public void displayLibraryBooks() {

        for(Book books : bookList) {
            System.out.println(books);
        }
    }

    public void addMemberToLibrary(User newUser) {

        userList.add(newUser);
    }

    public void displayMembersInLibrary() {

        for(User user : userList) {
            System.out.println(user);
        }
    }

    // Remaining methods for User logged In

    public User getUser(String userName) {

        for(User user : userList) {
            if(user.getUserName().equalsIgnoreCase(userName))
                    return user;
        }

        return null;
    }

    public List<Book> getAddedUserList(String userName) {

        for(Map.Entry<String, List<Book>> borrowedBookList : borrowedBook.entrySet()) {
            if(borrowedBookList.getKey().equalsIgnoreCase(userName)) {
                return borrowedBookList.getValue();
            }
        }

        return null;
    }

    public Book getBook(String title) {

        for(Book book : bookList) {
            if(book.getTitle().equalsIgnoreCase(title))
                return book;
        }

        return null;
    }

    public boolean checkBookBorrowed(String userName, String title) {

        List<Book> book = borrowedBook.get(userName);

        if(book == null) return false;

        for(Book bookList : book) {
            if(bookList.getTitle().equalsIgnoreCase(title))
                return true;
        }

        return false;
    }

    public void borrowBook(String title, User user) {

       Book book = getBook(title);

       if(book != null && book.getIsAvailable() && user.getBorrowedBook() <= 5) {

           user.setBorrowedBook(user.getBorrowedBook() + 1);
           book.setIsAvailable(false);
           System.out.println("book borrowed");
       }

       else {

           System.out.println("Book not available");
       }
    }

    public void returnBook(String title, User user) {

        Book book = getBook(title);

        if(book != null && !book.getIsAvailable()) {

            user.setBorrowedBook(user.getBorrowedBook() - 1);
            book.setIsAvailable(true);
            System.out.println("Book Returned");
        }

        else {

            System.out.println("Book not available");
        }
    }

    public void displayAllBooks() {

        System.out.println("List of Books : ");
        library.displayLibraryBooks();
    }
}
