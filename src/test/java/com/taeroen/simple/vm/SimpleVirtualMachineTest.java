package com.taeroen.simple.vm;

import com.taeroen.simple.vm.instruction.*;
import org.junit.Before;
import org.junit.Test;

public class SimpleVirtualMachineTest {

    SimpleVirtualMachine vm;
    int pointer;

    public void addInstruct(VMInstruction instruct) {
        vm.setInstruct(pointer, instruct);
        pointer++;
    }

    @Before
    public void setUp() throws Exception {
        vm = new SimpleVirtualMachine();
        pointer = 0;
    }

    @Test
    public void exec() {
        addInstruct(new MoveInstruction("0x400", "R0"));
        addInstruct(new MoveInstruction("1025", "R1"));
        addInstruct(new MoveInstruction("R0", "*0x400"));
        addInstruct(new MoveInstruction("*1024", "R2"));
        addInstruct(new MoveInstruction("R2", "R3"));
        addInstruct(new AddInstruction("R0", "R1", "R4"));
        addInstruct(new DivInstruction("R1", "R0", "R7"));
        addInstruct(new MoveInstruction("5", "R0"));
        addInstruct(new MoveInstruction("1", "R1"));
        addInstruct(new AddInstruction("R1", "1", "R1"));
        addInstruct(new AndInstruction("R0","R1"));
        addInstruct(new NonInstruction("RR","RR"));
        addInstruct(new ConditionJumpInstruction(9));
        vm.setInstruct(1000, new ExitInstruction(1000));
        vm.setInstruct(2000, new ExitInstruction(2000));
        vm.start();
    }
}