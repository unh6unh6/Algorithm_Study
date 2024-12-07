package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BOJ_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxLength = 0;
        List<String> rawWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String nextLine = br.readLine();
            if (nextLine.length() > maxLength) {
                maxLength = nextLine.length();
            }
            rawWords.add(nextLine);
        }

        char[][] words = new char[n][];
        for (int i = 0; i < n; i++) {
            String word = String.format("%" + maxLength + "s", rawWords.get(i));
            word = word.replace(" ", "0");
            words[i] = word.toCharArray();
        }

        Map<Character, Long> priorityOfAlphabet = new HashMap<>();
        for (int i = 0; i < maxLength; i++) {
            long priorityValue = (long) Math.pow(10, (maxLength - i));
            for (int j = 0; j < n; j++) {
                char thisAlpha = words[j][i];
                if (thisAlpha == '0') {
                    continue;
                }
                long newValue = priorityOfAlphabet.getOrDefault(thisAlpha, 0L) + priorityValue;
                priorityOfAlphabet.put(thisAlpha, newValue);
            }
        }
        List<Map.Entry<Character, Long>> alphabetList = new ArrayList<>(priorityOfAlphabet.entrySet());
        Collections.sort(alphabetList, new Comparator<Entry<Character, Long>>() {
            @Override
            public int compare(Entry<Character, Long> o1, Entry<Character, Long> o2) {
                return Long.compare(o2.getValue(), o1.getValue());
            }
        });
        Map<Character, String> charToInteger = new HashMap<>();
        int convertNum = 9;
        for (Map.Entry<Character, Long> entry : alphabetList) {
            charToInteger.put(entry.getKey(), String.valueOf(convertNum));
            convertNum--;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < maxLength; j++) {
                if (words[i][j] == '0') {
                    continue;
                }
                String convertedNum = charToInteger.get(words[i][j]);
                sb.append(convertedNum);
            }
            sum += (Integer.parseInt(sb.toString()));
        }

        System.out.println(sum);
    }
}

