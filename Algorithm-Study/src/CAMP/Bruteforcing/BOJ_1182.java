package CAMP.Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

    static int[] arr;
    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        recursion(0,0);
        cnt = m == 0 ? cnt-1 : cnt;
        System.out.println(cnt);
    }
    static void recursion(int index, int sum) {
        if(index == n) {
            if(sum == m)
                cnt++;
            return;
        }
        recursion(index + 1, sum);
        recursion(index + 1, sum + arr[index]);
    }
}
