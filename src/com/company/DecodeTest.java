package com.company;

import org.junit.Assert;
import org.junit.Test;

public class DecodeTest {

    @Test(expected = NumberFormatException.class)
    public void decodeEmptyString() {
        Integer.decode("");
    }

    @Test
    public void decodeNegativeNum() {
        Integer expected = -5;
        Integer actual = Integer.decode("-5");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodePositiveNum() {
        Integer expected = 5;
        Integer actual = Integer.decode("+5");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeDecimal() {
        Integer expected = 5;
        Integer actual = Integer.decode("5");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeHexadecimal_1() {
        Integer expected = 10995;
        Integer actual = Integer.decode("0x2AF3");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeHexadecimal_2() {
        Integer expected = 10995;
        Integer actual = Integer.decode("0X2AF3");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeHexadecimal_3() {
        Integer expected = 27;
        Integer actual = Integer.decode("#1B");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeOctal() {
        Integer expected = 5324;
        Integer actual = Integer.decode("012314");
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void decodeCharacterPosition() {
        Integer.decode("+-65");
    }

    @Test(expected = NullPointerException.class)
    public void decodeNull() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void decodeStringWord() {
        Integer.decode("five");
    }

    @Test(expected = NumberFormatException.class)
    public void decodeSpace(){
        Integer.decode("50 000");
    }
}
