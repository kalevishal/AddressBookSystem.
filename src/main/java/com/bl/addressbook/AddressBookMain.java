package com.bl.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBookMain {
    public static Scanner scan = new Scanner(System.in);
    private static final AddressBook addressBook = new AddressBook();
    public Map<String,AddressBook> addressBookListMap = new HashMap<>();
    private String addressBookName;

    public void addAddressBook(String bookName){
        AddressBookMain addressBookMain = new AddressBookMain();
        boolean flag = true;
        while(flag) {
            System.out.println("Select an option to select\n"
                    +"1] Add Contact\n"
                    +"2] Display\n"
                    +"3] Edit contact\n"
                    +"4] Delete Contact\n"
                    +"5] Exit\n"
                    + "Enter your Choice\n");
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
                case 2:
                    for (Map.Entry<String, AddressBook> entry : addressBookMain.addressBookListMap.entrySet()) {
                        AddressBook value = entry.getValue();
                        System.out.println("Address Book Name: " + entry.getKey());
                        value.checkDuplicate();
                    }
                case 3:
                    System.out.println("Enter Name of City: ");
                    String CityName = scan.next();
                    addressBookMain.searchPersonByCity(CityName);
                    break;

                case 4:
                    System.out.println("Enter Name of State: ");
                    String StateName = scan.next();
                    addressBookMain.searchPersonByState(StateName);
                    break;


                case 5:
                    System.out.println("Enter Name of State: ");
                    String state = scan.next();
                    addressBookMain.viewPersonByState(state);
                    break;

                case 6:
                    System.out.println("Enter Name of City: ");
                    String city = scan.next();
                    addressBookMain.viewPersonByCity(city);
                    break;


                case 7:
                    System.out.println("Enter the Person First name to Display ");
                    String Name = scan.next();

                    boolean list = addressBook.DisplayAddressBook(Name);
                    if (list) {
                        System.out.println("Displayed the Address Book");
                    } else {
                        System.out.println(" Cannot be Displayed");
                    }

                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
    }
    private void searchPersonByState(String stateName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByState(stateName);
        }

    }
    private void searchPersonByCity(String cityName) {
        for(Map.Entry<String,AddressBook> entry: addressBookListMap.entrySet()){
            AddressBook value = entry.getValue();
            System.out.println("The Address Book: "+entry.getKey());
            value.getPersonNameByCity(cityName);
        }

    }

    private void viewPersonByState(String stateName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactDetails> contacts = value.personByState.entrySet().stream().filter(findState -> findState.getKey().equals(stateName)).map(Map.Entry::getValue).findFirst().orElse(null);
            assert contacts != null;
            for(ContactDetails contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastName());
            }
        }
    }

    private void viewPersonByCity(String cityName) {
        for (Map.Entry<String, AddressBook> entry : addressBookListMap.entrySet()) {
            AddressBook value = entry.getValue();
            ArrayList<ContactDetails> contacts = value.personByCity.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityName)).map(Map.Entry::getValue).findFirst().orElse(null);
            assert contacts != null;
            for(ContactDetails contact: contacts){
                System.out.println("First Name: "+contact.getFirstName()+" Last Name: "+ contact.getLastName());
            }
        }
    }}