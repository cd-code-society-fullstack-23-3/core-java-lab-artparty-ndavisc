package com.codedifferently.artparty;

import com.codedifferently.artparty.Guest;
import com.codedifferently.artparty.GuestORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/guestBook";
        String user = "root";
        String password = "my-secret-pw";

        // Establishing connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            GuestORM guestORM = new GuestORM(connection);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Choose an action: \n1. Create Guest\n2. Read Guest\n3. Update Guest\n4. Delete Guest\n5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createGuest(scanner, guestORM);
                        break;
                    case 2:
                        readGuest(scanner, guestORM);
                        break;
                    case 3:
                        updateGuest(scanner, guestORM);
                        break;
                    case 4:
                        deleteGuest(scanner, guestORM);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void createGuest(Scanner scanner, GuestORM guestORM) {
        System.out.println("Creating a new guest...");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
//        scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();


        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Guest guest = new Guest(firstName, lastName, email);
        guestORM.createGuest(guest);
        System.out.println("Guest created successfully.");
    }

    private static void readGuest(Scanner scanner, GuestORM guestORM) {
        System.out.print("Enter the ID of the guest to read: ");
        long id = scanner.nextLong();
        Guest guest = guestORM.readGuest(id);
        if (guest != null) {
            System.out.println("Guest Details: " + guest);
        } else {
            System.out.println("Guest not found.");
        }
    }

    private static void updateGuest(Scanner scanner, GuestORM guestORM) {
        System.out.println("Updating a guest...");
        System.out.print("Enter ID of guest to update: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        // Fetch existing invite
        Guest guest = guestORM.readGuest(id);
        if (guest == null) {
            System.out.println("Guest not found.");
            return;
        }


        System.out.print("Enter new First Name (leave blank to keep current): ");
        String firstName = scanner.nextLine();

        System.out.print("Enter new Last Name (leave blank to keep current): ");
        String lastName = scanner.nextLine();

        System.out.print("Enter new Email (leave blank to keep current): ");
        String email = scanner.nextLine();

        // Update fields if provided
        if (!email.isEmpty()) guest.setEmail(email);
        if (!firstName.isEmpty()) guest.setFirstName(firstName);
        if (!lastName.isEmpty()) guest.setLastName(lastName);

        guestORM.updateGuest(guest);
        System.out.println("Guest updated successfully.");
    }

    private static void deleteGuest(Scanner scanner, GuestORM guestORM) {
        System.out.print("Enter the ID of the guest to delete: ");
        long id = scanner.nextLong();
        guestORM.deleteGuest(id);
        System.out.println("Guest deleted successfully.");
    }
}
