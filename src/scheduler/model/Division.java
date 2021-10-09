package scheduler.model;

public class Division {

    private static int division_id;
    private static String name;

    public Division(int division, String name) {
        setDivision_id(division);
        setName(name);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public static int getDivision_id() {
        return division_id;
    }

    public static void setDivision_id(int division_id) {
        Division.division_id = division_id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Division.name = name;
    }
}
