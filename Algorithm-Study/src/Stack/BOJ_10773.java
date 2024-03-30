package Stack;

import java.io.*;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        int[] stack = new int[1000000];
        int top = -1;
        for(; k>0; k--) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0 && top > -1)
                top --;
            else if (n != 0)
                stack[++top] = n;
        }

        int sum = 0;
        for(int i=0; i<=top; i++)
            sum += stack[i];
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
