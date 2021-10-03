package scheduler.Dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import scheduler.model.Customer;

/**
 * Class that provides functionality on the persistence layer for the "Customer" class that manages business local in the model package.
 *
 */
public abstract class daoCustomer {

    public static ObservableList<Customer> getAllCustomers() {
        ObservableList<Customer> cList = FXCollections.observableArrayList();


        return cList;
    }

}
