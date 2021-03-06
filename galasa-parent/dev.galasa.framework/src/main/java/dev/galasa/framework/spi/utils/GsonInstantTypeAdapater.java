/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.framework.spi.utils;

import java.io.IOException;
import java.time.Instant;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GsonInstantTypeAdapater extends TypeAdapter<Instant> {

    @Override
    public void write(JsonWriter out, Instant value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }

        out.value(value.toString());
    }

    @Override
    public Instant read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }

        return Instant.parse(in.nextString());
    }

}
