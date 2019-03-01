package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.VirtualMachine;

public class AddInstruction extends VMInstruction {
    Operand addend1;
    Operand addend2;
    Operand sum;

    @Override
    public void visit0(VirtualMachine vm) {
        long addend1 = vm.readInt(this.addend1);
        long addend2 = vm.readInt(this.addend2);
        long sum = addend1 + addend2;
        vm.writeInt(this.sum, sum);
    }

    public AddInstruction(String addend1, String addend2, String sum) {
        this.addend1 = OperandUtil.build(addend1);
        this.addend2 = OperandUtil.build(addend2);
        this.sum = OperandUtil.build(sum);
    }

    @Override
    public String toString() {
        return "ADD(" + addend1 + "+" + addend2 + "->" + sum + ")";
    }
}
