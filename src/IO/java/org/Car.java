package IO.java.org;

import java.util.ArrayList;

public class Car {
    private final String make;
    private final String type;
    private final String vin;
    private final ArrayList<Service> services;

    public Car() {
        this.make = "def";
        this.type = "def";
        this.vin = "def";
        this.services = new ArrayList<>();
    }

    public Car(String make, String type, String vin) {
        this.make = make;
        this.type = type;
        this.vin = vin;
        this.services = new ArrayList<>();
    }

    public String getMake() {
        return make;
    }

    public String getType() {
        return type;
    }

    public String getVin() {
        return vin;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public void addService(Service newService) {
        getServices().add(newService);
    }
}
