package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create scanner for user input
        Scanner input = new Scanner(System.in);

        // Create ArrayList to hold all contacts
        ArrayList<AddressBook> contacts = new ArrayList<>();

        // Welcome user and ask if they'd like to use their address book
        System.out.println("Welcome to your address book!");
        System.out.println("------------------------");
        System.out.println("Would you like to use your address book? Y/N: ");

        // variable to determine if user wants to run program.
        String userRunProgram = input.nextLine().toUpperCase();

        if (userRunProgram.equals("N")) {
            System.out.println("------------------------");
            System.out.println("Okay then, have a good day!");
            System.out.println("------------------------");
        }

        // boolean to be used for while loop
        boolean runProgram;

        // Control flow variable to determine if program runs or not.
        runProgram = userRunProgram.equals("Y");

        while (runProgram) {
            // Ask the user what action they'd like to perform.
            System.out.println("------------------------");
            System.out.println("What action would you like to perform?");
            System.out.println("------------------------");
            System.out.println("Enter 'add' to add a contact.\n" +
                    "Enter 'remove' to remove a contact.\n" +
                    "Enter 'search' to search for a contact.\n" +
                    "Enter 'print' to print all contacts in your Address Book\n" +
                    "Enter 'delete' to delete all contacts from your Address Book.\n" +
                    "Enter 'quit' to quit the program.\n");

            // variable to hold the action the user wants to perform.
            String actionToPerform = input.nextLine().toLowerCase();

            // if / else-if statements to determine next steps of the program
            if (actionToPerform.equals("add")) {

                // boolean to determine if user wants to add more than one contact
                boolean addContact = true;

                while (addContact) {

                    // ask user for first name of new contact
                    System.out.println("------------------------");
                    System.out.println("Enter First Name (Required): ");
                    String firstName = input.nextLine();
                    // ask user for last name of new contact
                    System.out.println("------------------------");
                    System.out.println("Enter Last Name (Required): ");
                    String lastName = input.nextLine();
                    // ask user for email of new contact
                    System.out.println("------------------------");
                    System.out.println("Enter Email (Required): ");
                    String email = input.nextLine();
                    // ask user for phone number of new contact
                    System.out.println("------------------------");
                    System.out.println("Enter Phone Number (Required): ");
                    String phoneNum = input.nextLine();

                    // Add new contact to address book
                    AddressBook.addContact(firstName, lastName, email, phoneNum);

                    // ask user if they would like to add another contact
                    System.out.println("------------------------");
                    System.out.println("Would you like to add another contact? Y/N: ");
                    String userInput = input.nextLine().toUpperCase();

                    // If statement to determine if user wants to add
                    // another contact or return to base program
                    if (userInput.equals("N")) {
                        addContact = false;
//                        break;
                    } else if (userInput.equals("Y")) {
                        continue;
                    } else {
                        System.out.println("------------------------");
                        System.out.println("Invalid entry. Enter 'Y' or 'N'.");
                        System.out.println("------------------------");
                    }
                }
            }
            // If statement to remove a contact from the address book.
            // Use email as a unique identifier for the person to remove.
            else if (actionToPerform.equals("remove")) {
                // boolean to determine if user wants to add more than one contact
                boolean removeContact = true;

                while (removeContact) {
                    // Ask user for the email of the contact to remove
                    String email;

                    // ask user for the email of contact to remove
                    System.out.println("------------------------");
                    System.out.println("Enter contact's email: ");
                    email = input.nextLine();

                    AddressBook.removeContact(email);

                    // ask user if they would like to remove another contact
                    System.out.println("------------------------");
                    System.out.println("Would you like to remove another contact? Y/N: ");
                    String removeAnother = input.nextLine().toUpperCase();

                    // If statement to determine if we should add another contact or return to base program
                    if (removeAnother.equals("N")) {
                        removeContact = false;
                    }
                }
            }
            // If statement to search the address book for a contact
            else if (actionToPerform.equals("search")) {

                boolean searchContacts = true;

                while (searchContacts) {

                    System.out.println("Search by first name, last name, " +
                            "email, or phone number: ");

                    String searchQuery = input.nextLine();

                    AddressBook.searchContacts(searchQuery);

                    System.out.println("Would you like to search again? Y/N: ");
                    String searchAgain = input.nextLine().toUpperCase();

                    if (searchAgain.equals("N")) {
                        searchContacts = false;
                    }
                }

            }
            // If statement to print out all contacts in address book.
            else if (actionToPerform.equals("print")) {
                AddressBook.printContacts();
            }
            // if statement to clear the address book.
            else if (actionToPerform.equals("delete")) {
                AddressBook.deleteAllContacts();
            }
            // If statement to quit the program.
            else if (actionToPerform.equals("quit")) {
                System.out.println("Have a nice day!");
                runProgram = false;
            }
            // Else statement will warn user they did not enter a valid action
            else {
                System.out.println("Invalid entry. Please enter: \n" +
                        "'add', 'remove', 'print', 'search', 'delete', or 'quit'.\n");
            }

        } // while statement bracket - General program

    } // main method bracket



} // class bracket
