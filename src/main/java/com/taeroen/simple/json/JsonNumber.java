package com.taeroen.simple.json;

import java.util.List;

public class JsonNumber implements JsonValue {
    private boolean interger;
    private int intValue;
    private double doubleValue;

    @Override
    public String toJsonString() {
        if (interger) {
            return "" + intValue;
        } else {
            return "" + doubleValue;
        }
    }

    @Override
    public List<String> toFormatJsonString() {
        return null;
    }

    public JsonNumber(JsonCharStream json) {
        String valueString = new String(json.fetchBeforeAndVerify(JsonParser.COMMA));
        if (valueString.contains(JsonParser.DOT + "")) {
            doubleValue = Double.valueOf(valueString);
        } else {
            interger = true;
            intValue = Integer.valueOf(valueString);
        }
    }
}
