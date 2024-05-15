package com.xset.my.txthandler;

import java.io.*;

public class TxtHandler {

    private static final String VOWELS_REGEX = "[аеёиоуыэюяАЕЁИОУЫЭЮЯ]";
    private static final String NON_VOWELS_REGEX = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯ, :–.]";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            String line;
            int vowelsCount = 0;
            int consonantsCount = 0;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll(VOWELS_REGEX, "а");
                line = line.replaceAll(NON_VOWELS_REGEX, "м");

                char[] lineCharArray = line.toCharArray();
                for (char letter : lineCharArray) {
                    if (letter == 'а') {
                        vowelsCount++;
                    } else if (letter == 'м') {
                        consonantsCount++;
                    }
                }

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Vowels: " + vowelsCount);
            System.out.println("Consonants: " + consonantsCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
