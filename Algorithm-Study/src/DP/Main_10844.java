package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        arr[1] = 9;
        arr[2] = 17;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + (8 * i);
        }
        System.out.println(arr[n]);
    }
}
