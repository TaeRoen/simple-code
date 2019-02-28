package com.taeroen.simple.json;

import java.util.ArrayList;
import java.util.List;

import static com.taeroen.simple.json.JsonParser.*;

public class JsonBoolean implements JsonValue {

    private boolean value;

    public JsonBoolean(JsonCharStream json, boolean bool) {
        if (bool) {
            json.assertAndVerify(TRUE);
            value = true;
        } else {
            json.assertAndVerify(FALSE);
            value = false;
        }
    }

    @Override
    public String toJsonString() {
        if (value) {
            return TRUE;
        } else {
            return FALSE;
        }
    }

    @Override
    public List<String> toFormatJsonString() {
        List<String> list = new ArrayList<>();
        if (value) {
            list.add(TRUE);
        } else {
            list.add(FALSE);
        }
        return list;
    }
}
