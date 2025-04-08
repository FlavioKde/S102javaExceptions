package level3.exercise1.classData;

import level3.exercise1.logic.ManagementCinema;
import level3.exercise1.logic.ManagementMenuCinema;
import level3.exercise1.logic.ManagementRow;

import java.util.Scanner;

public class Cinema {
    private int rowCinema;
    private int seatPerRow;
    private ManagementRow managementRow;
    private ManagementCinema managementCinema;
    private ManagementMenuCinema managementMenuCinema;

    public Cinema() {
        this.managementRow = new ManagementRow();
        this.managementCinema = new ManagementCinema(this, managementRow);
        this.managementMenuCinema = new ManagementMenuCinema(managementCinema);
        requestInitialData();
        loadCinema();

    }

    public int getRowCinema() {
        return rowCinema;
    }

    public int getSeatPerRow() {
        return seatPerRow;
    }

    public ManagementRow getManagementRow() {
        return managementRow;
    }

    public void requestInitialData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, tell me the number of rows in the cinema");
        while (true) {
            rowCinema = scanner.nextInt();
            scanner.nextLine();
            if (rowCinema > 0) {
                break;
            }
            System.out.println("The number of rows must be positive. Try again");

        }
        System.out.println("Please, tell me the number of seat in the cinema");
        while (true) {
            seatPerRow = scanner.nextInt();
            scanner.nextLine();
            if (seatPerRow > 0) {
                break;
            }
            System.out.println("The number of rows must be positive. Try again");
        }

    }

    public void loadCinema() {

        //managementCinema.menu();
        managementMenuCinema.displayMenu();

    }
}