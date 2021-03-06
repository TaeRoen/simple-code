package com.taeroen.simple.vm;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.instruction.ConditionJumpInstruction;
import com.taeroen.simple.vm.instruction.ExitInstruction;
import com.taeroen.simple.vm.instruction.VMInstruction;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 地址总线:   16位
 * 最小操作数: int32
 * 总计数据区: 65536*4
 * start:     执行0地址指令
 * exit:      PC设置为65536,返回值为data[0]
 * <p>
 * 遇到空指令时执行下一条指令
 * 最后一条指令为退出指令 返回值为65535
 */
public class SimpleVirtualMachine implements VirtualMachine {
    private static final long MAX_INT = 0x7FFFFFFFFFFFFFFFL;
    private static final long ZERO = 0;
    private Map<Long, Long> data;
    private Map<Long, VMInstruction> instruction;
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
        data = new ConcurrentHashMap<>();
        instruction = new ConcurrentHashMap<>();
        instruction.put(-1L, new ExitInstruction(MAX_INT));
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
    public void accept(VMInstruction instruct) {
        if (instruct != null) {
            instruct.visit(this);
            if (!(instruct instanceof ConditionJumpInstruction)) {
                next();
            }
        } else {
            next();
//            throw new NullInstructException();
        }
    }

    @Override
    public void setInstruct(long pointer, VMInstruction instruct) {
        instruction.put(pointer, instruct);
    }

    /**
     *
     */
    @Override
    public void start() {
        PC.writeInt(0);
        while (PC.getInt() >= ZERO) {
            VMInstruction instruct = instruction.get(PC.getInt());
            accept(instruct);
        }
        System.out.println("VM::EXIT(" + data.get(ZERO) + ")");
        dump();
    }

    @Override
    public void next() {
        PC.writeInt(PC.getInt() + 1);
    }

    @Override
    public void jump(long pointer) {
        PC.writeInt(pointer);
    }

    @Override
    public void exit(long code) {
        PC.writeInt(MAX_INT);
        data.put(ZERO, code);
    }

    @Override
    public void dump() {
        System.out.println("---- START DUMP ----");
        System.out.println(PC + "\t" + SP + "\t" + RR);
        System.out.println(R0 + "\t" + R1 + "\t" + R2 + "\t" + R3);
        System.out.println(R4 + "\t" + R5 + "\t" + R6 + "\t" + R7);
        Long[] pointers = new Long[data.size()];
        data.keySet().toArray(pointers);
        Arrays.sort(pointers);
        for (Long pointer:
             pointers) {
            System.out.printf("0x%016x 0x%016x\n", pointer, data.get(pointer));

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
    public long readInt(Operand operand) {
        return operand.readInt(this);
    }

    @Override
    public long readInt(Register register) {
        RegisterFile file = getRegisterFile(register);
        return file.getInt();
    }

    @Override
    public long readInt(long pointer) {
        Long res = data.get(pointer);
        if (res != null) {
            return res;
        }
        return ZERO;
    }

    @Override
    public void writeInt(Operand operand, long value) {
        operand.writeInt(this, value);
    }

    @Override
    public void writeInt(Register register, long value) {
        RegisterFile file = getRegisterFile(register);
        file.writeInt(value);
    }

    @Override
    public void writeInt(long pointer, long value) {
        data.put(pointer, value);
    }

}
