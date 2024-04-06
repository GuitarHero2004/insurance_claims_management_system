package com.guitarhero2004.icms.lib.adapter;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * Class representing a custom adapter for LocalDateTime objects.
 * Extends the TypeAdapter class from the Gson library.
 * This class is used to customize the serialization and deserialization of LocalDateTime objects.
 */
public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

    /**
     * The DateTimeFormatter used to format LocalDateTime objects.
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");

    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for the corresponding LocalDateTime object.
     * @param writer The JsonWriter to write with.
     * @param value The LocalDateTime object to write.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void write(JsonWriter writer, LocalDateTime value) throws IOException {
        if (value == null) {
            writer.nullValue();
            return;
        }
        writer.value(formatter.format(value));
    }

    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it into a LocalDateTime object.
     * @param reader The JsonReader to read with.
     * @return The read LocalDateTime object.
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public LocalDateTime read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        String date = reader.nextString();
        return LocalDateTime.parse(date, formatter);
    }

}