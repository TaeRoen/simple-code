package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.VirtualMachine;

public class ExitInstruction extends VMInstruction {

    private int value;

    public ExitInstruction(int value) {
        this.value = value;
    }

    @Override
    public void visit0(VirtualMachine vm) {
        vm.exit(value);
    }

    @Override
    public String toString() {
        return "Exit(" + value + ")";
    }
}
