package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10815_byIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[10000001];
        int[] arr2 = new int[10000001];
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(card < 0) {
                arr2[-card] = 1;
                continue;
            }
            arr[card] = 1;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(card < 0)
                System.out.print(arr2[-card] + " ");
            else
                System.out.print(arr[card] + " ");
        }
    }
}
