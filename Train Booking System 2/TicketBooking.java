package com.booking.train;

public class TicketBooking {

    private char source;
    private char destination;
    private int noOfTickets;
    private TicketStatus ticketStatus;
    private TrainSystem trainSystem;

    public TicketBooking(char source, char destination, int noOfTickets) {

        this.source = source;
        this.destination = destination;
        this.noOfTickets = noOfTickets;
        this.trainSystem = TrainSystem.getInstance();
    }

    public void bookTicket() {

        if(trainSystem.checkSeatsAvailability(source, destination, noOfTickets)) {

            Ticket ticket = new Ticket(source, destination, noOfTickets, TicketStatus.Booked);
            int newPnr = ticket.getpnrNo();
            trainSystem.addTickets(newPnr, ticket);
            System.out.println("Ticket Booked Successfully");
            System.out.println("Your PNR Number is : " + newPnr);
            trainSystem.decreaseSeatsAvailability(source, destination, noOfTickets);
        }

        else {

            if(trainSystem.seatsBookedInWL + noOfTickets > 2) {
                System.out.println("Tickets not available from  " + source + " --> " + destination);
            }

            else {
                WaitingListManager waitingListManager = new WaitingListManager(source, destination, noOfTickets);
                waitingListManager.addToWaitingListManager(source, destination, noOfTickets);
            }
        }
    }




}
