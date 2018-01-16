package com.thoughtworks.guesstest;

import com.thoughtworks.guess.AnswerGenerator;
import com.thoughtworks.guess.Guess;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuessTest {

    private Guess guess = new Guess();
    private AnswerGenerator generator = new AnswerGenerator();

    @Test
    public void integrationTest () {
        boolean flag = true;
        int repeat = 10000;
        for (int i = 0; i < repeat; i++) {
            /*用随机生成函数模拟用户输入*/
            String input = generator.getAnswer();
            String result = guess.getResult(input);

            /*判断结果格式*/
            if (result.length() != 4) {
                flag = false;
                break;
            }
            if ('A' != result.charAt(1) || 'B' != result.charAt(3)) {
                flag = false;
                break;
            }
            if (result.charAt(0) < 48 || result.charAt(0) > 57) {
                flag = false;
                break;
            }
            if (result.charAt(2) < 48 || result.charAt(2) > 57) {
                flag = false;
                break;
            }

        }
        assertThat(flag, is(true));
    }

}
