package Deque.sibal;

import java.io.*;
import java.util.*;

public class BOJ_10816_deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            list.offerLast(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> dequeLow = list;
        Deque<Integer> dequeHigh = new LinkedList<>();

        int boundaryNum = 10000001;
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            int compare = Integer.parseInt(st.nextToken());
            if(compare < boundaryNum) { // dequeLow에서 비교
                while(!dequeLow.isEmpty() && compare <= dequeLow.peekLast()) {
                    if(compare == dequeLow.peekLast())
                        cnt ++;
                    dequeHigh.offerFirst(dequeLow.pollLast());
                }
            }
            else if(compare >= boundaryNum) { // dequeHigh에서 비교
                while(!dequeHigh.isEmpty() && compare >= dequeHigh.peekFirst()) {
                    if(compare == dequeHigh.peekFirst())
                        cnt ++;
                    dequeLow.offerLast(dequeHigh.pollFirst());
                }
            }
            sb.append(String.valueOf(cnt)).append(" ");
            boundaryNum = compare;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
