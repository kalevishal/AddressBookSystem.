package com.bl.addressbook;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    AddressBookRepo addressBookRepo = new AddressBookRepo();
    Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        AddressBook addressBook=new AddressBook();
        addressBook.retrieveData();
        addressBook.updateSalary();
        addressBook.getContactsInDatePeriod();
        addressBook.countByCity();
        addressBook.countByState();
    }

    private void countByState() {
        System.out.println("Enter state name");
        int stateContactsCount=  addressBookRepo.countByState(scanner.next());
        System.out.println("Number of Contacts is Given state= " + stateContactsCount);
    }

    private void countByCity() {
        System.out.println("Enter city Name");
        int cityContactsCount = addressBookRepo.countByCity(scanner.next());
        System.out.println("Number of Contacts is Given city= " + cityContactsCount);
    }

    private void getContactsInDatePeriod() throws SQLException {
        addressBookRepo.getContactsInDatePeriod();
    }

    private void retrieveData () throws SQLException {
        List<Person> employeeInfoList = addressBookRepo.retrieveData();
        System.out.println(employeeInfoList);
    }
    private void updateSalary() {
        addressBookRepo.updateSalary("Mona",5000);
    }

}