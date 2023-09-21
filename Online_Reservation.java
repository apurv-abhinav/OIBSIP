
//@author Apurv Abhinav

import java.util.Scanner;

public class Online_Reservation {

    private static boolean[] seats = new boolean[10]; 
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {

        while (true) {

            // Display menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Seat Map");
            System.out.println("2. Reserve Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");

            // Get user input
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeatMap();
                    break;

                case 2:
                    reserveSeat();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    scanner.close(); 
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }

    }

    private static void viewSeatMap() {
        System.out.println("\nCurrent Seat Map:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); 
            } else {
                System.out.print((i + 1) + " "); 
            }
        }
        System.out.println();
    }

    private static void reserveSeat() {
        System.out.print("\nEnter seat number (1-10): ");
        
        if (scanner.hasNextInt()) {
            int seatNumber = scanner.nextInt();
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number!");
            } else if (seats[seatNumber - 1]) {
                System.out.println("Seat already reserved!");
            } else {
                seats[seatNumber - 1] = true; 
                System.out.println("Seat reserved!");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid seat number.");
            scanner.next(); 
        }
    }

    private static void cancelReservation() {
        System.out.print("\nEnter seat number (1-10): ");
        
        if (scanner.hasNextInt()) {
            int seatNumber = scanner.nextInt();
            if (seatNumber < 1 || seatNumber > 10) {
                System.out.println("Invalid seat number!");
            } else if (!seats[seatNumber - 1]) {
                System.out.println("Seat not reserved!");
            } else {
                seats[seatNumber - 1] = false; 
                System.out.println("Reservation canceled!");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid seat number.");
            scanner.next();
        }
    }
}
