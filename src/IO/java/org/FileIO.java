package IO.java.org;

import com.google.gson.*;

import java.io.*;
import java.time.LocalDate;

/**
 * This class is responsible for the serialization of the data.
 */
public class FileIO {
    /**
     * Function, to load the data from a .json file.
     *
     * @return The deserialized data.
     * @throws FileNotFoundException When the datafile not found.
     */
    public static Data load() throws FileNotFoundException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        BufferedReader reader = new BufferedReader(new FileReader("cars.json"));
        return gson.fromJson(reader, Data.class);
    }

    /**
     * Function, to save the data.
     *
     * @param cars The data to save.
     * @throws IOException When it can't write the file.
     */
    public static void save(Data cars) throws IOException {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
        FileWriter writer = new FileWriter("cars.json");
        writer.write(gson.toJson(cars));
        writer.close();
    }
}
