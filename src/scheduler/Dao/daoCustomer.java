package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Country;
import scheduler.model.Customer;
import scheduler.model.Division;
import scheduler.util.dbOperations;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import java.util.LinkedList;

/**
 * Class that provides functionality on the persistence layer for the "Customer" class that manages business local in the model package.
 *
 */
public abstract class daoCustomer {


    /**
     * Get's all needed values for the customer object, and provides an Observable list for use by
     * the application.
     *
     * @return An Observable Array List of All Customers.
     * @throws SQLException if an error occurs.
     */
    public static ObservableList<Customer> getAllCustomersDAO() throws SQLException {
        ObservableList<Customer> cList = FXCollections.observableArrayList();
        String ALL_CUSTOMER = "SELECT c.Customer_ID, c.Customer_Name, c.Address, c.Postal_Code, c.Phone, d.Division_ID, r.Country_ID FROM CUSTOMERS c INNER JOIN first_level_divisions d ON c.Division_ID = d.Division_ID INNER JOIN countries r ON d.Country_ID = r.Country_ID";

        ResultSet rs = dbOperations.dbQuery(ALL_CUSTOMER);

        try {
            while (rs.next()) {
                int CustID = rs.getInt("Customer_ID");
                String name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String postal = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int div = rs.getInt("Division_ID");
                int country = rs.getInt("Country_ID");

                Customer c = new Customer(CustID, name, address, postal, phone, div, country);
                cList.add(c);

            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return cList;


    }

    /**
     * Adds a customer to the DB. It is assumed all error checking has already been made against
     * business logic.
     *
     * @param customer Customer object will all components added.
     */
    public static void addCustomerDAO(Customer customer) {
        String ADD_CUSTOMER = String.format("INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Division_ID)\n" +
                "VALUES ('%s', '%s', '%s', '%s', %s);", customer.getName(), customer.getAddress(), customer.getPostalCode(), customer.getPhoneNumber(), customer.getDivisionID());
        System.out.println("Update add customer statement is: " + ADD_CUSTOMER);
        dbOperations.dbUpdate(ADD_CUSTOMER);
    }

    /**
     * Gets a current list of all countries from the database
     * @return an Observable list of countries
     */
    public static ObservableList<Country> getAllcountriesDAO() {
        ObservableList<Country> cList = FXCollections.observableArrayList();
        String allCountries = "SELECT Country_ID, Country FROM countries;";
        ResultSet rs;
        try {
            rs = dbOperations.dbQuery(allCountries);
            while (rs.next()) {
                int country_id = rs.getInt("Country_ID");
                String name = rs.getString("Country");
                Country C = new Country(country_id, name);
                cList.add(C);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cList;
    }

    /**
     * Given a country_id returns the Country object
     * @param Country_ID Integer, country id
     * @return Country object associated with the given id
     */
    public static Country getCountryDAO(int Country_ID) {
        String COUNTRY = String.format("SELECT Country_ID, Country FROM countries WHERE Country_ID = '%x';", Country_ID);
        ResultSet rs;
        Country country = new Country(0, "NULL");


        try {
            rs = dbOperations.dbQuery(COUNTRY);
            while(rs.next()) {
                int country_id = rs.getInt("Country_ID");
                String name = rs.getString("Country");
                Country C = new Country(country_id, name);
                return C;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return country;
    }

    /**
     * Given a division ID value, returns a division object
     * @param division_id id number
     * @return division object
     */
    public static Division getDivisionDAO(int division_id) {
        String DIVISION = String.format("select Division_ID, Division from first_level_divisions WHERE Division_ID = %s;", division_id);
        ResultSet rs;
        Division D = new Division(0, "NULL");

        try {
            rs = dbOperations.dbQuery(DIVISION);
            if(rs.next()) {
                int id = rs.getInt("Division_ID");
                String name = rs.getString("Division");
                D.setName(name);
                D.setDivision_id(id);
                return D;


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return D;
    }

    /**
     * Returns an list of Division ID's for the given Country ID
     * @param country_id of the country for which you would like to obtain division id's
     * @return an Observable list of Division ID's.
     */
    public static ObservableList<Division> getDivisionDAO (Country country_id) {
        ObservableList<Division> cList = FXCollections.observableArrayList();
        String Division = String.format("select Division_ID, Division from first_level_divisions WHERE Country_ID = %x;", country_id.getCountry_id());
        ResultSet rs;

        try {
            rs = dbOperations.dbQuery(Division);
            while(rs.next()) {
                int id = rs.getInt("Division_ID");
                String name = rs.getString("Division");
                Division D = new Division(id, name);
                cList.add(D);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cList;
    }

    /**
     * Deletes the given customer
     * @param C is a customer object
     * @return true after the operation is completed.
     */
    public static boolean deleteCustomerDAO(Customer C) {
        String DELETE_CUSTOMER = String.format("DELETE FROM customers where Customer_ID = %s", C.getCustomerID());
        dbOperations.dbUpdate(DELETE_CUSTOMER);
        return true;

    }

    /**
     * Updates a Customer's information in the Database.
     * @param C Customer object record.
     */
    public static void updateCustomerDAO(Customer C) {
        String UPDATE_CUSTOMER = null;
        try {
            UPDATE_CUSTOMER = String.format("UPDATE Customers\n" +
                    "SET Customer_Name = '%s', Address = '%s', Postal_Code = '%s', Phone = '%s', Division_ID = %s\n" +
                    "WHERE Customer_ID = %s;", C.getName(), C.getAddress(), C.getPostalCode(), C.getPhoneNumber(), C.getDivisionID(), C.getCustomerID());
        }
        catch (IllegalFormatException e) {
            e.printStackTrace();
        }

        System.out.println("Generated sql string: " + UPDATE_CUSTOMER);

        dbOperations.dbUpdate(UPDATE_CUSTOMER);
    }

    /**
     * Returns the Name of a customer given a customer id
     * @param CustID Integer, Customer ID
     * @return String, customer name
     */
    public static String returnCustomerNameDAO(int CustID) {
        String getCustomer = String.format("select Customer_Name from customers where Customer_ID = %s", CustID);
        ResultSet rs;
        String name = "NULL";

        try {
            rs = dbOperations.dbQuery(getCustomer);
            while(rs.next()) {
                name = rs.getString("Customer_Name");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return name;
    }

    /**
     * Given a customer id returns a customer object
     * @param id Integer, customer id
     * @return Customer object
     */
    public static Customer returnCustomerDAO(int id) {
        String getCustomer = String.format("SELECT c.Customer_ID, c.Customer_Name, c.Address, c.Postal_Code, c.Phone, d.Division_ID, r.Country_ID FROM CUSTOMERS c INNER JOIN first_level_divisions d ON c.Division_ID = d.Division_ID INNER JOIN countries r ON d.Country_ID = r.Country_ID WHERE Customer_ID = %s;", id);
        ResultSet rs;
        Customer C = new Customer(0, "NULL", "NULL", "NULL", "NULL", 0, 0);

        try {
            rs = dbOperations.dbQuery(getCustomer);
            while(rs.next()) {
                int CustID = id;
                String name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String postal = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int div = rs.getInt("Division_ID");
                int country = rs.getInt("Country_ID");

                Customer query = new Customer(CustID, name, address, postal, phone, div, country);
                return query;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return C;
    }






}



