package IO.java.org;

import java.util.ArrayList;

public class Car {
    private final String make;
    private final String type;
    private final String engCode;
    private final String vin;
    private ArrayList<Service> services;

    Car(String make, String type, String engCode, String vin) {
        this.make = make;
        this.type = type;
        this.engCode = engCode;
        this.vin = vin;
    }

    public ArrayList<Service> getServices(){
        return services;
    }

    public void addService(Service newService){
        getServices().add(newService);
    }
}
