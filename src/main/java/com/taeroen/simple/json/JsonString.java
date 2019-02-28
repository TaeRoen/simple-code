package com.taeroen.simple.json;

import com.taeroen.simple.json.exception.InvalidCharException;

import java.util.ArrayList;
import java.util.List;

public class JsonString implements JsonValue {
    private String value;


    public JsonString(JsonCharStream json) {
        if (!json.assertAndVerify(JsonParser.DOUBLE_QUOTES)) {
            throw new InvalidCharException();
        }
        value = "";
        while (!json.assertAndVerify(JsonParser.DOUBLE_QUOTES)) {
            value += json.assertNotAndVerify();
        }
    }

    @Override
    public String toJsonString() {
        return '\"' + value + '\"';
    }

    @Override
    public List<String> toFormatJsonString() {
        List<String> list = new ArrayList<>();
        list.add(this.toJsonString());
        return list;
    }
}
