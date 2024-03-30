package Deque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {

    public static int cnt = 0;
    public static LinkedList<Integer> deque = new LinkedList<>();
    public static void shiftLeft() {
        deque.offerLast(deque.pollFirst());
        cnt++;
    }
    public static void shiftRight() {
        deque.offerFirst(deque.pollLast());
        cnt++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
            deque.offerLast(i+1);

        st = new StringTokenizer(br.readLine());
        for(; m>0; m--) {
            int findNum = Integer.parseInt(st.nextToken());
            while(true) {
                if (deque.peekFirst() == findNum) {
                    deque.pollFirst();
                    break;
                }
                else if ( (deque.size() - 1) / 2 >= deque.indexOf(findNum))
                    shiftLeft();
                else
                    shiftRight();
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
