package com.taeroen.simple.vm.Operand;

import com.taeroen.simple.vm.Register;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperandUtilTest {

    @Test
    public void build() {
        assertEquals(new ImmediateInt(1024),OperandUtil.build("1024"));
        assertEquals(new RegisterInt(Register.R0),OperandUtil.build("R0"));
        assertEquals(new PointerInt(1024),OperandUtil.build("*1024"));
    }
}