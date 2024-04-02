package CAMP.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1:47 ~ 2:11
public class BOJ_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 가로 (j)
            int n = Integer.parseInt(st.nextToken()); // 세로 (i)
            int k = Integer.parseInt(st.nextToken()); // 배추 갯수
            boolean[][] ground = new boolean[m][n];
            while(k-- > 0 ) {
                st = new StringTokenizer(br.readLine());
                ground[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(ground[i][j]) {
                        cnt ++;
                        ground[i][j] = false;
                        recursion(ground, i, j, m, n);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void recursion(boolean[][] ground, int x, int y, int m, int n) {
        for(int dir = 0; dir < 4; dir ++) {
            int newX = x + offset[dir][0];
            int newY = y + offset[dir][1];
            if(canMove(ground, newX, newY, m, n)) {
                ground[newX][newY] = false;
                recursion(ground, newX, newY, m, n);
            }
        }
    }
    static boolean canMove(boolean[][] ground, int x, int y, int m ,int n) {
        return (x < m && x>=0 && y < n && y>=0 && ground[x][y]);
    }
}
