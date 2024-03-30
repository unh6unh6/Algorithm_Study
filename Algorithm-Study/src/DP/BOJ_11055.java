package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] memo = new int[a];
        for (int i = 0; i < a; i++) {
            memo[i] = arr[i];

            int maxValue = 0;

            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j] && maxValue < memo[j]) {
                    maxValue = memo[j];
                }
            }

            memo[i] += maxValue;
        }
        int max = 0;
        for(int temp : memo) {
            if(temp > max)
                max = temp;
        }
        System.out.println(max);
    }
}
