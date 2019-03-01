package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.VirtualMachine;

import java.util.Objects;

/**
 * 立即数
 */
public class ImmediateInt implements Operand {
    long value;

    public ImmediateInt(long value) {
        this.value = value;
    }

    @Override
    public long readInt(VirtualMachine vm) {
        return value;
    }

    @Override
    public void writeInt(VirtualMachine vm, long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmediateInt that = (ImmediateInt) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
