package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 09:05
public class BOJ_14889 {
    static int[][] arr;
    static int n;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        System.out.println(min);
    }
    static void combi(int index, int cnt) {
        if(cnt == n/2) {
            cal();
            return;
        }
        for(int i=index; i<n; i++) {
            visit[i] = true;
            combi(i + 1, cnt + 1);
            visit[i] = false;
        }
    }

    static void cal() {
        int team1 = 0;
        int team2 = 0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i] == visit[j] && visit[i])
                    team1 += arr[i][j];
                else if(visit[i] == visit[j] && !visit[i])
                    team2 += arr[i][j];
            }
        }
        min = Math.min(min, Math.abs(team1-team2));
    }
}
