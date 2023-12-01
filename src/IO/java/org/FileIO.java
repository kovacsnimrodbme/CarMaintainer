package IO.java.org;

import com.google.gson.*;

import java.io.*;
import java.time.LocalDate;

public class FileIO {
    public static Data load() throws FileNotFoundException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        BufferedReader reader = new BufferedReader(new FileReader("cars.json"));
        return gson.fromJson(reader, Data.class);
    }

    public static void save(Data cars) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        FileWriter writer = new FileWriter("cars.json");
        writer.write(gson.toJson(cars));
        writer.close();
    }
}
