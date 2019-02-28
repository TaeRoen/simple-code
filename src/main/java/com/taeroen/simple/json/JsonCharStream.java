package com.taeroen.simple.json;

import com.taeroen.simple.json.exception.InvalidCharException;

public class JsonCharStream {

    char[] chars;
    int index;

    public JsonCharStream(String json) {
        json = json.trim();
        chars = json.toCharArray();
        index = 0;
    }

    private void assertIndex() {
        assertIndex(1);
    }

    private void assertIndex(int length) {
        if (index + length > chars.length || index < 0) {
            throw new InvalidCharException(this);
        }
    }

    public boolean assertBeginWith(char dst) {
        assertIndex();
        return chars[index] == dst;
    }

    public boolean assertBeginWith(String dst) {
        assertIndex(dst.length());
        char[] dstArray = dst.toCharArray();
        for (int i = 0; i < dst.length(); i++) {
            if (chars[index + i] != dstArray[i]) {
                return false;
            }
        }
        return true;
    }

    private void moveIndex() {
        moveIndex(1);
    }

    private void moveIndex(int i) {
        assertIndex(i);
        index += i;
    }

    public void skipUnless() {
        while (index < chars.length &&
                (chars[index] == ' ' || chars[index] == '\r' || chars[index] == '\n' || chars[index] == '\t')) {
            index++;
        }
    }

    public char assertNotAndVerify() {
        assertIndex();
        char res = chars[index];
        index++;
        return res;
    }

    public boolean assertAndVerify(char dst) {
        if (assertBeginWith(dst)) {
            moveIndex();
            return true;
        } else {
            return false;
        }
    }

    public boolean assertAndVerify(String dst) {
        if (assertBeginWith(dst)) {
            moveIndex(dst.length());
            return true;
        } else {
            return false;
        }
    }

    public boolean isEnd() {
        return index == chars.length;
    }

    public boolean assertBeginIn(char[] dst) {
        for (char c : dst) {
            if (assertBeginWith(c)) {
                return true;
            }
        }
        return false;
    }

    public char[] fetchBeforeAndVerify(char dst) {
        int tmp = index;
        for (; tmp < chars.length; tmp++) {
            if (chars[tmp] == dst) {
                break;
            }
        }

        if (tmp == chars.length && tmp == index) {
            return null;
        }

        char[] res = new char[tmp - index];
        for (int i = index; i < tmp; i++) {
            res[i - index] = chars[i];
        }
        index = tmp;
        return res;
    }
}
