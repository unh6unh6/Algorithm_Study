package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

    static int n;
    static int[][] map;
    static Shark shark;

    static int second = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int nextToken = Integer.parseInt(st.nextToken());
                if (nextToken == 9) {
                    shark = new Shark(i, j);
                    nextToken = 0;
                }
                map[i][j] = nextToken;
            }
        }
        while (findFish()) {

        }
        System.out.println(second);
    }


    static boolean findFish() {
        int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        boolean[][] visit = new boolean[n][n];
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(shark.pos);
        visit[shark.pos.x][shark.pos.y] = true;

        List<Pos> canEatPos = new ArrayList<>();

        while (!queue.isEmpty()) {

            Pos thisPos = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newX = thisPos.x + offset[dir][0];
                int newY = thisPos.y + offset[dir][1];
                if (isBoundaryCorrect(newX, newY, visit) && canGo(newX, newY)) {
                    Pos newPos = new Pos(newX, newY, thisPos.distance);
                    queue.offer(newPos);
                    visit[newX][newY] = true;

                    if (canEat(newX, newY)) {
                        canEatPos.add(newPos);
                    }
                }
            }
            if ((!queue.isEmpty() && thisPos.distance < queue.peek().distance && !canEatPos.isEmpty()) ||
                    (queue.isEmpty() && !canEatPos.isEmpty())) {
                // 가장 위의 물고기는 i(x)가 작아야함
                // 가장 왼쪽의 물고기는 j(y)가 작아야함
                Collections.sort(canEatPos);
                Pos eatPos = canEatPos.get(canEatPos.size() - 1);
                canEatPos.clear();
                map[eatPos.x][eatPos.y] = 0;

                second = eatPos.distance;
                shark.move(eatPos);
                shark.eatFish();
                return true;
            }
        }
        return false;
    }


    static boolean canEat(int x, int y) {
        return map[x][y] > 0 && shark.size > map[x][y];
    }

    static boolean isBoundaryCorrect(int x, int y, boolean[][] visit) {
        return x >= 0 && x < n && y >= 0 && y < n && !visit[x][y];
    }

    static boolean canGo(int x, int y) {
        return shark.size >= map[x][y];
    }
}

class Pos implements Comparable<Pos> {
    int x;
    int y;
    int distance;

    Pos(int x, int y, int oldDistance) {
        this.x = x;
        this.y = y;
        distance = oldDistance + 1;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.x != o.x) {
            return Integer.compare(o.x, this.x);
        }
        return Integer.compare(o.y, this.y);
    }
}

class Shark {
    int size;
    int sizeUpCnt;
    Pos pos;

    Shark(int x, int y) {
        size = 2;
        sizeUpCnt = 2;
        pos = new Pos(x, y, -1);
    }

    void eatFish() {
        sizeUpCnt--;
        if (sizeUpCnt == 0) {
            size++;
            sizeUpCnt = size;
        }
    }

    void move(Pos pos) {
        this.pos = pos;
    }
}
