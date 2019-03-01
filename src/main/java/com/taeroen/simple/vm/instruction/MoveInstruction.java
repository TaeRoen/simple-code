package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.VirtualMachine;

public class MoveInstruction extends VMInstruction {
    private Operand src;
    private Operand dst;

    @Override
    public void visit0(VirtualMachine vm) {
        vm.writeInt(dst, vm.readInt(src));
    }

    public MoveInstruction(String src, String dst) {
        this.src = OperandUtil.build(src);
        this.dst = OperandUtil.build(dst);
    }

    @Override
    public String toString() {
        return "MOVE(" + src + "->" + dst + ")";
    }
}
