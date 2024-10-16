package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//12:45
public class BOJ_14890 {
    static int n,l;
    static int[][] map1;
    static int[][] map2;
    static boolean[][] slope1;
    static boolean[][] slope2;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map1 = new int[n][n];
        map2 = new int[n][n];
        slope1 = new boolean[n][n];
        slope2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map1[i][j] = num;
                map2[j][i] = num;
            }
        }
        for (int i = 0; i < n; i++) {
            cal(i, map1, slope1);
            cal(i, map2, slope2);
        }
        System.out.println(cnt);
    }
    static void cal(int i, int map[][], boolean slope[][]) {
        for (int j = 0; j < n; j++) {
            if(j == n-1) {
                cnt++;
                return;
            }
            int diff = map[i][j] - map[i][j+1];
            if(Math.abs(diff) > 1)
                return;
            if(diff == 1) {
                if(j+l >= n)
                    return;
                int firstHeight = map[i][j+1];
                for (int k = 0; k < l; k++) {
                    if(slope[i][j+1+k] || firstHeight != map[i][j+1+k])
                        return;
                    slope[i][j+1+k] = true;
                }
            }
            else if(diff == -1) {
                if(j-l+1 < 0)
                    return;
                int firstHeight = map[i][j];
                for (int k = 0; k < l; k++) {
                    if(slope[i][j-k] || firstHeight != map[i][j-k])
                        return;
                    slope[i][j-k] = true;
                }
            }
        }
    }
}
