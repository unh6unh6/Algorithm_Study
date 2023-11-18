package Array;

import java.io.*;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a,b,c;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        String multAll[] = String.valueOf(a*b*c).split("");
        for (int i = 0; i <= 9 ; i++) {
            int cnt = 0;
            for( String s : multAll) {
                int num = Integer.parseInt(s);
                if(num == i)
                    cnt ++;
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
