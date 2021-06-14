package com.company;

import java.util.ArrayList;

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
        // Create a new Contact object based on the information provided by the user.
        Contact newContact = new  Contact(firstName, lastName, email, phoneNumber);

        // If there are no contacts in the address book yet, add
        // the new contact to the address book.
        if (contactList.size() == 0) {
            contactList.add(newContact);
            System.out.println("------------------------");
            System.out.println("Successfully added contact for " +
                    newContact.getFirstName() + " " + newContact.getLastName());
            System.out.println("------------------------");
        }
        // if there is at least one contact in the address book, check
        // for the email entered by the user. We will use the email as a unique
        // identifier. If that email is already entered, do not allow the user to add
        // a duplicate. If the email is not found, add the new contact.
        else {

            boolean duplicate = false;

            for (Contact contact : contactList) {
                if (contact.getEmail().equals(email)) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                contactList.add(newContact);
                System.out.println("------------------------");
                System.out.println("Successfully added contact for " +
                        newContact.getFirstName() + " " + newContact.getLastName());
                System.out.println("------------------------");
            } else {
                System.out.println("------------------------");
                System.out.println("That email (" + newContact.getEmail() + ") is already connected with the contact: " +
                        newContact.getFirstName() + " " + newContact.getLastName());
                System.out.println("Unable to save new contact.");
                System.out.println("------------------------");
            }
        }

    }

    // Method to search all contacts in the address book based
    // off the email provided. If a contact is found with that email,
    // that contact will be removed from the address book.
    public static void removeContact(String email) {

        // boolean to determine if we found an email or not.
        boolean foundEmail = false;
        // variable to determine the index in the list for the found email
        int contactListIndex = 0;

        // Loop through contact list
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getEmail().equals(email)) {
                contactListIndex = i;
                foundEmail = true;
                break;
            }
        }

        // If no contact emails match the searchQuery, print out a message
        // alerting the user no contact has that email.
        if (foundEmail) {
            System.out.println("------------------------");
            System.out.println("Successfully removed contact for " +
                    contactList.get(contactListIndex).getFirstName() + " " + contactList.get(contactListIndex).getLastName());
            System.out.println("------------------------");
            contactList.remove(contactListIndex);
        } else {
            System.out.println("------------------------");
            System.out.println("Unable to find a contact with the email " + "'" + email + "'.");
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
                System.out.println("     ");
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

        // if statement to determine if there are any contacts in the
        // address book to print.
        if (contactList.size() > 0) {
            // loop through address book and print out the
            // contact info for each contact
            for (Contact contact : contactList) {
                System.out.println("------------------------");
                System.out.println("Contact #" + contactNum);
                System.out.println("Name: " + contact.getFirstName() + " " + contact.getLastName() +
                        "\nEmail: " + contact.getEmail() + "\nPhone Number: " + contact.getPhoneNumber());
                System.out.println("------------------------");
                System.out.println("     ");
                contactNum++;
            }
        }
        // If there are no contacts in the address book print a
        // statement letting the user know the address book is empty
        else {
            System.out.println("------------------------");
            System.out.println("There are no contacts in your address book!");
            System.out.println("------------------------");
        }

    }

    // Method to delete all contacts from the address book
    public static void deleteAllContacts() {

        // if statement to determine if the address book has
        // any contacts to delete
        if (contactList.size() > 0) {
            contactList.clear();
            System.out.println("------------------------");
            System.out.println("All contacts have been deleted!");
            System.out.println("------------------------");
    }
        // If there are no contacts in the address book print a
        // statement letting the user know the address book is empty
        else {
            System.out.println("------------------------");
            System.out.println("There are no contacts in your address book!");
            System.out.println("------------------------");
        }
    }

}
