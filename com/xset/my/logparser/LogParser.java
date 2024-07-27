package com.xset.my.logparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    public static void main(String[] args) {

        Map<String, Integer> apiToCounter = new HashMap<>();
        String path = "production_log.csv";

        try (BufferedReader csvReader = new BufferedReader(new FileReader(path))) {

            String line = csvReader.readLine();
            while (line != null) {
                String api = getApi(line);

                if (!api.isEmpty()) {
                    apiToCounter.merge(api, 1, Integer::sum);
                }

                line = csvReader.readLine();
            }

            System.out.println(apiToCounter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int requestSum = 0;
        for (Integer value : apiToCounter.values()) {
            requestSum += value;
        }

        StringBuilder sb = new StringBuilder("Percentage stats by api:");
        sb.append("\n");
        for (Map.Entry<String, Integer> entry : apiToCounter.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            long percentageL = Math.round(entry.getValue() * 100.0 / requestSum);
            sb.append(percentageL);
            sb.append("%");
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static String getApi(String line) {
        String api = "";
        String regex = "/api/([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            api = "api/" + matcher.group(1);
        }
        return api;
    }
}
