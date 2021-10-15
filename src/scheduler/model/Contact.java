package scheduler.model;

/**
 * Class to manage a contact object
 */
public class Contact {
    //Data Members
    int ContactID;
    String ContactName;


    /**
     * Overrides the .toString() function, so that a String representation of the object can be returned
     * to the UI
     * @return The name of the contact as a String
     */
    @Override
    public String toString() {
        return this.getContactName();
    }

    /**
     * Constructor for a contact
     * @param contactID Integer, contact id
     * @param contactName String, Contact name
     */
    public Contact(int contactID, String contactName) {
        ContactID = contactID;
        ContactName = contactName;
    }

    /**
     * Return Contact ID
     * @return Integer, contact id
     */
    public int getContactID() {
        return ContactID;
    }

    /**
     * Set contact id
     * @param contactID Integer, contact id
     */
    public void setContactID(int contactID) {
        ContactID = contactID;
    }

    /**
     * Return Contact Name
     * @return String, Contact Name
     */
    public String getContactName() {
        return ContactName;
    }

    /**
     * Set the contact name
     * @param contactName String, contact name
     */
    public void setContactName(String contactName) {
        ContactName = contactName;
    }
}
