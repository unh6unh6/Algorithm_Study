package softeer.BOJ_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        map[0][0] = 0;
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, 1));
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if(pos.x == n-1 && pos.y == m-1) {
                System.out.println(pos.dist);
                break;
            }
            for (int dir = 0; dir < 4; dir++) {
                Pos nextPos = new Pos(pos.x + offset[dir][0], pos.y + offset[dir][1], pos.dist + 1);
                if (canGo(nextPos.x, nextPos.y)) {
                    map[nextPos.x][nextPos.y] = 0;
                    queue.offer(nextPos);
                }
            }
        }
    }


    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 1;
    }
}

class Pos {
    int x, y, dist;

    Pos(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}