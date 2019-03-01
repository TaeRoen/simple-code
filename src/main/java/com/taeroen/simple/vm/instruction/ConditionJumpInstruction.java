package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.Register;
import com.taeroen.simple.vm.VirtualMachine;

public class ConditionJumpInstruction extends VMInstruction {

    private int pointer;

    public ConditionJumpInstruction(int pointer) {
        this.pointer = pointer;
    }

    @Override
    public void visit0(VirtualMachine vm) {
        if (vm.readInt(Register.RR) != 0) {
            vm.jump(pointer);
        } else {
            vm.next();
        }
    }

    @Override
    public String toString() {
        return "JMP(" + pointer + ')';
    }
}
