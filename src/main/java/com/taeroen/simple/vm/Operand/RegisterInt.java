package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.Register;
import com.taeroen.simple.vm.VirtualMachine;

import java.util.Objects;

public class RegisterInt implements Operand {
    Register register;

    public RegisterInt(Register register) {
        this.register = register;
    }

    @Override
    public int readInt(VirtualMachine vm) {
        return vm.readInt(register);
    }

    @Override
    public void writeInt(VirtualMachine vm, int value) {
        vm.writeInt(register, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterInt that = (RegisterInt) o;
        return register == that.register;
    }

    @Override
    public int hashCode() {
        return Objects.hash(register);
    }

    @Override
    public String toString() {
        return register.getName();
    }
}
