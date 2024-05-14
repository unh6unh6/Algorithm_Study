package CAMP.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main { // 14:30

    static int n;
    static int[][] arr;

    static int sharkSize = 2;
    static int toSizeUp = 0;
    /**
     * if(toSizeUp == sharkSize) sharkSize++, toSizeUp = 0
     **/
    static int time = 0;
    static LinkedList<Position> canEat = new LinkedList<>();
    static Position sharkPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    sharkPosition = new Position(i, j);
                    arr[i][j] = 0;
                }
            }
        }
        while (true) {
            canEat.clear();
            if (callMom())
                break;
            Position next = findNearFish();
            if(next == null)
                break;
            arr[next.x][next.y] = 0;
            time += nearDistance; // 수정
            nearDistance = Integer.MAX_VALUE;
            sharkPosition.x = next.x;
            sharkPosition.y = next.y;
            toSizeUp++;
            if (toSizeUp == sharkSize) {
                sharkSize++;
                toSizeUp = 0;
            }
        }
        System.out.println(time);

    }

    static int nearDistance = Integer.MAX_VALUE;

    static Position findNearFish() {
        Position nearFish = null;
        for (Position fish : canEat) {
            int distance = bfs(fish, sharkPosition);
            if(distance == -1)
                continue;
            if (nearDistance > distance) {
                nearDistance = distance;
                nearFish = fish;
            }
        }
        return nearFish;
    }

    static int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int bfs(Position target, Position shark) {
        int distance = 0;
        if (shark.x == target.x && shark.y == target.y)
            return distance;
        LinkedList<Position> queue = new LinkedList<>();
        queue.offerLast(shark);
        int[][] flag = new int[n][n];
        while (true) {
            boolean block = true;
            distance++;
            Position newPos = queue.removeFirst();
            for (int dir = 0; dir < 4; dir++) {
                int newX = newPos.x + offset[dir][0];
                int newY = newPos.y + offset[dir][1];
                if (canGo(newX, newY)) {
                    block = false;
                    queue.offerLast(new Position(newX, newY));
                    flag[newX][newY] = flag[newPos.x][newPos.y] + 1;
                    if (newX == target.x && newY == target.y)
                        return flag[newX][newY];
                }
            }
            if(block)
                return -1;
        }
    }

    static boolean canGo(int x, int y) {
        return ( x >=0 && x<n && y>=0 && y<n && arr[x][y] <= sharkSize );
    }
    static boolean callMom() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0 && arr[i][j] < sharkSize)
                   canEat.offer(new Position(i,j));
            }
        }
        return canEat.isEmpty();
    }
}

class Position {
    int x,y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
