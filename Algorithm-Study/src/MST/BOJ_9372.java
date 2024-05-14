package MST;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9372 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                br.readLine();
            }
            System.out.println(n-1);
        }
    }
}
