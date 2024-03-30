package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    static int e = 1;
    static int s = 1;
    static int m = 1;
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        while(e1 != e || s1 != s || m1 != m) {
            next();
        }
        System.out.println(result);
    }

    static void next() {
        e++;
        s++;
        m++;

        if(e > 15)
            e = 1;
        if(s > 28)
            s = 1;
        if(m > 19)
            m = 1;
        result++;
    }
}
