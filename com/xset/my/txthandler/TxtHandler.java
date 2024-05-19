package com.xset.my.txthandler;

import java.io.*;
import java.util.*;

public class TxtHandler {

    private static final String VOWELS_REGEX = "[аеёиоуыэюяАЕЁИОУЫЭЮЯ]";
    private static final String NON_VOWELS_REGEX = "[^аеёиоуыэюяАЕЁИОУЫЭЮЯ, :–.]";

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {

            Map<String, Integer> wordToCount = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("[', ]");
                for (String word : words) {

                    if (word.isBlank()) {
                        continue;
                    }

                    word = checkShortForm(word);
                    word = word.toLowerCase();

                    wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
                }
            }

            Map<String, Integer> wordToCountTree = new TreeMap<>(wordToCount);
            Set<String> allWords = wordToCountTree.keySet();
            System.out.println(allWords);
            System.out.println(wordToCountTree);

            int max = getMax(wordToCount);

            StringBuilder sb = new StringBuilder();
            sb.append("Words with max usage in text: ").append("\n");
            for (Map.Entry<String, Integer> wordToCountEntry : wordToCount.entrySet()) {
                Integer count = wordToCountEntry.getValue();
                if (count.equals(max)) {
                    sb.append(wordToCountEntry.getKey()).append(" uses ").append(count).append(" times;").append("\n");
                }
            }

            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMax(Map<String, Integer> wordToCount) {
        int max = 0;
        for (Integer value : wordToCount.values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static String checkShortForm(String word) {
        switch (word) {
            case "t" -> word = "not";
            case "ll" -> word = "will";
            case "s" -> word = "is";
        }
        return word;
    }

    private static void letterCounter() {
        try (BufferedReader reader = new BufferedReader(new FileReader("text1.txt"));
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
