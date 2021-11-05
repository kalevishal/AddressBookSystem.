import java.io.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    static AddressBookRepo addressBookRepo = new AddressBookRepo();
    static Scanner scanner=new Scanner(System.in);
    static AddressBook addressBook=new AddressBook();
    public static void main(String[] args) throws SQLException {
        boolean exit = false;
        while (!exit) {
            System.out.println(" Press\n 1 ->  Retrieve data\n 2 -> Update data\n " +
                    "3 -> Retrieve data for particular date\n" +
                    "4 -> Retrieve Count of Contacts for City \n" +
                    "5 -> Retrieve Count of Contacts for State \n" +
                    "6 -> Add new Contacts to AddressBook\n" +
                    "7 -> exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    retrieveData();
                    break;
                case 2:
                    addressBook.updateData();
                    break;
                case 3:
                    addressBook.getContactsInDatePeriod();
                    break;
                case 4:
                    addressBook.countByCity();
                    break;
                case 5:
                    addressBook.countByState();
                    break;
                case 6:
                    addressBook.addNewContact();
                    break;
                case 7:
                    exit = true;
            }
        }
    }

    private void addNewContact() {
        Person add = new Person();
        System.out.println("Enter First Name:");
        add.setFirstName(scanner.next());
        System.out.println("Enter Last name:");
        add.setLastName(scanner.next());
        System.out.println("Enter address");
        add.setAddress(scanner.next());
        System.out.println("Enter city");
        add.setCity(scanner.next());
        System.out.println("Enter state");
        add.setState(scanner.next());
        System.out.println("Enter Zip");
        add.setZip(scanner.next());
        System.out.println("Enter PhoneNumber");
        add.setPhoneNumber(scanner.next());
        System.out.println("Enter Addressbook name");
        add.setBookName(scanner.next());
        add.setDate(LocalDate.now());
        AddressBookRepo.insertData(add);
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

    private static void retrieveData() throws SQLException {
        List<Person> employeeInfoList = addressBookRepo.retrieveData();
        System.out.println(employeeInfoList);
    }
    private void updateData() {
        addressBookRepo.updateSalary("Mona",5000);
    }

}