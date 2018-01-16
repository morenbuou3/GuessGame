package com.thoughtworks.guess;

import java.util.Random;

public class AnswerGenerator {
    /*随机生成4位各不相同数字*/
    public String getAnswer () {
        Random random = new Random();
        int bitField = 0;
        char[] answer = new char[4];
        for (int i = 0; i < 4; i++) {
            while (true) {
                int num = random.nextInt(10);
                if ((bitField & (1 << num)) == 0) {
                    bitField |= 1 << num;
                    answer[i] = (char) (num + '0');
                    break;
                }
            }
        }
        return new String(answer);
    }
}
