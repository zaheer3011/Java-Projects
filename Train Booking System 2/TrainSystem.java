package com.booking.train;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TrainSystem {

    private final int NO_OF_SEATS = 8;
    private final int NO_OF_WAITING_LIST = 2;
    private final int NO_OF_STATIONS = 5;

    private Map <Integer, Ticket> ticketBooked = new HashMap <> ();

    // Adding Tikcet into the Waiting List Map
    protected ConcurrentHashMap<Integer, Ticket> waitingListQueue = new ConcurrentHashMap <> ();

    private Map<Integer, Integer> partiallyCancelled = new HashMap <> ();

    // Maintaining the number of Canceled Ticket
    private Map<Integer, Ticket> cancelledTicketQueue = new HashMap <> ();

    // No of seats in a train
    private final int[] seatsAvailable = new int[NO_OF_STATIONS];

    // THis variable is used Increase the waiting List Ticket
    protected int seatsBookedInWL = 0;

    public TrainSystem() {

        Arrays.fill(seatsAvailable, NO_OF_SEATS);
    }

    private static TrainSystem instance = null;

    public static TrainSystem getInstance() {

        if(instance == null) {
            instance = new TrainSystem();
        }

        return instance;
    }

    // Check seat availability
    public boolean checkSeatsAvailability(char source, char destination, int noOfTickets) {

        for(int i = source - 'A'; i < destination - 'A'; i++) {
            if(seatsAvailable[i] < noOfTickets)
                return false;
        }

        return true;
    }

    public void increaseSeatsAvailability(char source, char destination, int noOfTickets) {

        for(int i=source-'A'; i<destination-'A'; i++) {
            seatsAvailable[i] += noOfTickets;
        }
    }
    
    public void decreaseSeatsAvailability(char source, char destination, int noOfTickets) {
        
        for(int i=source-'A'; i<destination-'A'; i++) {
            seatsAvailable[i] -= noOfTickets;
        }
    }

    // Ticket Confirmation
    public void addTickets(int pnrNo, Ticket ticket) {

        ticketBooked.put(pnrNo, ticket);
    }

    public void addWaitingListQueue(int newPnr, Ticket ticket) {
        waitingListQueue.put(newPnr, ticket);
    }

    public Ticket getTicket(int pnrNo) {

        Ticket ticket = ticketBooked.get(pnrNo);
        return ticket;
    }

    public void storePartiallyCancelledSeats(int pnrNo, int noOfTickets) {

        partiallyCancelled.put(pnrNo, partiallyCancelled.getOrDefault(pnrNo, 0) + noOfTickets);
//        partiallyCancelled.merge(pnrNo, noOfTickets, Integer::sum);
    }

    public void processCancellation(int pnrNo, Ticket ticket) {

        Integer partialSeat = partiallyCancelled.get(pnrNo);
        partialSeat = partialSeat != null ? partialSeat : 0;
        ticket.setSeats(ticket.getSeats() + partialSeat);
        addToCancelledTicketQueue(pnrNo, ticket);
    }

    public void addToCancelledTicketQueue(int pnrNo, Ticket ticket) {

        ticket.setTicketStatus(TicketStatus.Cancelled);
        cancelledTicketQueue.put(pnrNo, ticket);
        removeFromBookedTicket(pnrNo);
    }

    public void removeFromBookedTicket(int pnrNo) {

        ticketBooked.remove(pnrNo);
    }

    public void printSummary() {

        // Confirmed Ticket
        System.out.println("\n Tickets Booked : ");
        ticketBooked.values().forEach(System.out::println);

        // Canceled Ticket
        System.out.println("\n Tickets Canceled : ");
        cancelledTicketQueue.values().forEach(System.out::println);

        // WaitingList TIcket
        System.out.println("\n Waiting List Tickets : ");
        waitingListQueue.values().forEach(System.out::println);

        System.out.println("\n\tSeats Availability : " + Arrays.toString(seatsAvailable));

        System.out.println("\n\t Seats Booked : ");
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");

        for(int i='A'; i<='E'; i++) {
            System.out.print((char) i);

            int bookedSeat = 8 - seatsAvailable[i - 'A'];
            for(int j=1; j<=bookedSeat; j++) {
                System.out.print("\t*");
            }

            System.out.println();
        }
    }

}
