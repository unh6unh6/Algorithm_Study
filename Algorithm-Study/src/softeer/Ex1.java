import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1 {
    static int[][] map;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int areaCnt = 0;
        List<Integer> area = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    areaCnt++;
                    dfs(i, j);
                    area.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(area);
        System.out.println(areaCnt);
        for (int num : area) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void dfs(int i, int j) {
        int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        map[i][j] = 0;
        cnt++;
        for (int dir = 0; dir < 4; dir++) {
            int nextX = i + offset[dir][0];
            int nextY = j + offset[dir][1];
            if (canGo(nextX, nextY)) {
                dfs(nextX, nextY);
            }
        }
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && map[x][y] == 1;
    }
}
