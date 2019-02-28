package com.taeroen.simple.vm;

import com.taeroen.simple.vm.instruct.*;
import org.junit.Before;
import org.junit.Test;

public class SimpleVirtualMachineTest {

    SimpleVirtualMachine vm;
    int pointer;

    public void addInstruct(VMInstruct instruct) {
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
        addInstruct(new MoveInstruct("1024", "R0"));
        addInstruct(new MoveInstruct("1025", "R1"));
        addInstruct(new MoveInstruct("R0", "*1024"));
        addInstruct(new MoveInstruct("*1024", "R2"));
        addInstruct(new MoveInstruct("R2", "R3"));
        addInstruct(new AddInstruct("R0", "R1", "R4"));
        addInstruct(new DivInstruct("R1", "R0", "R7"));
        addInstruct(new MoveInstruct("5", "R0"));
        addInstruct(new MoveInstruct("1", "R1"));
        addInstruct(new AddInstruct("R1", "1", "R1"));
        addInstruct(new AndInstruct("R0","R1"));
        addInstruct(new NonInstruct("RR","RR"));
        addInstruct(new ConditionJumpInstruct(9));
        vm.setInstruct(1000, new ExitInstruct(1000));
        vm.setInstruct(2000, new ExitInstruct(2000));
        vm.start();
    }
}