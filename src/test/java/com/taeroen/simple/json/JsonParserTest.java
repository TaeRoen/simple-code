package com.taeroen.simple.json;

import org.junit.Test;

public class JsonParserTest {

    @Test
    public void parse() {
        String json = "{\n" +
                "  \"_id\": \"5c6635d4fec3f61009808dd9\",\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"example\",\n" +
                "  \"s\": null,\n" +
                "  \"c\": false,\n" +
                "  \"born\": {\n" +
                "    \"data\": \"1990\"\n" +
                "  }\n" +
                "}";
        JsonObject jsonObject = JsonParser.parse(json);
        System.out.println(jsonObject.toString());
    }
}