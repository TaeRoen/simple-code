package com.taeroen.simple.json;

import com.taeroen.simple.json.exception.InvalidCharException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.taeroen.simple.json.JsonParser.*;

public class JsonArray implements JsonValue {
    private List<JsonValue> list;

    public JsonArray(JsonCharStream json) {
        list = new ArrayList<>();
        if (!json.assertAndVerify(LEFT_BRACKET)) {
            throw new InvalidCharException(json);
        }
        do {
            JsonValue value = JsonParser.buildJsonValue(json);
            list.add(value);
        } while (json.assertAndVerify(COMMA));
        if (!json.assertAndVerify(RIGHT_BRACKET)) {
            throw new InvalidCharException(json);
        }
    }

    @Override
    public String toJsonString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LEFT_BRACKET);
        Iterator<JsonValue> iterator = list.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next().toJsonString());
            if (iterator.hasNext()){
                stringBuilder.append(COMMA);
            }
        }
        stringBuilder.append(RIGHT_BRACKET);
        return stringBuilder.toString();
    }

    @Override
    public List<String> toFormatJsonString() {
        return null;
    }
}
