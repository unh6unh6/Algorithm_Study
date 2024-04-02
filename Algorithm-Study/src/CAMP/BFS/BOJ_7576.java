package CAMP.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 12:45
public class BOJ_7576 {

    static int[][] box;
    static int cnt = 0; // 안익은 토마토 갯수
    static LinkedList<Position> queue = new LinkedList();
    static int m;
    static int n;
    static int day = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        for (int i = 0; i < n; i++) {  // n,i,x
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 0)
                    cnt++;
                else if(box[i][j] == 1) {
                    queue.offerLast(new Position(i,j));
                }
            }
        }
        queue.offerLast(new Position(-1,-1));
        bfs();
        if(cnt > 0)
            System.out.println(-1);
        else
            System.out.println(day);
    }
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    static void bfs() {
        while(!queue.isEmpty()) {

            Position next = queue.removeFirst();
            if(next.x == -1 && next.y == -1)  {
                if(queue.isEmpty())
                    return;
                queue.offerLast(new Position(-1, -1));
                day ++;
                continue;
            }
            for(int dir = 0; dir < 4; dir++) {
                Position newPos = new Position(next.x + offset[dir][0], next.y + offset[dir][1]);
                if(canGo(newPos)) {
                    queue.offerLast(newPos);
                    cnt -- ;
                    box[newPos.x][newPos.y] = 1;
                }
            }
        }
    }

    static boolean canGo(Position pos) {
        return (pos.x >=0 && pos.x < n && pos.y >=0 && pos.y < m && box[pos.x][pos.y] == 0);
    }

//    static void print() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(box[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("#############");
//    }
}

class Position implements Cloneable{
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


