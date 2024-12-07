package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_5430 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            String prompts = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String rawNumbers = br.readLine();
            String[] rawNumbersArray = rawNumbers.substring(1, rawNumbers.length() - 1).split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String s : rawNumbersArray) {
                if (!s.isEmpty()) {
                    numbers.add(Integer.parseInt(s));
                }
            }

            AC(prompts, n, numbers);
        }
    }

    static void AC(String prompts, int n, List<Integer> numbers) {
        boolean reverseFlag = false;
        for (char prompt : prompts.toCharArray()) {
            if (prompt == 'R') {
                reverseFlag = !reverseFlag;
            } else if (prompt == 'D') {
                try {
                    if (!reverseFlag) {
                        numbers.remove(0);
                    } else {
                        numbers.remove(numbers.size() - 1);
                    }
                } catch (Exception e) {
                    System.out.println("error");
                    return;
                }
            }
        }
        if (reverseFlag) {
            Collections.reverse(numbers);
        }
        List<String> stringNumbers = numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.toList());

        System.out.printf("[%s]\n", String.join(",", stringNumbers));
    }
}
