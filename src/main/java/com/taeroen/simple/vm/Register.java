package com.taeroen.simple.vm;

public enum Register {

    PC(RegisterFile.PC),
    SP(RegisterFile.SP),
    RR(RegisterFile.RR),
    R0(RegisterFile.R0),
    R1(RegisterFile.R1),
    R2(RegisterFile.R2),
    R3(RegisterFile.R3),
    R4(RegisterFile.R4),
    R5(RegisterFile.R5),
    R6(RegisterFile.R6),
    R7(RegisterFile.R7);

    private final String name;

    Register(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
