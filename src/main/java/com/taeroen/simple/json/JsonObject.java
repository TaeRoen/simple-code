package com.taeroen.simple.json;

import com.taeroen.simple.json.exception.InvalidCharException;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.taeroen.simple.json.JsonParser.*;

public class JsonObject implements JsonValue {



    private LinkedHashMap<JsonString, JsonValue> map;

    public JsonObject(JsonCharStream json) {
        this.map = new LinkedHashMap<>();

        // {
        if (!json.assertAndVerify(LEFT_BRACE)) {
            throw new InvalidCharException();
        }

        do {

            // key(string)
            json.skipUnless();
            JsonString jsonKey = new JsonString(json);

            // :
            json.skipUnless();
            if (!json.assertAndVerify(COLON)) {
                throw new InvalidCharException();
            }

            // value
            JsonValue jsonValue = JsonParser.buildJsonValue(json);

            map.put(jsonKey, jsonValue);

        } while (json.assertAndVerify(COMMA));

        // }
        json.skipUnless();
        if (!json.assertAndVerify(RIGHT_BRACE)) {
            throw new InvalidCharException();
        }

    }

    @Override
    public String toString() {
        return this.toJsonString();
    }

    @Override
    public String toJsonString() {
        StringBuffer sb = new StringBuffer();
        sb.append(LEFT_BRACE);
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<JsonString, JsonValue> entry = (Map.Entry) iterator.next();
            sb.append(entry.getKey().toJsonString());
            sb.append(COLON);
            sb.append(entry.getValue().toJsonString());
            if(iterator.hasNext()){
                sb.append(COMMA);
            }
        }
        sb.append(RIGHT_BRACE);
        return sb.toString();
    }

    @Override
    public List<String> toFormatJsonString() {
        return null;
    }
}
