package com.example.password;

import java.security.SecureRandom;

public class Generator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 12;
    private static final String LOWER_CASE = "qwertyuiopasdfghjklzxcvbnm";
    private static final String UPPER_CASE = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_-+=<>?";
    private static final String ALL = LOWER_CASE + UPPER_CASE + NUMBERS + SPECIAL;

    public static String generatePassword(int lengthOfPassword) {
        SecureRandom random = new SecureRandom();

        if (lengthOfPassword == -1) {
            lengthOfPassword = random.nextInt(MIN_LENGTH, MAX_LENGTH);
        }
        StringBuilder password = new StringBuilder(lengthOfPassword);

        password.append(LOWER_CASE.charAt(random.nextInt(LOWER_CASE.length())));
        password.append(UPPER_CASE.charAt(random.nextInt(UPPER_CASE.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        for (int i = 0; i < lengthOfPassword - 4; i++) {
            password.append(ALL.charAt(random.nextInt(ALL.length())));
        }

        int randomIndex;
        char sup;
        for (int i = 0; i < password.length(); i++) {
            randomIndex = random.nextInt(password.length());
            if (password.charAt(i) != password.charAt(randomIndex)) {
                sup = password.charAt(i);
                password.setCharAt(i, password.charAt(randomIndex));
                password.setCharAt(randomIndex, sup);
            }
        }

        return password.toString();
    }
}