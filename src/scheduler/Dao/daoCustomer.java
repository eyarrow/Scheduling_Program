package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Country;
import scheduler.model.Customer;
import scheduler.model.Division;
import scheduler.util.dbOperations;

import java.sql.ResultSet;
import java.sql.SQLException;

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
                "VALUES ('%s', '%s', '%s', '%s', %x);", customer.getName(), customer.getAddress(), customer.getPostalCode(), customer.getPhoneNumber(), customer.getDivisionID());
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
        String DELETE_CUSTOMER = String.format("DELETE FROM customers where customer_id = '%x'", C.getCustomerID());
        dbOperations.dbUpdate(DELETE_CUSTOMER);
        return true;

    }



}



