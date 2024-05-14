package CAMP.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;  // 1 + 1, 2
        dp[3] = 4;// 1+1+1, 2+1. 1+2, 3
        while(t-- > 0 ) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }

            System.out.println(dp[n]);
        }
    }
}
