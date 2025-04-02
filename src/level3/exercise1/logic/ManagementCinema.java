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


    public void menu() {
        Scanner scanner1 = new Scanner(System.in);


        if (scanner1.hasNextLine()) {
            scanner1.nextLine();
        } else {
            System.out.println("No initial entry found. Please check.");
            return;
        }


        boolean exit = false;

        do{
            System.out.println("-----Cinema Manager-----");
            System.out.println("-------------------------");
            System.out.println("---------Options---------");
            System.out.println("1-Show all reserved seats");
            System.out.println("2-Show the seats reserved for one person");
            System.out.println("3-Reserve a seat");
            System.out.println("4-Cancel the reservation of a seat");
            System.out.println("5-Cancel all reservations of a person");
            System.out.println("0-Exit");
            System.out.println("-------------------------");

            System.out.println("Selection one option");
            int numberSelected = scanner1.nextInt();
            scanner1.nextLine();

            switch (numberSelected) {
                case 1: {
                    showSeats();
                    break;
                }
                case 2: {
                    showSetPerson(scanner1);
                    break;
                }
                case 3: {
                    reserverSeats(scanner1);
                    break;
                }
                case 4: {
                    cancelReservation(scanner1);
                    break;
                }
                case 5: {
                    cancelReservationPerson(scanner1);
                    break;
                }
                case 0: {
                    System.out.println("Leaving......");
                    exit = true;
                    break;

                }
            }


        } while (!exit);

        scanner1.close();
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

                System.out.println(seat.toString());
            reservFound = true;
        }

        }
        if (!reservFound){
            System.out.println("No reservations found for: " + name);
        }

        return ("Seats reserved by " + name + toString() );
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


