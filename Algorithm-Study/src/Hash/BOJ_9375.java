package Hash;

import java.io.*;
import java.util.*;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(; testCase>0; testCase--) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> wear = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String clothes = st.nextToken();
                if(wear.containsKey(clothes)) {
                    wear.put(clothes, wear.get(clothes) + 1);
                    continue;
                }
                wear.put(clothes, 1);
            }
            int result = 1;
            for(int val : wear.values())
                result *= (val + 1);
            bw.write(String.valueOf(result - 1));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
