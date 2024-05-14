package CAMP.DP;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[x+1];
        dp[1] = 0;
        for (int i = 2; i <= x; i++) {
            if(i % 6 == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i / 2] + 1);
            else if(i % 3 == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
            else if(i % 2 == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            else
                dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[x]);
    }
}
