package Hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_hashmap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(; n>0; n--) {
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
                continue;
            }
            hashMap.put(num, 1);
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(; m>0; m--) {
            int compare = Integer.parseInt(st.nextToken());
            if(hashMap.containsKey(compare))
                sb.append(hashMap.get(compare)).append(" ");
            else
                sb.append("0 ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
