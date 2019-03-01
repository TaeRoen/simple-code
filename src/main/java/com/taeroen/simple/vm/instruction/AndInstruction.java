package com.taeroen.simple.vm.instruction;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.Register;
import com.taeroen.simple.vm.RegisterFile;
import com.taeroen.simple.vm.VirtualMachine;

public class AndInstruction extends VMInstruction {
    private Operand op1;
    private Operand op2;

    @Override
    public void visit0(VirtualMachine vm) {
        if (vm.readInt(op1) == vm.readInt(op2)) {
            vm.writeInt(Register.valueOf(RegisterFile.RR), 0xFFFFFFFF);
        }else {
            vm.writeInt(Register.valueOf(RegisterFile.RR), 0);
        }
    }

    public AndInstruction(String op1, String op2) {
        this.op1 = OperandUtil.build(op1);
        this.op2 = OperandUtil.build(op2);
    }

    @Override
    public String toString() {
        return "AND(" + op1 + "->" + op2 + ")";
    }
}
