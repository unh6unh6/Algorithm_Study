package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2531 { // 19:40
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int max = 0;

        for (int i = 0; i < k; i++) {
            if(!list.contains(arr[i]))
                max ++;
            list.offer(arr[i]);
        }

        int cnt = max;
        for (int i = 0; i <= n; i++) {
            // pointer 1 : i
            // pointer 2 : (i + k) % 8
            int p1 = i % n;
            int p2 = (i + k) % n;
            list.remove((Integer)arr[p1]);
            if(!list.contains(arr[p1]))
                cnt--;

            if(!list.contains(arr[p2]))
                cnt++;
            list.offer(arr[p2]);

            int cntWithCoupon = cnt;
            if(!list.contains(c))
                cntWithCoupon++;

            //System.out.println(list + " " + cnt + " " + cntWithCoupon);
            max = Math.max(cntWithCoupon, max);
        }
        System.out.println(max);
    }
}
