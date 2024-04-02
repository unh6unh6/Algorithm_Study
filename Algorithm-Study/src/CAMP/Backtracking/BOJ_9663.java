package CAMP.Backtracking;

import java.io.IOException;
import java.util.Scanner;

//1:30
public class BOJ_9663 {
    static int n;
    static int cnt = 0;

    static int[] pos; // index : 세로 , value : 가로
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pos = new int[n];

        dfs(-1);
        System.out.println(cnt);
    }

    static void dfs(int col) {

        col ++;
        if(col == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {

            pos[col] = i;
            if(canGo(col)) {
                dfs(col);
            }
        }
    }
    static boolean canGo(int col) {
        for(int curCol = 0; curCol < col; curCol ++) {
            if (pos[curCol] == pos[col] || Math.abs(pos[curCol] - pos[col]) == Math.abs(curCol - col))
                return false;
        }
        return true;
    }
}


