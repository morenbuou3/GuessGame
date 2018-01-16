package com.thoughtworks.guesstest;

import com.thoughtworks.guess.AnswerGenerator;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AnswerGeneratorTest {

    private AnswerGenerator generator = new AnswerGenerator();

    @Test
    public void testIsNumber () {
        boolean result = true;
        int repeat = 1000;
        while (result && repeat > 0) {
            String randomNumber = generator.getAnswer();
            for (int i = 0; i < randomNumber.length(); i++) {
                if (!Character.isDigit(randomNumber.charAt(i))) {
                    result = false;
                    break;
                }
            }
            repeat--;
        }
        assertThat(result,is(true));
    }

    @Test
    public void testNotRepeat () {
        Set<Character> numberSet = new HashSet<>();
        boolean result = true;
        int repeat = 1000;
        while (result && repeat > 0) {
            String randomNumber = generator.getAnswer();
            numberSet.clear();
            for (int i = 0; i < randomNumber.length(); i++) {
                numberSet.add(randomNumber.charAt(i));
            }
            if (numberSet.size() != randomNumber.length()) {
                result = false;
            }
            repeat--;
        }
        assertThat(result,is(true));
    }

    @Test
    public void testIsRandom () {
        Set<String> numberSet = new HashSet<>();
        boolean result = true;
        int repeat = 1000;
        for (int i = 0; i < repeat; i++) {
            String randomNumber = generator.getAnswer();
            numberSet.add(randomNumber);
        }
        if (numberSet.size() < 800) {
            result = false;
        }
        assertThat(result,is(true));
    }

    @Test
    public void testIs4Digit () {
        boolean result = true;
        int repeat = 1000;
        while (result && repeat > 0) {
            String randomNumber = generator.getAnswer();
            if (randomNumber.length() != 4) {
                result = false;
            }
            repeat--;
        }
        assertThat(result,is(true));
    }
}
