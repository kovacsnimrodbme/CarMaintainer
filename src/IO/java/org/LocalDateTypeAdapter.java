package IO.java.org;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This is a type adapter class for GSON, to serialize java.time.LocalDate fields.
 * It's not my intellectual product, for more info visit:
 * <a href="https://howtodoinjava.com/gson/gson-typeadapter-for-inaccessibleobjectexception/">LINKł</a>
 */
public class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    /**
     *
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * The type adapter for serialization.
     *
     * @param date      the object that needs to be converted to Json.
     * @param typeOfSrc the actual type (fully generalized version) of the source object.
     * @param context   I don't know.
     * @return A serialized LocalDate.
     */
    @Override
    public JsonElement serialize(final LocalDate date, final Type typeOfSrc,
                                 final JsonSerializationContext context) {
        return new JsonPrimitive(date.format(formatter));
    }

    /**
     * The type adapter for deserialization.
     *
     * @param json    The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @param context I don't know.
     * @return The deserialized LocalDate.
     * @throws JsonParseException I think, when something goes wrong in the process.
     */
    @Override
    public LocalDate deserialize(final JsonElement json, final Type typeOfT,
                                 final JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), formatter);
    }
}