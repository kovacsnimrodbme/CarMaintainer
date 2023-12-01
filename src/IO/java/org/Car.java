package IO.java.org;

import java.util.ArrayList;

/**
 * This class represents a car.
 */
public class Car {
    /**
     * The maker of the car.
     */
    private final String make;
    /**
     * The type of the car.
     */
    private final String type;
    /**
     * The VIN number of the car.
     */
    private final String vin;
    /**
     * A list with the services made at the specific car.
     */
    private final ArrayList<Service> services;

    /**
     * A default constructor for the class.
     */
    public Car() {
        this.make = "def";
        this.type = "def";
        this.vin = "def";
        this.services = new ArrayList<>();
    }

    /**
     * A constructor for the class.
     *
     * @param make The maker of the car.
     * @param type The type of the car.
     * @param vin  The VIN number of the car.
     */
    public Car(String make, String type, String vin) {
        this.make = make;
        this.type = type;
        this.vin = vin;
        this.services = new ArrayList<>();
    }

    /**
     * A getter for the make field.
     *
     * @return The field make.
     */
    public String getMake() {
        return make;
    }

    /**
     * A getter for the type.
     *
     * @return The field type.
     */
    public String getType() {
        return type;
    }

    /**
     * A getter for the VIN.
     *
     * @return The field vin.
     */
    public String getVin() {
        return vin;
    }

    /**
     * A getter for the services.
     *
     * @return The list services.
     */
    public ArrayList<Service> getServices() {
        return services;
    }

    /**
     * A function to add a new service.
     *
     * @param newService The service needs to be added to the list.
     */
    public void addService(Service newService) {
        getServices().add(newService);
    }
}
