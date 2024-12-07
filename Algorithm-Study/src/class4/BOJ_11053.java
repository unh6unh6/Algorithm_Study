package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < n; i++) {
            int beforeMaxLength = 0;
            for (int j = i-1; j >= 0; j--) {
                if(sequence[i] > sequence[j]) {
                    beforeMaxLength = Math.max(beforeMaxLength, dp[j]);
                }
            }
            dp[i] = beforeMaxLength + 1;
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
