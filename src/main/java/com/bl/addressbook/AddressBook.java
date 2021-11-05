package com.bl.addressbook;

import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
    static String firstName;
    static ArrayList<ContactDetails> list=new ArrayList<ContactDetails>();
    static Scanner scan =new Scanner(System.in);
    public void Add_Contact(ContactDetails c) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Add Contact  \n");
        System.out.print("Enter First Name: ");
        c.setFirstName(scanner.nextLine());
        System.out.print("Enter Last Name : ");
        c.setLastName(scanner.nextLine());
        System.out.print("Enter City : ");
        c.setCity(scanner.nextLine());
        System.out.print("Enter State : ");
        c.setState(scanner.nextLine());
        System.out.print("Enter zip : ");
        c.setZip(scanner.nextInt());
        System.out.print("Enter PhoneNumber: ");
        c.setPhoneNo(scanner.nextLong());
        System.out.print("Enter Email ID : ");
        c.setEmail(scanner.next());
        list.add(c);
    }
    public void editContact(ContactDetails c, String f_name ) {
        for (int i = 0; i < list.size(); i++) {
            c = (ContactDetails) list.get(i);
            if (f_name.equals(c.getFirstName())) {
                System.out.print("Enter new First Name: ");
                c.setFirstName(scan.nextLine());
                System.out.print("Enter  new Last Name : ");
                c.setLastName(scan.nextLine());
                System.out.print("Enter new City : ");
                c.setCity(scan.nextLine());
                System.out.print("Enter new State : ");
                c.setState(scan.nextLine());
                System.out.print("Enter new zip : ");
                c.setZip(scan.nextInt());
                System.out.print("Enter new PhoneNumber: ");
                c.setPhoneNo(scan.nextLong());
                System.out.print("Enter new Email ID : ");
                c.setEmail(scan.nextLine());
                list.set(i, c);
                System.out.println(list);
            } else
                System.out.println("Not Found");
        }
    }
    public void deleteContact(ContactDetails c,String firstName){
        for (int i = 0; i < list.size(); i++) {
            c = (ContactDetails) list.get(i);
            if (firstName.equals(c.getFirstName())) {
                list.remove(i);
            }
        }
    }
    public static void main(String[] args) {
        AddressBook book=new AddressBook();
        ContactDetails c;
        int option;
        do
        {
            System.out.println("Enter your option: ");
            System.out.println("1.Add contact");
            System.out.println("2.Edit Contact");
            System.out.println("3.Delete Contact");
            option= scan.nextInt();
            c=new ContactDetails();
            Scanner sc=new Scanner(System.in);

            switch (option)
            {
                case 1:
                    book.Add_Contact(c);
                    break;
                case 2:
                    System.out.println("Enter first name that you want to edit:");
                    firstName = sc.nextLine();
                    book.editContact(c,firstName);
                    break;
                case 3:
                    System.out.println("Enter first name that you want to delete:");
                    firstName=sc.nextLine();
                    book.deleteContact(c,firstName);
                    break;
            }
            System.out.println("Do you want to continue: Enter 1.Continue or 0.Exit)");
            option= scan.nextInt();
        }
        while (option!=0);
    }