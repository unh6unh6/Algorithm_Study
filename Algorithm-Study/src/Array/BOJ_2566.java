package Array;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int repI = 0, repJ = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int token = Integer.parseInt(st.nextToken());
                if(token > max) {
                    max = token;
                    repI = i;
                    repJ = j;
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(repI+1) + " " + String.valueOf(repJ+1));
        bw.flush();
        bw.close();
    }
}
