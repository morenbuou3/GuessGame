package com.thoughtworks.guess;

import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {

        Guess guess = new Guess();

        Scanner sc = new Scanner(System.in);
        int count = 6;

        System.out.println("Welcome!");
        while (count > 0){
            System.out.println("");
            System.out.print("Please input your number (" + count + "):");
            String input = sc.next();

            /*对用户输入格式进行判断*/
            if (!JudgeInputUtils.judge(input)) {
                System.out.println("Cannot input duplicate numbers!");
                continue;
            }

            String answer = guess.getResult(input);

            /*猜中了*/
            if ("4A0B".equals(answer)) {
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
