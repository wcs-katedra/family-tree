package familytree.time;

public class TimeMachine {

    private static final int DEFAULT_YEAR = 1995;
    private static int currentYear = DEFAULT_YEAR;

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int year) {
        currentYear = year;
    }
}
