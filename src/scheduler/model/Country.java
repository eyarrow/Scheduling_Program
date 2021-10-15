package scheduler.model;

/**
 * Class to manage a Country Object
 */
public class Country {
    //Data members
    private int Country_id;
    private String name;

    //Constructor
    public Country(int country_id, String name) {
        setCountry_id(country_id);
        setName(name);
    }

    /**
     * Overrides the .toString() function, so that a human readable name of the country is returned
     * to the user
     * @return String, Country name
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Return the Country ID
     * @return Integer, Country id
     */
    public int getCountry_id() {
        return Country_id;
    }

    /**
     * Set the Country ID
     * @param country_id Integer, country id
     */
    public void setCountry_id(int country_id) {
        this.Country_id = country_id;
    }

    /**
     * Get the country name
     * @return String, name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the country name
     * @param name String, name
     */
    public void setName(String name) {
        this.name = name;
    }






}
