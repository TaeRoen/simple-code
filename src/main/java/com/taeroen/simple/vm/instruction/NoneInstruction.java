package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.VirtualMachine;

public class NoneInstruction extends VMInstruction {
    @Override
    public void visit0(VirtualMachine vm) {
    }

    @Override
    public String toString() {
        return "NULL";
    }
}
