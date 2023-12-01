package IO.java.org;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A class, to store service information about cars.
 */
public class Service {
    /**
     * A date, when the service happened.
     */
    private final LocalDate date;
    /**
     * The price of the service.
     */
    private final int price;
    /**
     * A list of parts that were installed during the service.
     */
    private final ArrayList<String> parts;
    /**
     * A list of optional information about the parts.
     */
    private final ArrayList<String> partNums;

    /**
     * A constructor for the class.
     *
     * @param date     date field.
     * @param price    price field.
     * @param parts    parts field.
     * @param partNums partNums field.
     */
    public Service(LocalDate date, int price, ArrayList<String> parts, ArrayList<String> partNums) {
        this.date = date;
        this.price = price;
        this.parts = parts;
        this.partNums = partNums;
    }

    /**
     * A function, that returns one part and information pair in a string array.
     *
     * @param i The index of the desired part.
     * @return An array with a part and information about the part.
     */
    public String[] getPartsByRow(int i) {
        return new String[]{parts.get(i), partNums.get(i)};
    }

    /**
     * A getter for the quantity of the parts.
     *
     * @return The number of parts.
     */
    public int getPartSize() {
        return parts.size();
    }

    /**
     * A getter for the date field.
     *
     * @return The date field.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * A getter for the price field.
     *
     * @return The price field.
     */
    public int getPrice() {
        return price;
    }
}
