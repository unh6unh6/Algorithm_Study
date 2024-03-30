package Stack;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] stack = new int[10000];
        int top = -1;
        int n = Integer.parseInt(br.readLine());
        for(; n>0; n--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    stack[++top] = Integer.parseInt(st.nextToken());
                    break;
                case "pop" :
                    if(top == -1)
                        bw.write("-1\n");
                    else
                        bw.write(stack[top--] + "\n");
                    break;
                case "size" :
                    bw.write(String.valueOf(top+1) + "\n");
                    break;
                case "empty" :
                    if(top == -1)
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                    break;
                case "top" :
                    if(top == -1)
                        bw.write("-1\n");
                    else
                        bw.write(String.valueOf(stack[top]) + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
