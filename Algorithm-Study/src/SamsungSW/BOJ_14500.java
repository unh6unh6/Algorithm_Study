package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11:05
public class BOJ_14500 {
    static int n,m;
    static int[][] map;
    static boolean[][] visit;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(1, i, j, map[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(max);
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void dfs(int cnt, int x, int y, int sum) {
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + offset[i][0];
            int newY = y + offset[i][1];
            if(canGo(newX, newY)) {
                sum += map[newX][newY];
                visit[newX][newY] = true;
                if(cnt == 2)
                    dfs(cnt+1, x, y, sum);
                dfs(cnt+1, newX, newY, sum);
                sum -= map[newX][newY];
                visit[newX][newY] = false;
            }
        }
    }
    static boolean canGo(int x, int y) {
        return (x >= 0 && x<n && y>=0 && y<m && !visit[x][y]);
    }
}
