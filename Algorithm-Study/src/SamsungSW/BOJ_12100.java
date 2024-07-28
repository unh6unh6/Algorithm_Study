package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19:30
public class BOJ_12100 {
    static int n;
    static int[][] map;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int firstMax = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > firstMax)
                    firstMax = map[i][j];
            }
        }
        max = firstMax;
        recursion(0);
        System.out.println(max);
    }
    static void recursion(int cnt) {
        if(cnt >= 5)
            return;
        for (int dir = 0; dir < 4; dir++) {

            int[][] snapshot = new int[n][n];
            cloneMap(snapshot);

            moveAll(dir);
            recursion(cnt + 1);

            map = snapshot;
        }
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };

    /**
     * offset
     * 0 : up
     * 1 : right
     * 2 : down
     * 3 : left
     */
    static void moveAll(int dir) {
        boolean[][] isCombine = new boolean[n][n];
        if(dir == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] > 0)
                        move(i, j, dir, isCombine);
                }
            }
        }
        else if(dir == 1) {
            for (int i = n-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if(map[j][i] > 0)
                        move(j, i, dir, isCombine);
                }
            }
        }
        else if(dir == 2) {
            for (int i = n-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if(map[i][j] > 0)
                        move(i, j, dir, isCombine);
                }
            }
        }
        else if(dir == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[j][i] > 0)
                        move(j, i, dir, isCombine);
                }
            }
        }
    }
    static void move(int x, int y, int dir, boolean[][] isCombine) {
        //int firstVal = map[x][y];
        while(true) {
            int nextX = x + offset[dir][0];
            int nextY = y + offset[dir][1];

            if(canCombine(nextX, nextY, map[x][y], isCombine)) {
                map[nextX][nextY] *=2;
                map[x][y] = 0;
                if(map[nextX][nextY] > max)
                    max = map[nextX][nextY];
                isCombine[nextX][nextY] = true;
                continue;
            }
            if(!canGo(nextX, nextY))
                break;
            map[nextX][nextY] = map[x][y];
            map[x][y] = 0;
            x = nextX;
            y = nextY;
        }
    }
    static boolean canGo(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && map[x][y] == 0);
    }
    static boolean canCombine(int x, int y, int thisVal, boolean[][] isCombine) {
        return (x >= 0 && x < n && y >= 0 && y < n && map[x][y] == thisVal && !isCombine[x][y]);
    }
    static void cloneMap(int[][] cloneMap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cloneMap[i][j] = map[i][j];
            }
        }
    }
}
