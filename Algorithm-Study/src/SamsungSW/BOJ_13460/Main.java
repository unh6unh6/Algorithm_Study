package SamsungSW.BOJ_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 03:25
public class Main {
    static int n,m;
    static char[][] map;
    static Pos redPos, bluePos, holePos;
    static int min = 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
                if(line[j] == 'R')
                    redPos = new Pos(i, j);
                else if(line[j] == 'B')
                    bluePos = new Pos(i,j);
                else if(line[j] == 'O')
                    holePos = new Pos(i,j);
            }
        }
        recursion(0, -1);
        if(min > 10)
            System.out.println("-1");
        else
            System.out.println(min);
    }
    static void recursion(int cnt, int prevDir) {
        if(cnt > 10 || holePos.isSame(bluePos))
            return;
        if(holePos.isSame(redPos)) {
            if(cnt < min)
                min = cnt;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(prevDir == i)
                continue;

            char[][] snapshotMap = new char[n][m];
            cloneMap(snapshotMap);
            Pos snapshotRed = redPos;
            Pos snapshotBlue = bluePos;
            Pos snapshotHole = holePos;

            move(i);
            recursion(cnt+1, i);

            map = snapshotMap;
            redPos = snapshotRed;
            bluePos = snapshotBlue;
            holePos = snapshotHole;

        }
    }
    static int[][] offset = { {0,-1}, {0,1}, {-1,0}, {1,0}};
    static void move(int dir) {
        if(isRedFirst(dir)) {
            redPos = movePos(dir, redPos);
            map[redPos.x][redPos.y] = 'R';
            bluePos = movePos(dir, bluePos);
            map[bluePos.x][bluePos.y] = 'B';
        }
        else {
            bluePos = movePos(dir, bluePos);
            map[bluePos.x][bluePos.y] = 'B';
            redPos = movePos(dir, redPos);
            map[redPos.x][redPos.y] = 'R';
        }
    }
    static Pos movePos(int dir, Pos pos) {
        while(true) {
            map[pos.x][pos.y] = '.';

            if(holePos.isSame(pos))
                break;
            int newX = pos.x + offset[dir][0];
            int newY = pos.y + offset[dir][1];
            if(!canGo(newX, newY))
                break;
            pos = new Pos(newX, newY);
        }
        return pos;
    }
    static boolean canGo(int x, int y) {
        return (map[x][y] == '.' || (holePos.isSame(new Pos(x,y))));
    }
    static boolean isRedFirst(int dir) {
        int redComp = redPos.x * offset[dir][0] + redPos.y * offset[dir][1];
        int blueComp = bluePos.x * offset[dir][0] + bluePos.y * offset[dir][1];
        return (redComp > blueComp);
    }

    static void cloneMap(char[][] cloneMap) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cloneMap[i][j] = map[i][j];
            }
        }
    }
}
class Pos {
    int x,y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isSame(Pos comparePos) {
        return (this.x == comparePos.x && this.y == comparePos.y);
    }
}
