package level3.exercise1.logic;

import java.util.Scanner;


public class ManagementMenuCinema {
    private ManagementCinema managementCinema;

    public ManagementMenuCinema(ManagementCinema managementCinema){
        this.managementCinema = managementCinema;

    }

    public void displayMenu(){
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
                    managementCinema.showSeats();
                    break;
                }
                case 2: {
                    managementCinema.showSetPerson(scanner1);
                    break;
                }
                case 3: {
                    managementCinema.reserverSeats(scanner1);
                    break;
                }
                case 4: {
                    managementCinema.cancelReservation(scanner1);
                    break;
                }
                case 5: {
                    managementCinema.cancelReservationPerson(scanner1);
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
}
