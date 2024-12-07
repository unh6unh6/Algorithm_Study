package softeer.BOJ_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int n, L, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day;
        for (day = 0; day < 2000; day++) {
            if(!dayProcess()) {
                break;
            }
        }
        System.out.println(day);
    }

    static boolean dayProcess() {
        boolean movePeople = false;

        boolean[][] visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j]) {
                    if(bfs(i, j, visit))
                        movePeople = true;
                }
            }
        }

        return movePeople;
    }

    static boolean bfs(int x, int y, boolean[][] visit) {
        List<Pos> group = new ArrayList<>();
        int allPopulation = 0;

        visit[x][y] = true;
        Pos pos = new Pos(x, y);

        group.add(pos);
        allPopulation += map[x][y];

        Queue<Pos> queue = new LinkedList<>();
        queue.offer(pos);

        int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            Pos thisPos = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int newX = thisPos.x + offset[dir][0];
                int newY = thisPos.y + offset[dir][1];
                if(canGo(thisPos, newX, newY, visit)) {
                    visit[newX][newY] = true;
                    Pos newPos = new Pos(newX, newY);
                    queue.offer(newPos);

                    group.add(newPos);
                    allPopulation += (map[newX][newY]);

                }
            }
        }
        return movePeople(group, allPopulation);
    }

    static boolean canGo(Pos oldPos, int x, int y, boolean[][] visit) {
        boolean boundaryFlag = x>=0 && x<n && y>=0 && y<n;
        if(!boundaryFlag)
            return false;

        boolean visitFlag = !visit[x][y];
        int diff = Math.abs(map[oldPos.x][oldPos.y] - map[x][y]);
        boolean populationFlag = diff >= L && diff <= R;
        return visitFlag && populationFlag;
    }
    static boolean movePeople(List<Pos> group, int allPopulation) {
        if(group.size() == 1)
            return false;

        int population = allPopulation / group.size();
        for(Pos pos : group) {
            map[pos.x][pos.y] = population;
        }
        return true;
    }
}

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
