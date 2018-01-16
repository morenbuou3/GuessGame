package com.thoughtworks.guesstest;

import com.thoughtworks.guess.JudgeInputUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class JudgeInputUtilsTest {

    @Test
    public void testInputEmpty () {
        boolean result = JudgeInputUtils.judge("");
        assertThat(result,is(false));
    }

    @Test
    public void testInputBlank () {
        boolean result = JudgeInputUtils.judge("      ");
        assertThat(result,is(false));
    }

    @Test
    public void testInput4BitNumber () {
        boolean result = JudgeInputUtils.judge("1234");
        assertThat(result,is(true));
    }

    @Test
    public void testInput5BitNumber () {
        boolean result = JudgeInputUtils.judge("12345");
        assertThat(result,is(false));
    }

    @Test
    public void testInputRepeat () {
        boolean result = JudgeInputUtils.judge("1223");
        assertThat(result,is(false));
    }

    @Test
    public void testInputNotNumber () {
        boolean result = JudgeInputUtils.judge("aBCD");
        assertThat(result,is(false));
    }

}
