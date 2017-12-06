package com.walmartlabs.console;

import com.walmartlabs.ticketing.SeatHold;
import com.walmartlabs.ticketing.TicketService;
import com.walmartlabs.ticketing.TicketServiceTS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by LEYED on 12/4/17.
 */
public class ConsoleManagerImpl implements ConsoleManager {

    Scanner scanner = new Scanner(System.in);
    TicketService ticketService;

    public ConsoleManagerImpl() {
    }

    public void startListeningCommands(){
        ticketService = new TicketServiceTS();
        boolean listeningCommand = true;

        while(listeningCommand == true){
            System.out.println(":~ User: ");
            String command = scanner.next();
            switch (command){
                case "hold" :
                    findAndHold();
                    break;
                case "reserve":
                    reserveSeats();
                    break;
                case "available":
                    seatCount();
                    break;
                case "status":
                    printSeatHolds();
                    break;
                case "exit":
                    listeningCommand = false;
                    break;
            }
        }
    }

    private void findAndHold(){
        System.out.println("Enter the number of seats: ");
        Integer numberOfSeats = scanner.nextInt();
        System.out.println("Enter the user email: ");
        String email = scanner.next();
        SeatHold seatHold = ticketService.findAndHoldSeats(numberOfSeats, email);
        System.out.println("Your seats had been hold with reservation number: " + seatHold.getSeatHoldId() +
                " for 5 minutes, please finish your reservation with this number and your email");
    }

    private void reserveSeats(){
        System.out.println("Enter your reservation ID: ");
        Integer reservationId = scanner.nextInt();
        System.out.println("Enter the user email that you used to make the reservation: ");
        String email = scanner.next();
        System.out.println(ticketService.reserveSeats(reservationId, email));
    }

    private void seatCount(){
        System.out.println("There are " + ticketService.numSeatsAvailable() + " available seats");
    }

    private void printSeatHolds(){
        ArrayList<SeatHold> allSeatHolds = ticketService.getAllSeatHolds();
        System.out.println("ID\tUSER\t\tSTATUS\tTIME REMAINING");
        System.out.println("--------------------------------------");
        allSeatHolds.forEach(seatHold ->
                System.out.printf(seatHold.getSeatHoldId() + "\t" +
                        seatHold.getUserEmail() + "\t" +
                        seatHold.getSeatHoldStatus() + "\t\t" +
                        getTimeFromMillis(seatHold.getHoldTimer())+ "\n"));
    }

    private String getTimeFromMillis(int millis){
        return String.format("%d min, %d sec",
            TimeUnit.MILLISECONDS.toMinutes(millis),
            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }
}
