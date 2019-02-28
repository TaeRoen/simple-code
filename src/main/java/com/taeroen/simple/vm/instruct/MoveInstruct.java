package com.taeroen.simple.vm.instruct;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.VirtualMachine;

public class MoveInstruct extends VMInstruct {
    private Operand src;
    private Operand dst;

    @Override
    public void visit0(VirtualMachine vm) {
        vm.writeInt(dst, vm.readInt(src));
    }

    public MoveInstruct(String src, String dst) {
        this.src = OperandUtil.build(src);
        this.dst = OperandUtil.build(dst);
    }

    @Override
    public String toString() {
        return "MOVE(" + src + "->" + dst + ")";
    }
}
