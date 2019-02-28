package com.taeroen.simple.json;

import com.taeroen.simple.json.exception.InvalidCharException;

public class JsonParser {

    public static char LEFT_BRACE = '{';
    public static char RIGHT_BRACE = '}';
    public static char LEFT_BRACKET = '[';
    public static char RIGHT_BRACKET = ']';
    public static char DOUBLE_QUOTES = '"';
    public static char COLON = ':';
    public static char COMMA = ',';
    public static char MINUS = '-';
    public static char DOT = '.';
    public static char ZERO = '0';
    public static char[] DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static String TRUE = "true";
    public static String FALSE = "false";
    public static String NULL = "null";

    public static JsonValue buildJsonValue(JsonCharStream json) {
        json.skipUnless();
        if (json.assertBeginWith(LEFT_BRACE)) {
            return new JsonObject(json);
        }
        if (json.assertBeginWith(LEFT_BRACKET)) {
            return new JsonArray(json);
        }
        if (json.assertBeginWith(DOUBLE_QUOTES)) {
            return new JsonString(json);
        }
        if (json.assertBeginWith(MINUS)) {
            return new JsonNumber(json);
        }
        if (json.assertBeginWith(ZERO)) {
            return new JsonNumber(json);
        }
        if (json.assertBeginIn(DIGIT)) {
            return new JsonNumber(json);
        }
        if (json.assertBeginWith(TRUE)) {
            return new JsonBoolean(json,true);
        }
        if (json.assertBeginWith(FALSE)) {
            return new JsonBoolean(json,false);
        }
        if (json.assertBeginWith(NULL)) {
            return new JsonNull(json);
        }
        throw new InvalidCharException(json);
    }

    public static JsonObject parse(String json) {
        JsonCharStream jsonCharStream = new JsonCharStream(json);
        JsonObject jsonObject = new JsonObject(jsonCharStream);
        if (!jsonCharStream.isEnd()) {
            throw new InvalidCharException();
        }
        return jsonObject;
    }
}
