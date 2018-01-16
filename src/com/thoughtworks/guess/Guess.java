package com.thoughtworks.guess;

public class Guess {
    /*答案构造器*/
    private AnswerGenerator generator = new AnswerGenerator();
    /*答案比较器*/
    private CompareNumber comparator = new CompareNumber();

    /*用户输入并获取结果*/
    public String getResult (String input) {
        String answer = generator.getAnswer();
        return comparator.getResult(answer,input);
    }
}
