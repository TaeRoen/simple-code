package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.VirtualMachine;

/**
 * 操作数
 */
public interface Operand {
    public int readInt(VirtualMachine vm);

    public void writeInt(VirtualMachine vm, int value);
}
