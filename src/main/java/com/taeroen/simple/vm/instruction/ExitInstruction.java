package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.VirtualMachine;

public class ExitInstruction extends VMInstruction {

    private long code;

    public ExitInstruction(long code) {
        this.code = code;
    }

    @Override
    public void visit0(VirtualMachine vm) {
        vm.exit(code);
    }

    @Override
    public String toString() {
        return "Exit(" + code + ")";
    }
}
