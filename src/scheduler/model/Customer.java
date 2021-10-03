package scheduler.model;

/**
 * A class to manage a singular customer object. Maintains the data members that are used
 * througout the program.
 *
 */
public class Customer {
    private static int CustomerID;
    private static String Name;
    private static String Address;
    private static String PostalCode;
    private static String PhoneNumber;
    private static int DivisionID;
    private static int CountryID;

    /**
     * Constructor for the Customer class
     * @param id refers to the Customer id
     * @param Address is the address string
     * @param PostalCode Postal code
     * @param phone Customer's phone number
     * @param DivID The Division ID as an integer
     * @param Country The country ID as an integer
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
     * Displays the user friendly Country name for the associated Customer
     * @return the String value for the Country code associated with the customer
     */
    public static String returnCountryString () {

        return "TBD";
    }

    /**
     * Displays the user friendly Division name for the customer
     * @return The string value for the Division ID code associated with the customer.
     */
    public static String returnDivisionIDString () {

        return "TBD";
    }

    /**
     * Get the Customer ID
     * @return an integer value for the customer ID
     */
    public static int getCustomerID() {
        return CustomerID;
    }

    /**
     * Add Customer ID for a Customer
     * @param customerID integer value
     */
    public static void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    /**
     * Get the Address for the customer.
     * @return a String for the address value. Note: The Division Id and Country ID
     * are stored is their own variables.
     */
    public static String getAddress() {
        return Address;
    }

    /**
     * Set an address for the customer.
     * @param address String for the address. Note: The Country and Division information should
     *                not be included in this String. Both have their own variables.
     */
    public static void setAddress(String address) {
        Address = address;
    }

    /**
     * Return the postal code
     * @return value is a string
     */
    public static String getPostalCode() {
        return PostalCode;
    }

    /**
     * Set the postal code
     * @param postalCode is a string that corresponds to the customer's postal code.
     */
    public static void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    /**
     * Returns the Customer's Phone number
     * @return a String that corresponds to the customer's phone number.
     */
    public static String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * Add the phone number
     * @param phoneNumber String parameter that represents a Customer's phone number.
     */
    public static void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    /**
     * Return the Division ID
     * @return Division ID in it's integer value.
     */
    public static int getDivisionID() {
        return DivisionID;
    }

    /**
     * Set the division id
     * @param divisionID is an integer that corresponds with the divisionID
     */
    public static void setDivisionID(int divisionID) {
        DivisionID = divisionID;
    }

    /**
     * Return the country ID
     * @return integer value that corresponds with the assigned integer id.
     */
    public static int getCountryID() {
        return CountryID;
    }

    /**
     * Set the country id
     * @param countryID integer value that corresponds with the Country ID value.
     */
    public static void setCountryID(int countryID) {
        CountryID = countryID;
    }

    /**
     * Get the name of the customer
     * @return string will full name
     */
    public static String getName() {
        return Name;
    }

    /**
     * Set name for the customer
     * @param name is a string that is comprised of full name
     */
    public static void setName(String name) {
        Name = name;
    }
}
