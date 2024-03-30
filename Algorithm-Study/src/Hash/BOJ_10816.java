package Hash;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] positive = new int[10000002]; // 0 포함
        int[] negative = new int[10000001];
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0)
                positive[num]++;
            else
                negative[-num]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int compare = Integer.parseInt(st.nextToken());
            if(compare >= 0)
                sb.append(String.valueOf(positive[compare])).append(" ");
            else
                sb.append(String.valueOf(negative[-compare])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
