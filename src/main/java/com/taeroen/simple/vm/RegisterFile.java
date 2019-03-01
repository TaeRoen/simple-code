package com.taeroen.simple.vm;

public class RegisterFile {
    public static final String PC = "PC";
    public static final String SP = "SP";
    public static final String RR = "RR";
    public static final String R0 = "R0";
    public static final String R1 = "R1";
    public static final String R2 = "R2";
    public static final String R3 = "R3";
    public static final String R4 = "R4";
    public static final String R5 = "R5";
    public static final String R6 = "R6";
    public static final String R7 = "R7";
    private long value = 0;
    private String name;

    public RegisterFile(String name) {
        this.name = name;
    }

    public long getInt() {
        return value;
    }

    public void writeInt(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ":" + String.format("0x%016x",value);
    }
}
