package level2.exercise1.mainManager;

import level2.exercise1.classData.Entrance;

import java.util.Scanner;

public class MainEntrance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        byte age = Entrance.readByte("Please enter a byte number (-128 to 127): ", scanner);
        System.out.println("The number is " + age);
        System.out.println("The number is correct, bye bye...");

        int number = Entrance.readInt("Please enter an integer number: ", scanner);
        System.out.println("The number is " + number);
        System.out.println("The number is correct, bye bye...");

        float fNumber = Entrance.floatNumberRead("Please enter a float number: ", scanner);
        System.out.println("The number is " + fNumber);
        System.out.println("The number is correct, bye bye...");

        double dNumber = Entrance.readDouble("Please enter a double number: ", scanner);
        System.out.println("The number is " + dNumber);
        System.out.println("The number is correct, bye bye...");

        char charA = Entrance.readChar("Please enter a char: ", scanner);
        System.out.println("The char is " + charA);
        System.out.println("The char is correct bye bye..");

        String errorString = Entrance.readString("Please enter a new String: ", scanner);
        System.out.println("The string is: " + errorString);
        System.out.println("The string is correct bye bye..");

        boolean entry = Entrance.readYesNo("Please enter yes or no: ", scanner);
        System.out.println("The string is: " + entry);
        System.out.println("The string is correct bye bye..");



        scanner.close();
    }
}
