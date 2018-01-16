package com.thoughtworks.guesstest;

import com.thoughtworks.guess.CompareNumber;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CompareNumberTest {

    private CompareNumber comparator = new CompareNumber();

    @Test
    public void test4A0B () {
        String result = comparator.getResult("1234","1234");
        assertThat (result, is("4A0B"));
    }

    @Test
    public void test0A4B () {
        String result = comparator.getResult("1234","4321");
        assertThat (result, is("0A4B"));
    }

    @Test
    public void test0A0B () {
        String result = comparator.getResult("1234","5678");
        assertThat (result, is("0A0B"));
    }

    @Test
    public void test2A2B () {
        String result = comparator.getResult("1234","1243");
        assertThat (result, is("2A2B"));
    }

    @Test
    public void test0A2B () {
        String result = comparator.getResult("1234","2156");
        assertThat (result, is("0A2B"));
    }
}
