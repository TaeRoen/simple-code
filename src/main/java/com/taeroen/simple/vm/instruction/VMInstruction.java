package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.VirtualMachine;

public abstract class VMInstruction {
    public void visit(VirtualMachine vm) {
        visit0(vm);
        System.out.println("EXEC:"+toString());
    }
    public abstract void visit0(VirtualMachine vm);
}
