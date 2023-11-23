package LinkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int removeIndex = k - 1;
        while(true) {
            bw.write(String.valueOf(list.get(removeIndex)));
            list.remove(removeIndex);
            if(list.isEmpty())
                break;
            bw.write(", ");
            removeIndex += (k-1);
            while(removeIndex + 1 > list.size()) {
                removeIndex -= list.size();
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
