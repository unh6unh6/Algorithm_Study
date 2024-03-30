package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815 {

    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        card = new int[n];
        for (int i = 0; i < n; i++)
            card[i] = Integer.parseInt(arr[i]);
        Arrays.sort(card);
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(search(num, n-1))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }

    static boolean search(int num, int high) {
        int low = 0;
        while(low <= high) {
            int mid = (high + low) / 2;
            if(num > card[mid])
                low = mid + 1;
            else if(num < card[mid])
                high = mid - 1;
            else
                return true;
        }
        return false;
    }
}
