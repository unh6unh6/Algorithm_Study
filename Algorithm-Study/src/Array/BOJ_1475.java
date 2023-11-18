package Array;

import java.io.*;
import java.util.Arrays;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] setCnt = {0,0,0,0,0,0,0,0,0,0};
        String[] n = br.readLine().split("");
        for(String s : n) {
            setCnt[Integer.parseInt(s)]++;
        }
        setCnt[6] = (setCnt[6] + setCnt[9]);
        if(setCnt[6] % 2 == 1)
            setCnt[6] = setCnt[6] / 2 +1;
        else
            setCnt[6] /=2;
        setCnt[9] = 0;
        Arrays.sort(setCnt);
        bw.write(String.valueOf(setCnt[setCnt.length-1]));

        
        bw.flush();
        bw.close();
    }
}
