package scheduler.model;

public class Division {

    private int division_id;
    private String name;

    public Division(int division, String name) {
        setDivision_id(division);
        setName(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
