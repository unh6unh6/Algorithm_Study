package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1822 {

    static int[] arr;
    static int cnt = 0;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr = new int[a];
        flag = new boolean[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            search(Integer.parseInt(st.nextToken()), 0, arr.length - 1);
        }

        System.out.println(arr.length - cnt);
        for (int i = 0; i < a; i++) {
            if(flag[i])
                continue;
            System.out.print(arr[i] + " ");
        }
    }
    static void search(int element, int low, int high) {
        int mid = (low+high) / 2;
        if(low > high)
            return;
        if(element > arr[mid])
            search(element, mid+1, high);
        else if(element < arr[mid])
            search(element, low, mid - 1);
        else {
            flag[mid] = true;
            cnt++;
        }
    }
}
