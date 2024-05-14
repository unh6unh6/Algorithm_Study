package CAMP.DP;

import java.util.Scanner;

public class BOJ_2579 {

    static int[] arr;
    static int[] max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        max = new int[n+1];
        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        if(n<2) {
            System.out.println(arr[n]);
            return;
        }
        max[1] = arr[1];
        max[2] = arr[1] + arr[2];
        for (int i = 3; i <= n; i++) {
            max[i] = Math.max(max[i-2] + arr[i] , max[i-3] + arr[i-1] + arr[i]);
        }
        System.out.println(max[n]);
    }
}
