package CAMP.Bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {

    static int maxCnt = 0; // 안전한 영역의 개수
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        for (int i = max - 1; i >= 0; i--) {
            boolean[][] newArr = new boolean[n][n];
            setArr(newArr, i);
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(newArr[j][k]) {
                        cnt ++;
                        newArr[j][k] = false;
                        recursion(newArr, j, k);
                    }
                }
            }
            maxCnt = cnt > maxCnt ? cnt : maxCnt;
        }
        System.out.println(maxCnt);
    }

    static void setArr(boolean[][] boolArr, int rainHeight) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] > rainHeight)
                    boolArr[i][j] = true;
            }
        }
    }
    static int offset[][] = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void recursion(boolean[][] area, int x, int y) {
        for(int dir = 0; dir < 4; dir++) {
            int newX = x+offset[dir][0];
            int newY = y+offset[dir][1];
            if(canMove(area, newX, newY)) {
                area[newX][newY] = false;
                recursion(area, newX, newY);
            }
        }
    }
    static boolean canMove(boolean[][] area, int x, int y) {
        return (x<n && x>=0 && y<n && y>=0 && area[x][y]);
    }
}
