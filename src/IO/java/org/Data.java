package IO.java.org;

import java.util.ArrayList;
import java.util.Vector;

/**
 * A class to store multiple cars.
 */
public class Data {
    /**
     * A list with cars in it.
     */
    ArrayList<Car> carList;

    /**
     * A default constructor.
     */
    public Data() {
        carList = new ArrayList<>();
    }

    /**
     * A getter for the carList field.
     *
     * @return The carList field.
     */
    public ArrayList<Car> getCarList() {
        return carList;
    }

    /**
     * A function, that makes a Vector for the JComboBoxes.
     *
     * @return The cars in a Vector.
     */
    public Vector<String> getCarListVector() {
        Vector<String> carVector = new Vector<>();
        for (Car car : carList) {
            carVector.add(car.getMake() + " " + car.getType());
        }
        return carVector;
    }

    /**
     * A function to add a new car.
     *
     * @param car The car needs to be added.
     */
    public void addCar(Car car) {
        carList.add(car);
    }

    /**
     * A function to delete an existing car.
     *
     * @param car The car needs to be deleted.
     */
    public void deleteCar(Car car) {
        carList.remove(car);
    }

    /**
     * A function to get a car by its name.
     *
     * @param name The name of the car.
     * @return The desired car object.
     */
    public Car getCarByName(String name) {
        for (Car car : carList) {
            if ((car.getMake() + " " + car.getType()).equals(name)) {
                return car;
            }
        }
        return null;
    }
}