package com.taeroen.simple.vm.instruct;

import com.taeroen.simple.vm.VirtualMachine;

public class NoneInstruct extends VMInstruct {
    @Override
    public void visit0(VirtualMachine vm) {
    }

    @Override
    public String toString() {
        return "NULL";
    }
}
