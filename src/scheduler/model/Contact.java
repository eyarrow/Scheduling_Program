package scheduler.model;

/**
 * Class to manage a contact object
 */
public class Contact {
    int ContactID;
    String ContactName;

    @Override
    public String toString() {
        return this.getContactName();
    }

    public Contact(int contactID, String contactName) {
        ContactID = contactID;
        ContactName = contactName;
    }

    public int getContactID() {
        return ContactID;
    }

    public void setContactID(int contactID) {
        ContactID = contactID;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }
}
