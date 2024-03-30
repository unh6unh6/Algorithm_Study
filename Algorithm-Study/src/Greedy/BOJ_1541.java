package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        char[] del = new char[100];
        int[] num = new int[100];
        int delI = 0;
        String stringNum = "";
        for(char c : arr) {
            if(c == '+' || c == '-') {
                num[delI] = Integer.parseInt(stringNum);
                del[delI++] = c;
                stringNum = "";
                continue;
            }
            stringNum += c;
        }
        num[delI] = Integer.parseInt(stringNum);

        boolean isMinus = false;
        int result = num[0];
        for (int i = 0; i <= delI; i++) {
            if(!isMinus && del[i] == '-')
                isMinus = true;
            if(isMinus)
                num[i+1] *= (-1);
            result += num[i+1];
        }

        System.out.println(result);
    }
}
