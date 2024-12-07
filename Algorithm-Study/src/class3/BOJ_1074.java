package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int n, r, c;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int originSize = (int) Math.pow(2, n);

        solve(originSize);
    }
    static void solve(int size) {
        int boundary = size / 2 - 1;
        int newSize = size / 2;

        if (size == 1) {
            System.out.println(count);
            return;
        }

        if (r <= boundary && c <= boundary) { // area 1

        } else if (r <= boundary && c > boundary) { // area2
            c -= newSize;
            count += (newSize * newSize);
        } else if (r > boundary && c <= boundary) {
            r -= newSize;
            count += (newSize * newSize * 2);
        } else {
            c -= newSize;
            r -= newSize;
            count += (newSize * newSize * 3);
        }

        solve(newSize);
    }
}
