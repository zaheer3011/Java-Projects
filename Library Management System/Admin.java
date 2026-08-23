package com.management.library;

import java.util.List;
import java.util.ArrayList;

public class Admin {

    private Library library;

    public Admin() {
        library = Library.getInstance();
    }

    public void addBook(String title, String author, String genre) {

        Book book = new Book(title, author, genre, true);
        library.addBookList(book);
        System.out.println("Book Added...");

    }

    public void updateBook(String title, String author, String genre) {

       Book existingBook = library.checkBookAvailability(title);
       if(existingBook == null) {
           System.out.println("Book Not Exists");
           return;
       }

       existingBook.setAuthor(author);
       existingBook.setGenre(genre);

       System.out.println("Book Details Updated...");
    }

    public void removeBook(String title) {

        Book existingBook = library.checkBookAvailability(title);
        if(existingBook == null) {
            System.out.println("Book Not Exists");
            return;
        }

        library.removeBookInLibrary(existingBook);
        System.out.println("Book Removed...");
    }

    public void displayAllBooks() {

        System.out.println("List of Books : ");
        library.displayLibraryBooks();
    }

    public void addMember(String name) {

        User user = new User(name, 0);
        library.addMemberToLibrary(user);
        System.out.println("Member added...");
    }

    public void displayAllMembers() {

        System.out.println("List of Members : ");
        library.displayMembersInLibrary();
    }


}
