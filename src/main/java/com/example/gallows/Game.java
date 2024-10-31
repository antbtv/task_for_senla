package com.example.gallows;

import java.util.*;

public class Game {
    private static final String[] WORDS = {"виселица", "прятки", "сторож", "копейка",
            "леопард", "аттракцион", "дрессировка"};
    private static final int MAX_LIVES = 6;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        char[] answer = new char[word.length()];
        Arrays.fill(answer, '_');

        int countOfMisses = 0;
        char answerChar;
        Set<Character> misses = new HashSet<>();

        while (countOfMisses < MAX_LIVES) {
            System.out.print("\nЗагаданное слово: ");
            for (char c : answer) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.println("Количество ошибок: " + countOfMisses + "/" + MAX_LIVES);
            System.out.println("Введите букву: ");

            answerChar = scanner.next().toLowerCase().charAt(0);

            if (word.contains(answerChar + "")) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == answerChar) {
                        answer[i] = answerChar;
                    }
                }
            } else {
                if (misses.contains(answerChar)) {
                    System.out.println("Вы ввели букву, которую вводили ранее");
                } else {
                    misses.add(answerChar);
                }
                countOfMisses++;
            }
            if (!Arrays.toString(answer).contains("_")) {
                System.out.println("Вы победили! Очки: " + (MAX_LIVES - countOfMisses) +
                        "\n\n");
                return;
            }
        }
        System.out.println("Вы не угадали слово( \n\n");
    }
}
