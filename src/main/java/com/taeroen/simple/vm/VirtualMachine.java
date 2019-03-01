package com.taeroen.simple.vm;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.instruction.VMInstruction;

public interface VirtualMachine {
    public void accept(VMInstruction instruct);

    long readInt(Operand operand);

    long readInt(Register register);

    long readInt(long pointer);

    void writeInt(Operand operand, long value);

    void writeInt(Register register, long value);

    void writeInt(long pointer, long value);

    void setInstruct(long pointer, VMInstruction instruct);

    void start();

    void next();

    void jump(long pointer);

    void exit(long value);

    void dump();

}
