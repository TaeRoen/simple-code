package com.taeroen.simple.vm.instruct;

import com.taeroen.simple.vm.Operand.Operand;
import com.taeroen.simple.vm.Operand.OperandUtil;
import com.taeroen.simple.vm.Register;
import com.taeroen.simple.vm.RegisterFile;
import com.taeroen.simple.vm.VirtualMachine;

public class NonInstruct extends VMInstruct {
    private Operand src;
    private Operand dst;

    @Override
    public void visit0(VirtualMachine vm) {
        if (src.readInt(vm) == 0) {
            vm.writeInt(Register.valueOf(RegisterFile.RR), 0xFFFFFFFF);
        } else {
            vm.writeInt(Register.valueOf(RegisterFile.RR), 0);
        }
    }

    public NonInstruct(String src, String dst) {
        this.src = OperandUtil.build(src);
        this.dst = OperandUtil.build(dst);
    }

    @Override
    public String toString() {
        return "NON(" + src + "->" + dst + ")";
    }
}
