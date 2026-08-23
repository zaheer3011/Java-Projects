package com.management.library;

import java.util.Scanner;

public class UserMenu {

    ;private User user;

    public UserMenu(User user) {

        this.user = user;
    }

    public void showMenu() {

        System.out.println("Library Management System");

        Library library = Library.getInstance();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: {

                    sc.nextLine();
                    System.out.println("Enter the book title to borrow : ");
                    String title = sc.nextLine();

                    library.borrowBook(title, user);
                    break;
                }

                case 2: {

                    sc.nextLine();
                    System.out.println("Enter the book title to remove : ");
                    String title = sc.nextLine();

                    library.returnBook(title, user);
                    break;
                }

                case 3: {

                    library.displayAllBooks();
                    break;
                }

                default: {

                    System.out.println("Invalid choice");
                }

            }

        } while (choice != 4);
    }
}
