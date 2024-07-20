package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20:50
public class BOJ_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long result = n;
        for(int i=0; i<n; i++) {
            a[i] -= b;
            if(a[i] > 0) {
                if(a[i] % c > 0)
                    result += (a[i]/c+1);
                else
                    result += a[i]/c;
            }
        }
        System.out.println(result);

    }
}
