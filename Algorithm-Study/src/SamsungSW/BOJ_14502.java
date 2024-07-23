package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 03:25
public class BOJ_14502 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static LinkedList<Position> savePos = new LinkedList<>();
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
        choose(0);
        System.out.println(max);
    }
    static void choose(int x) {
        if(savePos.size() == 3) {
            searchVirus();
            return;
        }
        for(int i=x; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(visit[i][j] || map[i][j] !=0)
                    continue;
                visit[i][j] = true;
                savePos.offerLast(new Position(i,j));
                choose(i);
                visit[i][j] = false;
                savePos.removeLast();
            }
        }
    }

    static void searchVirus() {
        int[][] cloneMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            cloneMap[i] = map[i].clone();
        }
        cloneMap[savePos.get(0).x][savePos.get(0).y] = 1;
        cloneMap[savePos.get(1).x][savePos.get(1).y] = 1;
        cloneMap[savePos.get(2).x][savePos.get(2).y] = 1;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(cloneMap[i][j] == 2) {
                    bfs(cloneMap, new Position(i,j));
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cloneMap[i][j] == 0)
                    cnt++;
            }
        }
        max = Math.max(max, cnt);
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void bfs(int[][] map, Position pos) {
        LinkedList<Position> queue = new LinkedList<>();
        queue.offerLast(pos);
        while(!queue.isEmpty()) {
            Position popPos = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                Position newPos = new Position(popPos.x+offset[i][0], popPos.y+offset[i][1]);
                if(canGo(newPos, map)) {
                    map[newPos.x][newPos.y] = 2;
                    queue.offerLast(newPos);
                }
            }
        }
    }
    static boolean canGo(Position pos, int[][] map) {
        if(pos.x < 0 || pos.x >=n || pos.y < 0 || pos.y >=m)
            return false;
        if(map[pos.x][pos.y] == 0)
            return true;
        return false;
    }
}

class Position {
    int x,y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
