package Hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1351 {
    public static long p;
    public static long q;
    public static HashMap<Long, Long> saveRoot = new HashMap<>();

    public static long getRoot(long i) {
        if(!saveRoot.containsKey(i))
            saveRoot.put(i, getRoot(i/p) + getRoot(i/q));
        return saveRoot.get(i);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        saveRoot.put(0L, 1L);
        bw.write(String.valueOf(getRoot(n)));
        bw.flush();
        bw.close();
    }
}
