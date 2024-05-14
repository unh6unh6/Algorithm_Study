package CAMP.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int result = 0;
        result += pq.poll();

        try {
            result += pq.poll();
            for (int i = 0; i < n-2; i++) {
                pq.add(result);
                result += pq.poll();
                result += pq.poll();
            }
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println(result);
        }

    }
}
