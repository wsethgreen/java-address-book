package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    // instance variables
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    // ArrayList to hold contacts added to Address Book.
    public static ArrayList<Contact> contactList = new ArrayList<>();

    // Constructors
    public AddressBook() {
        // empty constructor
    };

    public AddressBook(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "AddressBook{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // Methods to add, remove, print, delete, and search address book.

    // // Method to add a new contact to the address book
    public static void addContact(String firstName, String lastName, String email, String phoneNumber) {
        Contact newContact = new  Contact(firstName, lastName, email, phoneNumber);
        contactList.add(newContact);
    }

    // Method to search all contacts in the address book based
    // off the email provided. If a contact is found with that email,
    // that contact will be removed from the address book.
    public static void removeContact(String email) {

        // Check for valid email
        int noEmailMatch = 0;

        // Loop through contact list
        for (Contact contact : contactList) {
            boolean validEmail;
            if (contact.getEmail().equals(email)) {
                contactList.remove(contact);
                System.out.println("------------------------");
                System.out.println("Successfully removed contact for " +
                        contact.getFirstName() + " " + contact.getLastName());
                System.out.println("------------------------");
            } else {
                noEmailMatch++;
            }
        }

        // If no contact emails match the searchQuery, print out a message alerting
        // the user no
        if (noEmailMatch == contactList.size()) {
            System.out.println("------------------------");
            System.out.println("Unable to find a contact with the email " + email);
            System.out.println("No Contacts removed from the address book.");
            System.out.println("------------------------");
        }
    }

    // Method to search all contacts in the address book and
    // print out the contacts that meet the search query
    public static void searchContacts(String searchQuery) {

        // Array List to hold search results.
        ArrayList<Contact> searchResults = new ArrayList<>();

        for (Contact contact : contactList) {
            if (contact.getFirstName().contains(searchQuery)) {
                searchResults.add(contact);
            } else if (contact.getLastName().contains(searchQuery)) {
                searchResults.add(contact);
            } else if (contact.getEmail().contains(searchQuery)) {
                searchResults.add(contact);
            }  else if (contact.getPhoneNumber().contains(searchQuery)) {
                searchResults.add(contact);
            }
        }

        // If the search query finds results, print out the results
        if (searchResults.size() > 0) {
            int resultNum = 1;
            System.out.println("Search Results: ");
            for (AddressBook contact : searchResults) {
                System.out.println("------------------------");
                System.out.println("Result #" + resultNum);
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName() +
                        "\nEmail: " + contact.getEmail() + "\nPhone Number: " + contact.getPhoneNumber());
                System.out.println("------------------------");
                resultNum++;
            }
        }
        // if the search query doesn't find results, print out a message saying so.
        else {
            System.out.println("------------------------");
            System.out.println("Unable to find a contact by searching " + "'" +
                    searchQuery + "'.");
            System.out.println("------------------------");
        }
    }

    // Method to print all contacts in the address book
    public static void printContacts() {
        // Set contact number
        int contactNum = 1;
        // loop through address book and print out the
        // contact info for each contact
        for (Contact contact : contactList) {
            System.out.println("------------------------");
            System.out.println("Contact #" + contactNum);
            System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName() +
                    "\nEmail: " + contact.getEmail() + "\nPhone Number: " + contact.getPhoneNumber());
            System.out.println("------------------------");
            contactNum++;
        }
    }

    // Method to delete all contacts from the address book
    public static void deleteAllContacts() {
        contactList.clear();
        System.out.println("------------------------");
        System.out.println("All contacts have been deleted!");
        System.out.println("------------------------");
    }

}
