package com.booking.train;

public class TicketCancelling {

    private int pnrNo;
    private int noOfSeats;
    private TrainSystem trainSystem;

    public TicketCancelling(int pnrNo, int noOfSeats) {

        this.pnrNo = pnrNo;
        this.noOfSeats = noOfSeats;
        trainSystem = TrainSystem.getInstance();
    }

    public void cancelTicket() {

        Ticket ticket = trainSystem.getTicket(pnrNo);
        char source = ticket.getSource(), destination = ticket.getDestination();

        if(ticket != null) {

            int bookedTicket = ticket.getSeats();
            if(noOfSeats < bookedTicket) {

                ticket.setSeats(bookedTicket - noOfSeats);
                trainSystem.storePartiallyCancelledSeats(pnrNo, noOfSeats);
                System.out.println("Ticket Cancelled Partially : " + '\n' + "PNR No : " + pnrNo);
            }

            else {

                trainSystem.processCancellation(pnrNo, ticket);
                System.out.println("Ticket Cancelled Successfully");
            }

            trainSystem.increaseSeatsAvailability(source, destination, noOfSeats);
            WaitingListManager waitingListManager = new WaitingListManager(source, destination, noOfSeats);
            waitingListManager.processWaitingList();

        }

        else {

            System.out.println("Invalid PNR No");
        }
    }
}
