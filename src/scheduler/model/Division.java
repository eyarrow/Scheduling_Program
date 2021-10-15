package scheduler.model;

/**
 * Class to manage the division object
 */
public class Division {
    //Data members
    private int division_id;
    private String name;

    /**
     * Class constructor
     * @param division Integer, id
     * @param name String, name of divison
     */
    public Division(int division, String name) {
        setDivision_id(division);
        setName(name);
    }

    /**
     * Overrides .toString() so that a human readable Division name is returned in lieu of Object information
     *
     * @return String, name of division
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Return the division Id
     * @return Integer, division id
     */
    public int getDivision_id() {
        return division_id;
    }

    /**
     * Set the division id
     * @param division_id Integer, Division id
     */
    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    /**
     * Return the division name
     * @return String, division name
     */
    public String getName() {
        return name;
    }

    /**
     * Set division name
     * @param name String division name
     */
    public void setName(String name) {
        this.name = name;
    }
}
