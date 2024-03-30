package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstRing = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int otherRing = Integer.parseInt(st.nextToken());
            int div;
            if(firstRing > otherRing)
                div = gcd(firstRing, otherRing);
            else
                div = gcd(otherRing, firstRing);
            System.out.println(firstRing/div + "/" + otherRing/div);
        }
    }

    static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        return (gcd(b, a % b));
    }
}
