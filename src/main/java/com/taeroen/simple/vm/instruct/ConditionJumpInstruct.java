package com.taeroen.simple.vm.instruct;

import com.taeroen.simple.vm.Register;
import com.taeroen.simple.vm.VirtualMachine;

public class ConditionJumpInstruct extends VMInstruct {

    private int pointer;

    public ConditionJumpInstruct(int pointer) {
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
