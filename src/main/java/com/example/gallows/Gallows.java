package com.example.gallows;

import java.util.Scanner;

public class Gallows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char choice;
        while (true) {
            System.out.println("1 - новая игра");
            System.out.println("2 - выйти");

            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    Game.start();
                    break;
                case '2':
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный ввод\n");
            }
        }
    }
}