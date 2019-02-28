package com.taeroen.simple.json;

import java.util.List;

public interface JsonValue {
    public String toJsonString();

    public List<String> toFormatJsonString();
}
