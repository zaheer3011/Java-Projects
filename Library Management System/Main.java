package com.management.library;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc =  new Scanner(System.in);

        while(true) {

            System.out.println("Enter the role : (admin/user) ");
            String choice = sc.nextLine().toLowerCase();

            switch (choice) {

                case "admin": {

                    System.out.println("Enter the username : ");
                    String username = sc.nextLine();
                    System.out.println("Enter the password : ");
                    String password = sc.nextLine();

                    if (username.equals("admin") &&
                            password.equals("password")) {

                        System.out.println("Logged In as Admin..." + '\n');
                        AdminMenu adminMenu = new AdminMenu();
                        adminMenu.showMenu();
                    } else {
                        System.out.println("Invalid username or password");
                    }

                    break;
                }

                case "user": {

                    Library library = Library.getInstance();

                    System.out.println("Enter username : ");
                    String name = sc.nextLine();

                    User exisitingUser = library.getUser(name);

                    if (exisitingUser != null) {
                        System.out.println("Logged In...");
                        UserMenu userMenu = new UserMenu(exisitingUser);
                        userMenu.showMenu();
                    } else {
                        System.out.println("User doesn't exists");
                    }

                    break;
                }

                default: {

                    System.out.println("Invalid name");
                    System.exit(1);
                }
            }
        }

    }
}