package com.management.email;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int choice;

        MailManagement mailManagement = new MailManagement();

        do {
            System.out.println("*****Email Management System*****");
            System.out.println("1. Store Email");
            System.out.println("2. Delete Email");
            System.out.println("3. Add Tag");
            System.out.println("4. Show Statistics");
            System.out.println("5. Search");
            System.out.println("6. WildCard Search");
            System.out.println("7. Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1 : {
                    sc.nextLine();
                    System.out.println("Sender Email : ");
                    String sender = sc.nextLine();
                    System.out.println("Receiver Email : ");
                    String receiver = sc.nextLine();
                    System.out.println("Subject : ");
                    String subject = sc.nextLine();
                    System.out.println("Content : ");
                    String content = sc.nextLine();
                    MailSystem mailSystem = new MailSystem(sender, receiver, subject, content);
                    mailManagement.storeEmail(mailSystem);
                    break;
                }

                case 2 : {
                    System.out.println("Enter the index : ");
                    int index = sc.nextInt();
                    mailManagement.deleteEmail(index);
                    break;
                }

                case 3 : {
                    System.out.println("Enter the index : ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Tag Name : ");
                    String tag = sc.nextLine();
                    mailManagement.addTag(index, tag);
                    break;
                }

                case 4 : {
                    System.out.println("Mail Statistics" + '\n' +
                            "Total mails : " + mailManagement.printNoOfMails());
                    System.out.println("Number of recent Mails : ");
                    int recent = sc.nextInt();
                    mailManagement.showStatistics(recent);
                    break;
                }

                case 5 : {
                    sc.nextLine();
                    System.out.println("Search Query : ");
                    String query = sc.nextLine();
                    mailManagement.searchMail(query);
                    break;
                }

                case 6 : {
                    System.out.println("Search Query : (Use * before) ");
                    sc.nextLine();
                    String query = sc.nextLine();
                    mailManagement.wildCardSearch(query);
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
