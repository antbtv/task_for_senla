package com.example.exchange_rate;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {
    public static final Map<String, Double> exchangeRates = new HashMap<>();
    static {
        exchangeRates.put("RUB", 1.0);
        exchangeRates.put("USD", 97.053);
        exchangeRates.put("EUR", 105.2211);
        exchangeRates.put("CNY", 13.5876);
        exchangeRates.put("GBP", 126.1301);
    }

    public static void getExchangeRate(double amount, String currency) {
        double sum = amount * exchangeRates.get(currency);
        for (String key : exchangeRates.keySet()) {
            if (!currency.equals(key)) {
                double answer = sum / exchangeRates.get(key);
                System.out.printf("Обменный курс для %s : %.4f%n", key, answer);
            }
        }
        System.out.println();
    }
}
