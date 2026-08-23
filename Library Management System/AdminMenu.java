package com.management.library;

import java.util.Scanner;

public class AdminMenu {

   public void showMenu() {

       System.out.println("Library Management System");
       Scanner sc = new Scanner(System.in);

       Admin admin = new Admin();

       int choice;

       do {

           System.out.println("1, Add Book");
           System.out.println("2. Update Book");
           System.out.println("3. Remove Book");
           System.out.println("4. Add Member");
           System.out.println("5. Display All Books");
           System.out.println("6. Display All Members");
           System.out.println("7. Exit");
           System.out.println("Enter your choice : ");
           choice = sc.nextInt();

           switch (choice) {

               case 1 : {

                   sc.nextLine();
                   System.out.println("Enter the book Title : ");
                   String title = sc.nextLine();
                   System.out.println("Enter the Author name : ");
                   String author = sc.nextLine();
                   System.out.println("Enter the Genre :");
                   String genre = sc.nextLine();

                   admin.addBook(title, author, genre);

                   break;
               }

               case 2 : {

                   sc.nextLine();
                   System.out.println("Enter book Title to update : ");
                   String title = sc.nextLine();
                   System.out.println("Enter new author name : ");
                   String author = sc.nextLine();
                   System.out.println("Enter new genre : ");
                   String genre = sc.nextLine();

                   admin.updateBook(title, author, genre);
                   break;
               }

               case 3 : {

                   sc.nextLine();
                   System.out.println("Enter the book title to remove : ");
                   String title = sc.nextLine();

                   admin.removeBook(title);
                   break;
               }

               case 4 : {

                   sc.nextLine();
                   System.out.println("Enter user name : ");
                   String name = sc.nextLine();

                   admin.addMember(name);

                   break;
               }

               case 5 : {

                   admin.displayAllBooks();
                   break;
               }

               case 6 : {

                   admin.displayAllMembers();
                   break;
               }

               case 7 : {

                   break;
               }

               default : {

                   System.out.println("Invalid choice");
               }
           }

       } while(choice != 7);
   }

}
