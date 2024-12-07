package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = br.readLine();
            if(line.equals("0 0 0"))
                break;
            String[] rawNumbers = line.split(" ");
            List<Integer> numbers = new ArrayList<>();
            for(String s : rawNumbers) {
                numbers.add(Integer.parseInt(s));
            }
            Collections.sort(numbers);
            if (Math.pow(numbers.get(0), 2) + Math.pow(numbers.get(1), 2) == Math.pow(numbers.get(2), 2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
