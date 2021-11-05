package com.bl.addressbook;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressBookRepo {
    static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/AddressBookDB";
        String username = "root";
        String password = "9021";
        Connection connection = null;
        try {
            //Loading and registering driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public List<Person> retrieveData() {
        ResultSet resultSet = null;
        List<Person> employeeInfoList = new ArrayList<>(

        );
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from addressBook;";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                Person employeeInfo = new Person();
                employeeInfo.setFirstName(resultSet.getString("firstName"));
                employeeInfo.setLastName(resultSet.getString("LastName"));
                employeeInfo.setAddress(resultSet.getString("address"));
                employeeInfo.setCity(resultSet.getString("city"));
                employeeInfo.setZip(resultSet.getString("zip"));
                employeeInfo.setPhoneNumber(resultSet.getString("phoneNumber"));
                employeeInfo.setDate(resultSet.getDate("Date_added").toLocalDate());

                employeeInfoList.add(employeeInfo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }
    public static void updateSalary(String fName, int zip) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "update addressBook set zip=" + zip + " where firstName=" + fName + "";
            int result = statement.executeUpdate(query);
            if (result == 1)
                System.out.println("salary updated");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void getContactsInDatePeriod() throws SQLException {

        Connection con = getConnection();
        if (con != null) {
            String retrieveQuery = "select * from addressBook where date between cast(' \" + date + \"'\" + \" as date)  and date(now());";
            Statement statement = (Statement) con.createStatement();
            ResultSet resultSet = statement.executeQuery(retrieveQuery);
            displayResultSet(resultSet);
        }
    }

    public void displayResultSet(ResultSet resultSet) throws SQLException {

        System.out.println("\nContact retrieved..");
        while (resultSet.next()) {

            int addressBookId = resultSet.getInt("id");
            String addressBookName = resultSet.getString("address_book");
            int personId = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            int phoneNo = resultSet.getInt("phoneNumber");
            String email = resultSet.getString("email");
            int zip = resultSet.getInt("zip");
            String date = resultSet.getDate("date").toString();

            String rowData = String.format(
                    "\nAddressBook Id : %d \nAddressBook Name : %s \nPerson Id : %d \nFirst Name : %s  \nLast Name : %s \nAddress : %s \nCity : %s \nState : %s \nPhone Number : %s \nE-mail : %s \nZip : %d \nDate : %s",
                    addressBookId, addressBookName, personId, firstName, lastName, address, city, state, phoneNo, email,
                    zip, date);
            System.out.println(rowData + " \n ");
        }
    }
    public int countByCity(String city) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select count(firstname) from AddressBook where city=" + "'" + city + "';";
            ResultSet result = statement.executeQuery(sql);
            result.next();
            int count = result.getInt(1);


            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int countByState(String state) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select count(firstname) from AddressBook where city=" + "'" + state + "';";
            ResultSet result = statement.executeQuery(sql);
            result.next();
            int count = result.getInt(1);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}