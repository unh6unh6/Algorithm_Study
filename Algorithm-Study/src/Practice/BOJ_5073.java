package Practice;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5073 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(s);
            int[] side = new int[3];
            side[0] = Integer.parseInt(st.nextToken());
            side[1] = Integer.parseInt(st.nextToken());
            side[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(side);
            if(side[0] + side[1] <= side[2]) {
                bw.write("Invalid");
                bw.newLine();
                continue;
            }
            if(side[0] == side[1] || side[1] == side[2]) {
                if(side[0] == side[1] && side[1] == side[2]) {
                    bw.write("Equilateral");
                    bw.newLine();
                    continue;
                }
                bw.write("Isosceles");
                bw.newLine();
                continue;
            }
            bw.write("Scalene");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
