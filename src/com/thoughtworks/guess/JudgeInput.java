package com.thoughtworks.guess;

import java.util.HashSet;
import java.util.Set;

public class JudgeInput {
    /*判断输入是否合法*/
    public boolean judge (String input) {
        return judgeNumber(input) && judgeNumberBit(input) && judgeNumberRepeat(input);
    }

    /*判断数字*/
    private boolean judgeNumber (String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i);
            if (num < 48 || num > 57) {
                return false;
            }
        }
        return true;
    }

    /*判断数字位数*/
    private boolean judgeNumberBit (String input) {
        return input.length() == 4;
    }

    /*判断数字重复*/
    private boolean judgeNumberRepeat (String input) {
        Set<Character> numberSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            numberSet.add(input.charAt(i));
        }
        return numberSet.size() == input.length();
    }
}
