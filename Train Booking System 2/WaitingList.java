package com.booking.train;

public class WaitingList {

    private char source;
    private char destination;
    private int noOfSeats;
    private TicketStatus ticketStatus;
    private TrainSystem trainSystem;

    public WaitingList(char source, char destination, int noOfSeats) {

        this.source = source;
        this.destination = destination;
        this.noOfSeats = noOfSeats;

        trainSystem = TrainSystem.getInstance();
    }

    public void addToWaitingList() {

        Ticket ticket = new Ticket(source, destination, noOfSeats, TicketStatus.WaitingList);
        int newPnr = ticket.getpnrNo();
        trainSystem.addWaitingListQueue(newPnr, ticket);
        trainSystem.seatsBookedInWL += noOfSeats;
        System.out.println("Ticket Booked in Waiting List");
        System.out.println("Your PNR Number is : " + newPnr);
    }

    public void execute() {
        this.addToWaitingList();
    }

}