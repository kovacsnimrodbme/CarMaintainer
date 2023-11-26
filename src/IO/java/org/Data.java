package IO.java.org;

import java.io.*;
import java.util.ArrayList;

public class Data {
    ArrayList<Car> carList;

    public Data() {
        carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carList.add(car);
        try{
        FileIO.save(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void deleteCar(Car car) {
        carList.remove(car);
        try{
            FileIO.save(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}