package CAMP.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {

    static boolean[] flag = new boolean[1000];
    static char[][] arr;
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static int max = 0;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        flag[arr[0][0]] = true;
        dfs(new Pos(0,0), 1);

        System.out.println(max);

    }
    static void dfs(Pos pos, int cnt) {
        for (int dir = 0; dir < 4; dir++) {
            int newX = pos.x + offset[dir][0];
            int newY = pos.y + offset[dir][1];
            if(canGo(newX, newY)) {
                flag[arr[newX][newY]] = true;
                Pos newPos = new Pos(newX, newY);
                dfs(newPos, cnt + 1);
                flag[arr[newX][newY]] = false;

            }
        }
        max = Math.max(cnt, max);
    }
    static boolean canGo(int x, int y) {
        return (x>=0 && x<r && y>=0 && y<c && !flag[arr[x][y]]);
    }
}
class Pos {
    int x;
    int y;
    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
