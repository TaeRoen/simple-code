package com.taeroen.simple.vm;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.instruct.ConditionJumpInstruct;
import com.taeroen.simple.vm.instruct.ExitInstruct;
import com.taeroen.simple.vm.instruct.VMInstruct;

/**
 * 地址总线:   16位
 * 最小操作数: int32
 * 总计数据区: 65536*4
 * start:     执行0地址指令
 * exit:      PC设置为65536,返回值为data[0]
 *
 * 遇到空指令时执行下一条指令
 * 最后一条指令为退出指令 返回值为65535
 */
public class SimpleVirtualMachine implements VirtualMachine {
    private static final int MAX_POINTER = 0x10000;
    private int[] data;
    private VMInstruct[] instructZone;
    private RegisterFile PC; // Program Counter
    private RegisterFile SP; // Stack Point
    private RegisterFile RR; // Result RegisterFile
    private RegisterFile R0; // RegisterFile 0
    private RegisterFile R1; // RegisterFile 1
    private RegisterFile R2; // RegisterFile 2
    private RegisterFile R3; // RegisterFile 3
    private RegisterFile R4; // RegisterFile 4
    private RegisterFile R5; // RegisterFile 5
    private RegisterFile R6; // RegisterFile 6
    private RegisterFile R7; // RegisterFile 7

    public SimpleVirtualMachine() {
        data = new int[MAX_POINTER];
        instructZone = new VMInstruct[MAX_POINTER];
        instructZone[MAX_POINTER-1] = new ExitInstruct(MAX_POINTER-1);
        PC = new RegisterFile(RegisterFile.PC);
        SP = new RegisterFile(RegisterFile.SP);
        RR = new RegisterFile(RegisterFile.RR);
        R0 = new RegisterFile(RegisterFile.R0);
        R1 = new RegisterFile(RegisterFile.R1);
        R2 = new RegisterFile(RegisterFile.R2);
        R3 = new RegisterFile(RegisterFile.R3);
        R4 = new RegisterFile(RegisterFile.R4);
        R5 = new RegisterFile(RegisterFile.R5);
        R6 = new RegisterFile(RegisterFile.R6);
        R7 = new RegisterFile(RegisterFile.R7);
    }

    @Override
    public void accept(VMInstruct instruct) {
        if (instruct != null) {
            instruct.visit(this);
            if(!(instruct instanceof ConditionJumpInstruct)){
                next();
            }
        } else {
            next();
//            throw new NullInstructException();
        }
    }

    @Override
    public void setInstruct(int pointer, VMInstruct instruct) {
        instructZone[pointer] = instruct;
    }

    /**
     *
     */
    @Override
    public void start() {
        PC.writeInt(0);
        while (PC.getInt() < MAX_POINTER) {
            VMInstruct instruct = instructZone[PC.getInt()];
            accept(instruct);
        }
        System.out.println("VM::EXIT(" + data[0] + ")");
        dump();
    }

    @Override
    public void next() {
        PC.writeInt(PC.getInt() + 1);
    }

    @Override
    public void jump(int pointer) {
        PC.writeInt(pointer);
    }

    @Override
    public void exit(int value) {
        PC.writeInt(MAX_POINTER);
        data[0] = value;
    }

    @Override
    public void dump() {
        System.out.println("---- START DUMP ----");
        System.out.println(PC + "\t" + SP + "\t" + RR);
        System.out.println(R0 + "\t" + R1 + "\t" + R2 + "\t" + R3);
        System.out.println(R4 + "\t" + R5 + "\t" + R6 + "\t" + R7);
        for (int i = 0; i < MAX_POINTER; i++) {
            if (data[i] != 0) {
                System.out.printf("0x%08x 0x%08x\n", i, data[i]);
            }
        }
        System.out.println("---- END DUMP ----");
    }

    private RegisterFile getRegisterFile(Register register) {
        switch (register) {
            case PC:
                return PC;
            case SP:
                return SP;
            case RR:
                return RR;
            case R0:
                return R0;
            case R1:
                return R1;
            case R2:
                return R2;
            case R3:
                return R3;
            case R4:
                return R4;
            case R5:
                return R5;
            case R6:
                return R6;
            case R7:
                return R7;
            default:
                return PC;
        }
    }

    @Override
    public int readInt(Operand operand) {
        return operand.readInt(this);
    }

    @Override
    public int readInt(Register register) {
        RegisterFile file = getRegisterFile(register);
        return file.getInt();
    }

    @Override
    public int readInt(int pointer) {
        return data[pointer];
    }

    @Override
    public void writeInt(Operand operand, int value) {
        operand.writeInt(this, value);
    }

    @Override
    public void writeInt(Register register, int value) {
        RegisterFile file = getRegisterFile(register);
        file.writeInt(value);
    }

    @Override
    public void writeInt(int pointer, int value) {
        data[pointer] = value;
    }

}
