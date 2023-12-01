package IO.java.org;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Data {
    ArrayList<Car> carList;

    public Data() {
        carList = new ArrayList<>();
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public Vector<String> getCarListVector() {
        Vector<String> carVector = new Vector<>();
        for (Car car : carList) {
            carVector.add(car.getMake() + " " + car.getType());
        }
        return carVector;
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public void deleteCar(Car car) {
        carList.remove(car);
    }

    public Car getCarByName(String name) {
        for (Car car : carList) {
            if ((car.getMake() + " " + car.getType()).equals(name)) {
                return car;
            }
        }
        return null;
    }
}