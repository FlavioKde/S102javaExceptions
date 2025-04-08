package level3.exercise1.logic;

import level3.exercise1.classData.Cinema;
import level3.exercise1.classData.Seat;
import level3.exercise1.exceptions.*;

import java.util.Scanner;
import java.util.*;

public class ManagementCinema {
    private Cinema cinema;
    private ManagementRow managementRow;



    public ManagementCinema(Cinema cinema, ManagementRow managementRow ) {
        this.cinema = cinema;
        this.managementRow = managementRow;

    }


    public void showSeats() {

        if (managementRow.getSeatCinemas().isEmpty()) {
            System.out.println("No seats reserved.");

        } else {
            for (Seat seat : managementRow.getSeatCinemas()){
                System.out.println("Reserved seat: Row " + seat.getRow() + ", Seat " + seat.getSeat() + ", Reserved by " + seat.getName());
        }
        }

    }

    public String showSetPerson(Scanner scanner1) {
        String name = introducePerson(scanner1);
        boolean reservFound = false;

        for (Seat seat: managementRow.getSeatCinemas()){
            if (seat.getName().equalsIgnoreCase(name)){

                System.out.println(seat);
            reservFound = true;
        }

        }
        if (!reservFound){
            System.out.println("No reservations found for: " + name);
        }

        return ("Seats reserved by " + name );
    }


    public void reserverSeats(Scanner scanner) {

        try {
            int row = introduceRow(scanner);
            int seatNumber = introduceSeat(scanner);

            scanner.nextLine();
            String customerName = introducePerson(scanner);


            Seat newSeat = new Seat(row, seatNumber, customerName);
            managementRow.addSeat(newSeat);

            System.out.println("Seat successfully reserved: Row " + row + ", Seat " + seatNumber);
        } catch (ExceptionReservedSeat e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }


    }
    public void cancelReservation(Scanner scanner) {
        ManagementRow managementRow = cinema.getManagementRow();
        try {

            int seat = introduceRow(scanner);


            int raw = introduceSeat(scanner);

            managementRow.deleteSeat(raw, seat);


        } catch (ExceptionSeatFree e) {
            System.out.println("Error "+e.getMessage());
        }
    }

    public void cancelReservationPerson(Scanner scanner) {

        System.out.println("What's the name, for canceling the reservation?");
        String name = introducePerson(scanner);

        ArrayList<Seat> toRemove = new ArrayList<>();
        for (Seat seat : managementRow.getSeatCinemas()) {
            if (seat.getName().equalsIgnoreCase(name)) {
                toRemove.add(seat);
            }
        }

        if (toRemove.isEmpty()) {
            System.out.println("No reservations found for " + name + ".");
        } else {
            for (Seat seat : toRemove) {
                System.out.println("Removing reservation: Row " + seat.getRow() + ", Seat " + seat.getSeat());
            }
                managementRow.getSeatCinemas().removeAll(toRemove);
                System.out.println("All reservations for " + name + " have been canceled.");

        }

    }

    public String introducePerson(Scanner scanner) throws ExceptionNomPersonIncorrect {
        System.out.println("Please give me the name:");
        String name = scanner.nextLine().trim();

        if (!name.matches("[a-zA-Z]+")) {
            throw new ExceptionNomPersonIncorrect("Incorrect name! try again ");

        }
        return name;

    }

    public int introduceRow(Scanner scanner) throws ExceptionBadRow {
        System.out.println("Introduce the number of the raw:");
        int raw = scanner.nextInt();

        if (raw < 1 || raw > cinema.getRowCinema()) {
            throw new ExceptionBadRow("Incorrect row! It must be between 1 and" +
                    " " + cinema.getRowCinema());
        }

        return raw;
    }

    public int introduceSeat(Scanner scanner) throws ExceptionSeatIncorrecte {
        System.out.println("Introduce a number of the seat:");
        int seat = scanner.nextInt();

        if (seat < 1 || seat > cinema.getSeatPerRow()) {
            throw new ExceptionSeatIncorrecte("Incorrect seat! It must be between 1 and "
                    + cinema.getSeatPerRow());
        }

        return seat;
    }
}


