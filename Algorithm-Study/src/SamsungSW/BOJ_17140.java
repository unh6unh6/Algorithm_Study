package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

//09:05
public class BOJ_17140 {
    static int r, c, k;
    static int[][] map = new int[100][100];
    static int time = 0;
    static LinkedList<Entry> memo = new LinkedList<>();
    static int row = 3;
    static int col = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) -1;
        c = Integer.parseInt(st.nextToken()) -1;
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true) {
            if(time > 100) {
                time = -1;
                break;
            }
            if(map[r][c] == k)
                break;
            if(row >= col) {
                calR();
            }
            else {
                calC();
            }

            time++;
        }
        System.out.println(time);
    }
    static void calR() {
        int newCol = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(map[i][j] == 0)
                    continue;
                Entry entry = findKey(map[i][j]);
                if(entry != null) {
                    entry.value = entry.value + 1;
                }
                else {
                    memo.offerLast(new Entry(map[i][j]));
                }
            }
            int memoSize = memo.size();
            newCol = Math.max(newCol, memoSize * 2);
            Collections.sort(memo);
            for (int j = 0; j < memoSize * 2; j+=2) {
                Entry entry = memo.removeFirst();
                map[i][j] = entry.key;
                map[i][j+1] = entry.value;
            }
            if(col > memoSize*2) {
                for (int j = memoSize*2; j < col; j++) {
                    map[i][j] = 0;
                }
            }
            memo.clear();
        }
        col = newCol;
    }
    static void calC() {
        int newRow = row;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(map[j][i] == 0)
                    continue;
                Entry entry = findKey(map[j][i]);
                if(entry != null) {
                    entry.value = entry.value + 1;
                }
                else {
                    memo.offerLast(new Entry(map[j][i]));
                }
            }
            int memoSize = memo.size();
            newRow = Math.max(newRow, memoSize * 2);
            Collections.sort(memo);
            for (int j = 0; j < memoSize * 2; j+=2) {
                Entry entry = memo.removeFirst();
                map[j][i] = entry.key;
                map[j+1][i] = entry.value;
            }
            if(row > memoSize*2) {
                for (int j = memoSize*2; j < row; j++) {
                    map[j][i] = 0;
                }
            }
            memo.clear();
        }
        row = newRow;
    }
    static Entry findKey(int key) {
        for(Entry e : memo) {
            if(e.key == key)
                return e;
        }
        return null;
    }

}

class Entry implements Comparable<Entry> {
    int key, value;
    public Entry(int key) {
        this.key = key;
        this.value = 1;
    }

    @Override
    public int compareTo(Entry o) {
        if(this.value > o.value)
            return 1;
        else if(this.value < o.value)
            return -1;
        else if(this.key > o.key)
            return 1;
        else if(this.key < o.key)
            return -1;
        return 0;
    }
}
