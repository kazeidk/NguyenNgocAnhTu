package util;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Utility class for handling user input
 */
public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Get string input from user
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Get integer input from user with validation
     */
    public static int getInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    /**
     * Get double input from user with validation
     */
    public static double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    /**
     * Get validated name from user
     */
    public static String getValidName(String prompt) {
        while (true) {
            String name = getString(prompt);
            if (Validator.isValidName(name)) {
                return name;
            }
            System.out.println("Invalid name! Please enter a valid name (letters and spaces only, at least 2 characters).");
        }
    }

    /**
     * Get validated phone number from user
     */
    public static String getValidPhoneNumber(String prompt) {
        while (true) {
            String phone = getString(prompt);
            if (Validator.isValidPhoneNumber(phone)) {
                return phone;
            }
            System.out.println("Invalid phone number! Please enter 10-11 digits.");
        }
    }

    /**
     * Get validated date from user
     */
    public static LocalDate getValidDate(String prompt) {
        while (true) {
            String dateStr = getString(prompt);
            LocalDate date = Validator.parseDate(dateStr);
            if (date != null && Validator.isValidBookingDate(date)) {
                return date;
            }
            if (date != null && date.isBefore(LocalDate.now())) {
                System.out.println("Cannot book for past dates! Please enter a current or future date.");
            } else {
                System.out.println("Invalid date format! Please use dd/MM/yyyy format.");
            }
        }
    }

    /**
     * Get confirmation from user (Y/N)
     */
    public static boolean getConfirmation(String prompt) {
        while (true) {
            String input = getString(prompt + " (Y/N): ").toUpperCase();
            if (input.equals("Y") || input.equals("YES")) {
                return true;
            } else if (input.equals("N") || input.equals("NO")) {
                return false;
            }
            System.out.println("Please enter Y or N.");
        }
    }

    /**
     * Pause and wait for user to press Enter
     */
    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
