package com.silo.backend.command.infrastructure.serializer;

import java.lang.reflect.Type;
import java.util.Date;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import com.nimbusds.jose.shaded.gson.JsonDeserializationContext;
import com.nimbusds.jose.shaded.gson.JsonDeserializer;
import com.nimbusds.jose.shaded.gson.JsonElement;
import com.nimbusds.jose.shaded.gson.JsonParseException;
import com.nimbusds.jose.shaded.gson.JsonPrimitive;
import com.nimbusds.jose.shaded.gson.JsonSerializationContext;
import com.nimbusds.jose.shaded.gson.JsonSerializer;

public class AbstractSerializer {

    private Gson gson;

    protected AbstractSerializer(boolean isCompact) {
        this(false, isCompact);
    }

    protected AbstractSerializer(boolean isPretty, boolean isCompact) {
        super();

        if (isPretty && isCompact) {
            this.buildForPrettyCompact();
        } else if (isCompact) {
            this.buildForCompact();
        } else {
            this.build();
        }
    }

    protected Gson gson() {
        return this.gson;
    }

    private void build() {
        this.gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer()).serializeNulls().create();
    }

    private void buildForCompact() {
        this.gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();
    }

    private void buildForPrettyCompact() {
        this.gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer()).setPrettyPrinting().create();
    }

    private class DateSerializer implements JsonSerializer<Date> {
        public JsonElement serialize(Date source, Type typeOfSource, JsonSerializationContext context) {
            return new JsonPrimitive(Long.toString(source.getTime()));
        }
    }

    private class DateDeserializer implements JsonDeserializer<Date> {
        public Date deserialize(JsonElement json, Type typeOfTarget, JsonDeserializationContext context) throws JsonParseException {
            long time = Long.parseLong(json.getAsJsonPrimitive().getAsString());
            return new Date(time);
        }
    }
}
