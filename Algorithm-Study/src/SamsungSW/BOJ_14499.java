package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 04:05
public class BOJ_14499 {
    static int[][] map;
    static int[][] offset = { {100,100}, {1,0}, {-1,0}, {0,-1}, {0, 1} };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice(y,x);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            int command =  Integer.parseInt(st.nextToken());
            int newX = dice.x + offset[command][0];
            int newY = dice.y + offset[command][1];
            if(canGo(n, m, newX, newY)) {
                dice.move(command);
                dice.x = newX;
                dice.y = newY;
                if(map[newY][newX] == 0)
                    map[newY][newX] = dice.down;
                else {
                    dice.down = map[newY][newX];
                    map[newY][newX] = 0;
                }
                System.out.println(dice.up);
            }
        }
    }
    static boolean canGo(int n, int m, int x, int y) {
        return (x >=0 && x<= m-1 && y>=0 && y<= n-1);
    }
}
class Dice {
    int up, down, front, back, left, right;
    int x, y;
    public Dice(int x, int y) {
        up = 0;
        down = 0;
        front = 0;
        back = 0;
        left = 0;
        right = 0;
        this.x = x;
        this.y = y;
    }

    void move(int command) {
        if(command == 1) {
            int tempRight = right;
            int tempLeft = left;
            right = up;
            left = down;
            down = tempRight;
            up = tempLeft;
        }
        else if(command == 2) {
            int tempRight = right;
            int tempLeft = left;
            right = down;
            left = up;
            down = tempLeft;
            up = tempRight;
        }
        else if(command == 3) {
            int tempBack = back;
            int tempFront = front;
            back = up;
            front = down;
            down = tempBack;
            up = tempFront;
        }
        else if(command == 4) {
            int tempBack = back;
            int tempFront = front;
            back = down;
            front = up;
            down = tempFront;
            up = tempBack;
        }
    }
}
