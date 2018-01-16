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
        String randomNumber = generator.getAnswer();
        boolean result = true;
        for (int i = 0; i < randomNumber.length(); i++) {
            if (!Character.isDigit(randomNumber.charAt(i))) {
                result = false;
                break;
            }
        }
        assertThat(result,is(true));
    }

    @Test
    public void testNotRepeat () {
        String randomNumber = generator.getAnswer();
        Set<Character> numberSet = new HashSet<>();
        boolean result = true;
        for (int i = 0; i < randomNumber.length(); i++) {
            numberSet.add(randomNumber.charAt(i));
        }
        if (numberSet.size() != randomNumber.length()) {
            result = false;
        }
        assertThat(result,is(true));
    }

    @Test
    public void testIsRandom () {
        Set<String> numberSet = new HashSet<>();
        boolean result = true;
        for (int i = 0; i < 1000; i++) {
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
        String randomNumber = generator.getAnswer();
        boolean result = true;
        if (randomNumber.length() != 4) {
            result = false;
        }
        assertThat(result,is(true));
    }
}
