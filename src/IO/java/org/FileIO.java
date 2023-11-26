package IO.java.org;
import com.google.gson.*;

import java.io.*;

public class FileIO {
    public static Data load() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader reader = new BufferedReader(new FileReader("cars.json"));
        return gson.fromJson(reader, Data.class);
    }

    public static void save(Data cars) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("cars.json");
        writer.write(gson.toJson(cars));
        writer.close();
    }
}
