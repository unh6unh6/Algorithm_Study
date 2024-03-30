package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {

    public static int n;
    public static int[][] arr;
    public static int beforeMax(int i, int j) {
        if(j == 0)
            return arr[i-1][j];
        if(j == i)
            return arr[i-1][j-1];
        if(arr[i-1][j-1] > arr[i-1][j])
            return arr[i-1][j-1];
        return arr[i-1][j];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int finalMax = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] += beforeMax(i,j);

                if(i == n-1 && arr[i][j] > finalMax)
                    finalMax = arr[i][j];
            }
        }

        System.out.println(finalMax);
    }
}
