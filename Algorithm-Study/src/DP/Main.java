package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] memo = new long[102];

        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++)
                memo[j] =  memo[j-3] + memo[j-2];
            System.out.println(memo[n]);
        }
    }
}
