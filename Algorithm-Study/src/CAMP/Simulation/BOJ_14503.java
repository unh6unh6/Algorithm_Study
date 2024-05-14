package CAMP.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 { // 15:30

    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static int[][] room;
    static int cnt = 0;
    static Pos pos;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        pos = new Pos(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            if (room[pos.x][pos.y] == 0) {
                room[pos.x][pos.y] = 2;
                cnt++;
            }


            if (!leftClean()) {
                if (!canGoBack())
                    break;
                pos.x += offset[(pos.dir + 2) % 4][0];
                pos.y += offset[(pos.dir + 2) % 4][1];
                continue;
            }

            pos.dir = (pos.dir + 3) % 4;
            if(canGoStraight()) {
                pos.x += offset[pos.dir][0];
                pos.y += offset[pos.dir][1];
            }

        }
        System.out.println(cnt);
    }
    static boolean canGoBack() {
        int newX = pos.x + offset[(pos.dir + 2) % 4][0];
        int newY = pos.y + offset[(pos.dir + 2) % 4][1];
        return !(room[newX][newY] == 1);
    }
    static boolean leftClean() {
        for (int i = 0; i < 4; i++) {
            int newX = pos.x + offset[i][0];
            int newY = pos.y + offset[i][1];
            if(newX >= 0 && newX < n && newY >= 0 && newY < m && room[newX][newY] == 0)
                return true;
        }
        return false;
    }
    static boolean canGoStraight() {
        int newX = pos.x + offset[pos.dir][0];
        int newY = pos.y + offset[pos.dir][1];
        return (newX >= 0 && newX < n && newY >=0 && newY <m && room[newX][newY] == 0);
    }
}
class Pos{
    int x,y,dir;
    Pos(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
