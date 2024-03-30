package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

    static int[] arr;
    static long length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = Integer.parseInt(br.readLine());

        System.out.println( find(1, Integer.MAX_VALUE, k, n, 0));
    }
    static long find(long low, long high, int k, int n, long max) {

//        System.out.println(low + " / " + high);

        if(low > high)
            return max;

        long cnt = 0;
        length = (low + high) / 2;


        for (int i = 0; i < k; i++)
            cnt += (arr[i] / length);


        if(cnt < n)
            return find(low, length - 1, k, n, max);

        if(length > max)
            max = length;

        return find(length + 1, high, k, n, max);

    }
}
