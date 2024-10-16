package SamsungSW.BOJ_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//07:15
public class Main {
    static int n, m;
    static int[][] map;
    static LinkedList<Pos> cctv = new LinkedList<>();
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5)
                    cctv.offer(new Pos(i,j));
            }
        }
        recursion();
        System.out.println(result);
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void recursion() {
        if(cctv.isEmpty()) {
            result = Math.min(result, count());
            return;
        }
        Pos pos = cctv.removeFirst();
        int type = map[pos.x][pos.y];
        for (int dir = 0; dir < 4; dir++) {
            int[][] snapshot = cloneMap();
            move(dir, type, pos);
            recursion();
            map = snapshot;
        }
        cctv.offerFirst(pos);
    }
    static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    static void move(int dir, int type, Pos pos) {
        if(type == 1) {
            moveStraight(dir, pos.x, pos.y);
        }
        else if(type == 2) {
            int dir2 = (dir + 2) % 4;
            moveStraight(dir, pos.x, pos.y);
            moveStraight(dir2, pos.x, pos.y);
        }
        else if(type == 3) {
            int dir2 = (dir + 1) % 4;
            moveStraight(dir, pos.x, pos.y);
            moveStraight(dir2, pos.x, pos.y);
        }
        else if(type == 4) {
            int dir2 = (dir + 1) % 4;
            int dir3 = (dir + 2) % 4;
            moveStraight(dir, pos.x, pos.y);
            moveStraight(dir2, pos.x, pos.y);
            moveStraight(dir3, pos.x, pos.y);
        }
        else if(type == 5) {
            moveStraight(0, pos.x, pos.y);
            moveStraight(1, pos.x, pos.y);
            moveStraight(2, pos.x, pos.y);
            moveStraight(3, pos.x, pos.y);
        }
    }
    static void moveStraight(int dir, int x, int y) {
        int newX = x + offset[dir][0];
        int newY = y + offset[dir][1];
        if(!canGo(newX, newY))
            return;
        if(map[newX][newY] == 0)
            map[newX][newY] = 9;
        moveStraight(dir, newX, newY);
    }
    static boolean canGo(int x, int y) {
        return (x >=0 && x<n && y>=0 && y<m && map[x][y] != 6);
    }

    static int[][] cloneMap() {
        int[][] newMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }
}

class Pos {
    int x,y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
