package com.booking.train;

public class Ticket {

    private char source;
    private char destination;
    private int noOfTickets;
    private int PNRNo;
    private TicketStatus ticketStatus;

    private static int nextPNRNo = 0;

    public Ticket(char source, char destination, int noOfTickets, TicketStatus ticketStatus) {

        this.source = source;
        this.destination = destination;
        this.noOfTickets = noOfTickets;
        this.ticketStatus = ticketStatus;

        PNRNo = ++nextPNRNo;
    }

    public char getSource() { return source; }

    public char getDestination() { return destination; }

    public int getSeats() { return noOfTickets; }

    public void setSeats(int seats) {
        this.noOfTickets = seats;
    }

    public int getpnrNo() { return PNRNo; }

    public int getNoOfTickets() { return noOfTickets; }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
