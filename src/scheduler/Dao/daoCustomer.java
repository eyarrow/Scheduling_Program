package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Customer;
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
     * @param customer Customer object will all components added.
     */
    public static void addCustomerDAO(Customer customer) {
        String ADD_CUSTOMER = String.format("INSERT INTO CUSTOMERS (Customer_Name, Address, Postal_Code, Phone, Division_ID)\n" +
                "VALUES ('%s', '%s', '%s', '%s', %x);", customer.getName(), customer.getAddress(), customer.getPostalCode(), customer.getPhoneNumber(), customer.getDivisionID());

    }

}



