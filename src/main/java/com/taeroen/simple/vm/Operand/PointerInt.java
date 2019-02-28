package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.VirtualMachine;

import java.util.Objects;

public class PointerInt implements Operand {
    private int pointer;
    @Override
    public int readInt(VirtualMachine vm) {
        return vm.readInt(pointer);
    }

    @Override
    public void writeInt(VirtualMachine vm, int value) {
        vm.writeInt(pointer,value);
    }

    public PointerInt(int pointer) {
        this.pointer = pointer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointerInt that = (PointerInt) o;
        return pointer == that.pointer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointer);
    }

    @Override
    public String toString() {
        return "*" + pointer;
    }
}
