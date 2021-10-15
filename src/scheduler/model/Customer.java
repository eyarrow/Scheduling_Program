package scheduler.model;

/**
 * A class to manage a singular customer object. Maintains the data members that are used
 * throughout the program.
 *
 */
public class Customer {
    //Data members
    private int CustomerID;
    private String Name ;
    private String Address;
    private String PostalCode;
    private String PhoneNumber;
    private int DivisionID;
    private int CountryID;

    /**
     * Constructor for the Customer class (Default)
     * @param id Integer, refers to the Customer id
     * @param Address String, is the address string
     * @param PostalCode String, Postal code
     * @param phone String, Customer's phone number
     * @param DivID Integer, The Division ID
     * @param Country Integer, The country ID
     */
    public Customer(int id, String Name, String Address, String PostalCode, String phone, int DivID, int Country) {
        setCustomerID(id);
        setName(Name);
        setAddress(Address);
        setPostalCode(PostalCode);
        setPhoneNumber(phone);
        setDivisionID(DivID);
        setCountryID(Country);
    }

    /**
     * Overloaded constructor for adding a new customer. This is currently used in the scenario
     * where the customer id has yet to be assigned.
     * @param Name String, full name of customer
     * @param Address String, Primary address line
     * @param PostalCode String, Postal code
     * @param phone String, phone number
     * @param DivID int, value represents the division id
     * @param Country int, value represents the country id
     */
    public Customer(String Name, String Address, String PostalCode, String phone, int DivID, int Country) {
        setName(Name);
        setAddress(Address);
        setPostalCode(PostalCode);
        setPhoneNumber(phone);
        setDivisionID(DivID);
        setCountryID(Country);
    }

    /**
     * Overrides .toString() so that Customer name is used to represent the Object in human readalbe form.
     * @return String, Customer name
     */
    @Override
    public String toString() {
        return this.getName();
    }



    /**
     * Get the Customer ID
     * @return an integer value for the customer ID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * Add Customer ID for a Customer
     * @param customerID integer value
     */
    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    /**
     * Get the Address for the customer.
     * @return a String for the address value. Note: The Division Id and Country ID
     * are stored is their own variables.
     */
    public String getAddress() {
        return Address;
    }


    /**
     * Set an address for the customer.
     * @param address String for the address. Note: The Country and Division information should
     *                not be included in this String. Both have their own variables.
     */
    public void setAddress(String address) {
        Address = address;
    }


    /**
     * Return the postal code
     * @return value is a string
     */
    public String getPostalCode() {
        return PostalCode;
    }


    /**
     * Set the postal code
     * @param postalCode is a string that corresponds to the customer's postal code.
     */
    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }


    /**
     * Returns the Customer's Phone number
     * @return a String that corresponds to the customer's phone number.
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }


    /**
     * Add the phone number
     * @param phoneNumber String parameter that represents a Customer's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    /**
     * Return the Division ID
     * @return Division ID in it's integer value.
     */
    public int getDivisionID() {
        return DivisionID;
    }


    /**
     * Set the division id
     * @param divisionID is an integer that corresponds with the divisionID
     */
    public void setDivisionID(int divisionID) {
        DivisionID = divisionID;
    }


    /**
     * Return the country ID
     * @return integer value that corresponds with the assigned integer id.
     */
    public int getCountryID() {
        return CountryID;
    }


    /**
     * Set the country id
     * @param countryID integer value that corresponds with the Country ID value.
     */
    public void setCountryID(int countryID) {
        CountryID = countryID;
    }


    /**
     * Get the name of the customer
     * @return string will full name
     */
    public String getName() {
        return Name;
    }


    /**
     * Set name for the customer
     * @param name is a string that is comprised of full name
     */
    public void setName(String name) {
        Name = name;
    }
}
