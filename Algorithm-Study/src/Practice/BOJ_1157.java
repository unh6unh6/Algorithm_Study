package Practice;

import java.io.*;
import java.util.Arrays;

public class BOJ_1157 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();
        int[] alphabetCnt= new int[26];
        Arrays.fill(alphabetCnt,0);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            alphabetCnt[c-65]++;
        }

        int max = 0;
        int maxIndex= -1;
        int maxDuplicate =0;
        for (int i = 0; i < 26; i++) {
            if(alphabetCnt[i]>max) {
                max = alphabetCnt[i];
                maxIndex = i;
            }
            else if(alphabetCnt[i] == max)
                maxDuplicate = max;
        }


        if(max == maxDuplicate)
            bw.write("?");
        else
            bw.write(Character.toString((char)(65+maxIndex)));
        bw.flush();
        bw.close();

    }
}
