package Deque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        LinkedList<String> deque = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(; n>0; n--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front" :
                    deque.addFirst(st.nextToken());
                    break;
                case "push_back" :
                    deque.addLast(st.nextToken());
                    break;
                case "pop_front" :
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back" :
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.pollLast()).append("\n");
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty" :
                    if(deque.isEmpty()) {
                        sb.append("1\n");
                        break;
                    }
                    sb.append("0\n");
                    break;
                case "front" :
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back" :
                    if(deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
