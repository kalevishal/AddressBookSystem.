package com.bl.addressbook;

import java.util.ArrayList;
import java.util.Scanner;
public class AddressBook {
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
        c.setPhoneNo(scanner.nextInt());
        System.out.print("Enter Email ID : ");
        c.setEmail(scanner.next());
        list.add(c);
    }

    public static void main(String[] args) {
        AddressBook book=new AddressBook();
        ContactDetails c;
        int option;
        do
        {
            System.out.println("Enter your option: ");
            System.out.println("1.Add contact  ");
            option= scan.nextInt();
            c=new ContactDetails();
            Scanner sc=new Scanner(System.in);

            switch (option)
            {
                case 1:
                    book.Add_Contact(c);
                    break;
            }
            System.out.println("Do you want to continue: Enter 1.Continue or 0.Exit)");
            option= scan.nextInt();
        }
        while (option!=0);
    }
}