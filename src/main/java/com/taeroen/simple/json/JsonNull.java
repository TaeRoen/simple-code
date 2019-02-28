package com.taeroen.simple.json;

import java.util.ArrayList;
import java.util.List;

import static com.taeroen.simple.json.JsonParser.*;

public class JsonNull implements JsonValue {

    public JsonNull(JsonCharStream json) {
        json.assertAndVerify(NULL);
    }

    @Override
    public String toJsonString() {
        return NULL;
    }

    @Override
    public List<String> toFormatJsonString() {
        List<String> list = new ArrayList<>();
        list.add(NULL);
        return list;
    }
}
