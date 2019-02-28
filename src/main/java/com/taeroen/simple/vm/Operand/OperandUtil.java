package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.Register;

import java.util.regex.Pattern;

public class OperandUtil {
    /**
     * 立即数: |+数字
     * 寄存器: 寄存器名
     * 指针:   *+数字
     */
    public static Operand build(String string){
        if (string.matches("^\\*[0-9]*$")){
            return new PointerInt(Integer.valueOf(string.split("\\*")[1]));
        }
        if (string.matches("^[0-9]*$")){
            return new ImmediateInt(Integer.valueOf(string));
        }
        return new RegisterInt(Register.valueOf(string));
    }
}
