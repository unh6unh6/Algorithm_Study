package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length())
                    return Integer.compare(o1.length(), o2.length());
                return o1.compareTo(o2);
            }
        });

        words.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
