package com.booking.train;

public class WaitingListManager {

    private char source;
    private char destination;
    private int noOfSeats;
    private TicketStatus ticketStatus;
    private TrainSystem trainSystem;

    public WaitingListManager(char source, char destination, int noOfSeats) {

        this.source = source;
        this.destination = destination;
        this.noOfSeats = noOfSeats;

        trainSystem = TrainSystem.getInstance();
    }

    public void processWaitingList() {

        for(Ticket waiting : trainSystem.waitingListQueue.values()) {

            char waitedSource = waiting.getSource();
            char waitedDestination = waiting.getDestination();
            int waitedNoOfSeats = waiting.getSeats();

            if(trainSystem.checkSeatsAvailability(waitedSource, waitedDestination, waitedNoOfSeats)) {
                trainSystem.decreaseSeatsAvailability(waitedSource, waitedDestination, waitedNoOfSeats);
                updateWaitingListToBooked(waiting);
            }
        }
    }

    public void updateWaitingListToBooked(Ticket waiting) {

        waiting.setTicketStatus(TicketStatus.Booked);
        int pnrNo = waiting.getpnrNo();
        trainSystem.addTickets(pnrNo, waiting);
        trainSystem.waitingListQueue.remove(pnrNo);
        System.out.println("Booking Confirmed for pnr No : " + pnrNo);
    }

    public void addToWaitingListManager(char source, char destination, int noOfSeats) {

        WaitingList waitingList = new WaitingList(source, destination, noOfSeats);
        waitingList.execute();
    }
}
