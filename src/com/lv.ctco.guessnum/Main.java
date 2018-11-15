package lv.ctco.guessnum;

import com.lv.ctco.guessnum.GameResult;

import java.util.*;

public class Main {                      //объявляем переменную скан и создаем новый сканнер для сканинга потока ввода
    //System.in = input c клавиатуры
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();      //seed: fixed seed value for Randomizer. See Random class for more
    static List<GameResult> results = new ArrayList<>();  //That is an array. List is a class? GameResult is reference? results is a reference to an instance? ArrayList is a class.

    public static void main(String[] args) {

        do {


            System.out.println("What is your name?");
            String name = scan.next();
            long t1 = System.currentTimeMillis();
            System.out.println("Hello, " + name + "!");
            System.out.println("Time started!");


            for (int i = 1; i < 10; i++) {
                int myNum = rand.nextInt(100) + 1;

                System.out.println("Guess my number! Attempt № " + i);
                System.out.println("Spoiler: " + myNum);
                int userNumber = readUserNum();

                if (userNumber == myNum) {
                    System.out.println("Yay! You guessed it");
                    GameResult r = new GameResult(); //A guy just won. We gonna store his stats in instance of GameResult. GameResult is a pattern. r is an instance with guys stats.
                    r.duration = (System.currentTimeMillis() - t1) / 1000;
                    System.out.println("Your time is " + r.duration + " seconds");
                    r.name = name;
                    r.triesCount = i;
                    results.add(r);     // We are adding whatever arrived into r object into results array. Will get added as a single, 1st record of array.
                    break;
                } else if (myNum > userNumber) {
                    System.out.println("No. But my number is greater than yours");
                } else {
                    System.out.println("No. But your number is greater than mine");

                }

            }
            System.out.println("Would you like to play again?");
        } while ("yes".equals(scan.next()));    // Oho, stronk

       System.out.println("Game over! Here are the results:");
        for (GameResult r : results) {
            System.out.println(r.name + ": " + r.triesCount + " tries " + "and " + r.duration + " seconds");
        }
    }

    private static int readUserNum() {
        while (true) {
            try {
                int userNumber = scan.nextInt();
                if (userNumber < 1 || userNumber > 100) {
                    System.out.println("Wrong number entered. Try again");
                    continue;
                }
                return userNumber;          // Returns userNumber to method readUserNum(), right?
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Not allowed");
            }
        }

    }
}