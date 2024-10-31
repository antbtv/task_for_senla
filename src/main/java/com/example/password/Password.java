package com.example.password;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length;

        char choice;
        while (true) {
            System.out.println("1 - сгенерировать новый пароль");
            System.out.println("2 - выйти");

            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    System.out.println("Вы можете выбрать длину пароля (от 8 до 12)");
                    System.out.println("1 - произвольная длина");
                    System.out.println("2 - задать длину");

                    length = -1;
                    choice = scanner.next().charAt(0);
                    switch (choice) {
                        case '1':
                            Generator.generatePassword(length);
                            break;
                        case '2':
                            boolean flag = false;
                            while (!flag) {
                                System.out.print("Введите число от 8 до 12: ");
                                if (scanner.hasNextInt()) {
                                    length = scanner.nextInt();
                                    if (length >= 8 && length <= 12) {
                                        flag = true;
                                    } else {
                                        System.out.println("Ошибка: число должно быть в диапазоне от 8 до 12.");
                                    }
                                } else {
                                    System.out.println("Ошибка: введено не число.");
                                    scanner.next();
                                }
                            }
                            Generator.generatePassword(length);
                            break;
                        default:
                            System.out.println("Неверный ввод\n");
                    }
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
