package com.thoughtworks.guess;

import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {

        Guess guess = new Guess();
        JudgeInput judgeInput = new JudgeInput();

        Scanner sc = new Scanner(System.in);
        int count = 6;

        System.out.println("Welcome!");
        while (count > 0){
            System.out.println("");
            System.out.print("Please input your number (" + count + "):");
            String input = sc.next();
            if (!judgeInput.judge(input)) {
                System.out.println("Cannot input duplicate numbers!");
                continue;
            }
            String answer = guess.getResult(input);
            if (answer == "4A0B") {
                System.out.println("Congratulations!");
                break;
            }
            System.out.println(answer);
            count--;
        }
        if (count == 0) {
            System.out.println();
            System.out.println("Game Over!");
        }
    }
}
