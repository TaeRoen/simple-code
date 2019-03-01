package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.Register;

public class OperandUtil {
    /**
     * 立即数: |+数字
     * 寄存器: 寄存器名
     * 指针:   *+数字
     */
    public static Operand build(String string) {
        if (string.matches("^\\*[0-9]*$")) {
            return new PointerInt(Long.parseLong(string.split("\\*")[1]));
        }
        if (string.matches("^\\*0x[0-9]*$")) {
            return new PointerInt(Long.parseLong(string.split("\\*0x")[1], 16));
        }
        if (string.matches("^[0-9]*$")) {
            return new ImmediateInt(Long.parseLong(string));
        }
        if (string.matches("^0x[0-9]*$")) {
            return new ImmediateInt(Long.parseLong(string.split("0x")[1], 16));
        }
        return new RegisterInt(Register.valueOf(string));
    }
}
