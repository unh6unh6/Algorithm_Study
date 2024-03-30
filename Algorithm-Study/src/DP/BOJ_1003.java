package DP;

import java.io.*;

public class BOJ_1003 {

    public static int[] fibo0 = new int[50];
    public static int[] fibo1 = new int[50];
    public static int cntFibo0(int num) {
        if(fibo0[num] != 0 || num == 1) {
            return fibo0[num];
        }
        fibo0[num] = cntFibo0(num - 1) + cntFibo0(num - 2);
        return fibo0[num];
    }
    public static int cntFibo1(int num) {
        if(fibo1[num] != 0 || num == 0) {
            return fibo1[num];
        }
        fibo1[num] = cntFibo1(num - 1) + cntFibo1(num - 2);
        return fibo1[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        fibo0[0] = 1;
        fibo0[1] = 0;

        fibo1[0] = 0;
        fibo1[1] = 1;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(cntFibo0(num)).append(" ");
            sb.append(cntFibo1(num)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
