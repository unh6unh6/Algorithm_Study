package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] memo = new int[1001];
        memo[1] = 1;
        memo[2] = 3;
        for (int i = 3; i <= n; i++)
            memo[i] = ( memo[i - 1] + 2 * memo[i - 2] ) % 10007;
        System.out.println(memo[n]);
    }
}
