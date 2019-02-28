package com.taeroen.simple.vm;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.instruct.VMInstruct;

public interface VirtualMachine {
    public void accept(VMInstruct instruct);

    int readInt(Operand operand);

    int readInt(Register register);

    int readInt(int pointer);

    void writeInt(Operand operand, int value);

    void writeInt(Register register, int value);

    void writeInt(int pointer, int value);

    void setInstruct(int pointer, VMInstruct instruct);

    void start();

    void next();

    void jump(int pointer);

    void exit(int value);

    void dump();

}
