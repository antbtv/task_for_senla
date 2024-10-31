package com.example.exchange_rate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExchangeRate {
        private static final Map<Character, String> currencySymbols =
                new HashMap<Character, String>();
        static {
            currencySymbols.put('1', "RUB");
            currencySymbols.put('2', "CNY");
            currencySymbols.put('3', "USD");
            currencySymbols.put('4', "EUR");
            currencySymbols.put('5', "GBP");
        }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amount = 0;

        char choice;
        while (true) {
            System.out.println("1 - получить обменный курс");
            System.out.println("2 - выйти");

            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    boolean flag = false;
                    char innerChoice = '0';
                    while (!flag) {
                        System.out.println("Выберите валюту, для которой хотите получить " +
                                           "обменный курс");
                        System.out.print("1 - RUB\n" +
                                "2 - CNY\n" +
                                "3 - USD\n" +
                                "4 - EUR\n" +
                                "5 - GBP\n");
                        innerChoice = scanner.next().charAt(0);
                        if (innerChoice >= '1' && innerChoice <= '5') {
                            flag = true;
                        } else {
                            System.out.println("Неверный ввод\n");
                        }
                    }

                    flag = false;
                    while (!flag) {
                        System.out.println("Введите сумму для указанной валюты " +
                                           "(ввод через запятую)");
                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                            if (amount >= 0.0001) {
                                flag = true;
                            } else {
                                System.out.println("Ошибка: минимальное число: 0.0001");
                            }
                        } else {
                            System.out.println("Ошибка: введено не число.");
                            scanner.next();
                        }
                    }
                    amount = ((int) (amount * 10000)) / 10000.0;

                    Exchanger.getExchangeRate(amount,
                            currencySymbols.get(innerChoice));
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
