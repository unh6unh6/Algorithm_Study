package class2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < n; i++) {
            sb.append(numbers.remove()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
