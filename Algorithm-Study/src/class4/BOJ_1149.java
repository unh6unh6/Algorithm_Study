package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int n;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        for (int houseNum = 0; houseNum < n; houseNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[houseNum][0] = Integer.parseInt(st.nextToken());
            cost[houseNum][1] = Integer.parseInt(st.nextToken());
            cost[houseNum][2] = Integer.parseInt(st.nextToken());
        }

        int[][] paint = new int[n][3];

        paint[0][0] = cost[0][0];
        paint[0][1] = cost[0][1];
        paint[0][2] = cost[0][2];

        for (int houseNum = 1; houseNum < n; houseNum++) {

            paint[houseNum][0] = cost[houseNum][0] + Math.min(paint[houseNum-1][1], paint[houseNum-1][2]);
            paint[houseNum][1] = cost[houseNum][1] + Math.min(paint[houseNum-1][0], paint[houseNum-1][2]);
            paint[houseNum][2] = cost[houseNum][2] + Math.min(paint[houseNum-1][0], paint[houseNum-1][1]);

        }

        int result = Math.min(paint[n-1][0], paint[n-1][1]);
        result = Math.min(result, paint[n-1][2]);

        System.out.println(result);
    }

}
