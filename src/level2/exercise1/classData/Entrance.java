package level2.exercise1.classData;

import level2.exercise1.exceptions.ReadCharException;
import level2.exercise1.exceptions.ReadStringException;
import level2.exercise1.exceptions.ReadYesNoException;

import java.util.*;

public class Entrance {
    public static byte readByte(String message, Scanner scanner) throws InputMismatchException {

        byte age = 0;
        boolean goodInput = false;

        while (!goodInput) {

            try {
                System.out.print(message);
                age = scanner.nextByte();

                goodInput = true;
            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a valid byte (-128 to 127).");
                scanner.nextLine();

            }
        }
        return age;

    }


    public static int readInt(String message, Scanner scanner) throws InputMismatchException {

        int number = 0;
        boolean good = false;

        while (!good) {

            try {
                System.out.println(message);
                number = scanner.nextInt();

                good = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number integer.");
                scanner.nextLine();

            }

        }
        return number;
    }

    public static float floatNumberRead(String message, Scanner scanner) throws InputMismatchException {

        float fNumber = 0.0f;
        boolean goodFloat = false;

        while (!goodFloat) {

            try {
                System.out.println(message);
                fNumber = scanner.nextFloat();

                goodFloat = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number float");
                scanner.nextLine();


            }
        }
        return fNumber;

    }

    public static double readDouble(String message, Scanner scanner) throws InputMismatchException {

        double dNumber = 0.0;
        boolean goodDouble = false;

        while (!goodDouble) {

            try {
                System.out.println(message);
                dNumber = scanner.nextDouble();

                goodDouble = true;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number double");
                scanner.nextLine();


            }
        }
        return dNumber;
    }

    public static char readChar(String message, Scanner scanner) {
        char charA;
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.next();

                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                    charA = input.charAt(0);
                    break;
                } else {
                    throw new ReadCharException("Invalid input. Please enter a valid character.");
                }

            } catch (ReadCharException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return charA;
    }


    public static String readString(String message, Scanner scanner) {

        String genericError;
        while (true) {

            try {
                System.out.println(message);
                genericError = scanner.next();
                scanner.nextLine();


                if(genericError.matches("[a-zA-Z]+") ){
                    System.out.println("The input es correct " + genericError);
                    break;
                } else {
                    throw new ReadStringException("Invalid input, please enter a valid input, string ");
                }


            } catch (ReadStringException e) {
                System.out.println("Error " + e.getMessage());

            }
        }
        return genericError;
    }

    public static boolean readYesNo(String message, Scanner scanner) {


        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();


                if (input.equalsIgnoreCase("Yes")) {
                    return true;


                } else if (input.equalsIgnoreCase("No")) {
                    throw new ReadYesNoException("Invalid input. Only 'Yes' is allowed.");

                } else {
                    throw new ReadYesNoException("Invalid input, please enter yes or no");
                }
            } catch (ReadYesNoException e) {
                System.out.println("Error " + e.getMessage());
            }
        }

    }
}







