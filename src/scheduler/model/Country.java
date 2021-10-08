package scheduler.model;

public class Country {
    private int Country_id;
    private String name;

    public Country(int country_id, String name) {
        setCountry_id(country_id);
        setName(name);
    }

    public int getCountry_id() {
        return Country_id;
    }

    public void setCountry_id(int country_id) {
        this.Country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
