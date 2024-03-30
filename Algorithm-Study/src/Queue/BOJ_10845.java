package Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String back = null;
        for(; n>0; n--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    back = st.nextToken();
                    q.add(back);
                    break;
                case "pop" :
                    if(!q.isEmpty())
                        bw.write(q.poll() + "\n");
                    else
                        bw.write("-1\n");
                    break;
                case "size" :
                    bw.write(String.valueOf(q.size()) + "\n");
                    break;
                case "empty" :
                    if(q.isEmpty())
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "front" :
                    if(!q.isEmpty())
                        bw.write(q.peek() + "\n");
                    else
                        bw.write("-1\n");
                    break;
                case "back" :
                    if(!q.isEmpty())
                        bw.write(back + "\n");
                    else
                        bw.write("-1\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
