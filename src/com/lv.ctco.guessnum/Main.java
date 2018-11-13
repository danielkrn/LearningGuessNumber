package lv.ctco.guessnum;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {                      //объявляем переменную скан и создаем новый сканнер для сканинга потока ввода
    //System.in = input c клавиатуры
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();   //seed: fixed seed value for Randomizer. See Random class for more

    public static void main(String[] args) {
        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("Hello, " + name + "!");


        for (int i = 1; i < 10; i++) {
            int myNum = rand.nextInt(100) + 1;

            System.out.println("Guess my number! Attempt № " + i);
            System.out.println("Spoiler: " + myNum);
            int userNumber;
            try {
                userNumber = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not allowed");
                return;
            }

            if (userNumber == myNum) {
                System.out.println("Yay! You guessed it");
                break;
            } else if (myNum > userNumber) {
                System.out.println("No. But my number is greater than yours");
            } else {
                System.out.println("No. But your number is greater than mine");

            }

        }
    }
}

