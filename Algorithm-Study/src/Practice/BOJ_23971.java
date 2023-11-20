package Practice;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;
        n++;
        m++;
        for (int i = 0; i < h; i+=n) {
            for (int j = 0; j < w; j+=m) {
                cnt ++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
