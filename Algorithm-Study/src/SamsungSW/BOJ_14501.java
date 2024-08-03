package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//05:10
public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t[] = new int[n+1];
        int p[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+2];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(dp[i-1] > dp[i])
                dp[i] = dp[i-1];
            if(t[i] + i <= n+1) {
                dp[t[i] + i] = Math.max(dp[t[i] + i], dp[i] + p[i]);
                max = Math.max(dp[t[i] + i], max);
            }
        }
        System.out.println(max);
    }
}
