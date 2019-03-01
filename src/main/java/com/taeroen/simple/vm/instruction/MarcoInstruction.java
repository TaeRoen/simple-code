package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.VirtualMachine;

import java.util.LinkedList;
import java.util.List;

public class MarcoInstruction extends VMInstruction {

    List<VMInstruction> instructionsList;

    public MarcoInstruction() {
        this.instructionsList = new LinkedList<>();
    }

    @Override
    public void visit0(VirtualMachine vm) {
        for (VMInstruction instruction :
                instructionsList) {
            instruction.visit(vm);
        }
    }
}
