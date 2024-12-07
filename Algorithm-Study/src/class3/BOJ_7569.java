package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int m, n, h;
    // m n -> y x
    static int[][][] box;

    static List<Pos> ripenTomatoPos = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];



        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    box[i][j][k] = tomato;

                    if(tomato == 1) {
                        ripenTomatoPos.add(new Pos(i, j, k));
                    }
                }
            }
        }
        int day = -1;
        while(true) {
            day ++;
            if(!dayProcess()) {
                if(!scanBox()) {
                    System.out.println("-1");
                    return;
                }
                System.out.println(day);
                return;
            }
        }
    }
    static boolean scanBox() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(box[i][j][k] == 0)
                        return false;
                }
            }
        }
        return true;
    }

    static boolean dayProcess() {
        int[][] offset = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        List<Pos> newRipenTomatoPos = new ArrayList<>();
        for(Pos tomatoPos : ripenTomatoPos) {
            for (int dir = 0; dir < 6; dir++) {
                int newZ = tomatoPos.z + offset[dir][0];
                int newX = tomatoPos.x + offset[dir][1];
                int newY = tomatoPos.y + offset[dir][2];
                if(canGo(newZ, newX, newY)) {
                    box[newZ][newX][newY] = 1;
                    newRipenTomatoPos.add(new Pos(newZ, newX, newY));
                }
            }
        }
        if(newRipenTomatoPos.isEmpty()) {
            return false;
        }
        ripenTomatoPos = newRipenTomatoPos;
        return true;
    }

    static boolean canGo(int z, int x, int y) {
        return z >= 0 && x >= 0 && y>=0 && z < h && x < n && y < m
                && box[z][x][y] == 0;
    }
}

class Pos {
    int z, x, y;
    Pos(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
