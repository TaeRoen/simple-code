package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.VirtualMachine;

public class DivInstruction extends VMInstruction {
    Operand minuend;    // 被减数
    Operand subtrahend; // 减数
    Operand difference; // 差

    @Override
    public void visit0(VirtualMachine vm) {
        int minuend = vm.readInt(this.minuend);
        int subtrahend = vm.readInt(this.subtrahend);
        vm.writeInt(difference, minuend - subtrahend);
    }

    public DivInstruction(String minuend, String subtrahend, String difference) {
        this.minuend = OperandUtil.build(minuend);
        this.subtrahend = OperandUtil.build(subtrahend);
        this.difference = OperandUtil.build(difference);
    }

    @Override
    public String toString() {
        return "DIV(" + minuend + "-" + subtrahend + "->" + difference + ")";
    }
}
