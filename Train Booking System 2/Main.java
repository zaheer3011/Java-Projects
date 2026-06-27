package com.booking.train;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Train Booking System");
        int choice;

        do {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Summary");
            System.out.println("4. Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 : {

                    sc.nextLine();
                    System.out.println("Enter the Source : ");
                    char source = sc.nextLine().toUpperCase().charAt(0);
                    System.out.println("Enter the Destination : ");
                    char destination = sc.nextLine().toUpperCase().charAt(0);
                    System.out.println("Enter the No of Tickets : ");
                    int noOfTickets = sc.nextInt();

                    if(source != destination) {
                        TicketBooking ticketBooking = new TicketBooking(source, destination, noOfTickets);
                        ticketBooking.bookTicket();
                    }

                    else {
                        System.out.println("Enter valid stations");
                    }

                    break;
                }

                case 2 : {

                    System.out.println("Enter the PNR No");
                    int pnrNo = sc.nextInt();
                    System.out.println("Enter the Number of Tickets : ");
                    int noOfTickets = sc.nextInt();

                    TicketCancelling ticketCancelling = new TicketCancelling(pnrNo, noOfTickets);
                    ticketCancelling.cancelTicket();
                    break;
                }

                case 3 : {

                    TrainSystem trainSystem = TrainSystem.getInstance();
                    trainSystem.printSummary();
                    break;
                }

                case 4 : {

                    break;
                }

                default : {

                    System.out.println("Invalid Choice");
                }
            }
        } while(choice != 4);
    }

}
