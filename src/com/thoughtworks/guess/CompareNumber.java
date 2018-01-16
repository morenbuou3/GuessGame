package com.thoughtworks.guess;

public class CompareNumber {
    /*比较数字并以xAxB形式给出结果*/
    public String getResult (String answer, String input) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < input.length(); i++) {
            int numberIndex = answer.indexOf(input.charAt(i));
            if (numberIndex != -1) {
                if (numberIndex == i) {
                    countA++;
                } else {
                    countB++;
                }
            }
        }
        return countA+"A"+countB+"B";
    }

}
