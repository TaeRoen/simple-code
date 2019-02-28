package com.taeroen.simple.vm.instruct;

import com.taeroen.simple.vm.VirtualMachine;

public class ExitInstruct extends VMInstruct {

    private int value;

    public ExitInstruct(int value) {
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
