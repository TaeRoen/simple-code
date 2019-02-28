package com.taeroen.simple.json.exception;

import com.taeroen.simple.json.JsonCharStream;

public class InvalidCharException extends RuntimeException {

    public InvalidCharException() {
    }

    public InvalidCharException(JsonCharStream json) {
    }
}
