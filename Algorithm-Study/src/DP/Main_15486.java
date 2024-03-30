package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15486 {

    public static int[] t;
    public static int[] p;
    public static int n;
    public static int workDay;

    public static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        //기간 제한이 없다고 가정
        memo = new int[n+1];
        memo[t[1]] = t[1] * p[1];
        workDay = t[1];
        for (int i = 2; i <= n; i++) {

        }
    }
}
