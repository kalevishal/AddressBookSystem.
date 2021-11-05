package com.bl.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static Scanner scan = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();

    public void addAddressBook(String bookName){

        boolean flag = true;

        while(flag) {

            System.out.println("1.Add Contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            System.out.println("4.Exit");
            System.out.println("Enter Choice: ");

            int option = scan.nextInt();

            switch (option)
            {
                case 1:

                    System.out.println("enter no of contacts to be added");
                    int noOfContacts = scan.nextInt();
                    for(int i = 0; i < noOfContacts; i++) {
                        addressBook.addContactDetails();
                    }
                    break;


                case 2:
                    System.out.println("Enter the Person First name to edit details: ");
                    String personName = scan.next();

                    boolean listEdited = addressBook.editContactDetails(personName);
                    if (listEdited) {
                        System.out.println("List Edited Successfully");
                    } else {
                        System.out.println("List Cannot be Edited");
                    }
                    break;
                case 3:
                    System.out.println("Enter the Contact to be deleted:");
                    String firstName = scan.next();
                    boolean listDeleted = addressBook.deleteContact(firstName);
                    if (listDeleted) {
                        System.out.println("Deleted Contact from the List");
                    } else {
                        System.out.println("List Cannot be Deleted");
                    }
                    break;
                case 4:
                    flag =false;
                    break;

            }
        }

    }
    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag =true;
        while(flag)
        {
            System.out.println("1.Add New Address Book");
            System.out.println("2.Exit");
            System.out.println("Enter choice: ");
            int option = scan.nextInt();
            switch (option){
                case 1: {
                    System.out.println("Enter the Name of Address Book: ");
                    String addressBookName = scan.next();
                    if(addressBookMain.addressBookListMap.containsKey(addressBookName)){
                        System.out.println("The Address book Already Exists");
                        break;
                    }else {
                        addressBookMain.addAddressBook(addressBookName);
                        break;
                    }
                }
                case 2:{
                    flag = false;
                    break;
                }
            }
        }
    }
}