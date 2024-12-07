package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = line[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= m-8; i++) {
            for (int j = 0; j <= n-8; j++) {
                for (int step = 0; step < 2; step++) {
                    String first = "W";
                    String second = "B";
                    if(step == 1) {
                        first = "B";
                        second = "W";
                    }
                    int cnt = 0;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            String thisColor = board[i + k][j + l];
                            if ((k + l) % 2 == 0 && thisColor.equals(second)) {
                                cnt++;
                            } else if ((k + l) % 2 == 1 && thisColor.equals(first)) {
                                cnt++;
                            }
                        }
                    }
                    if (min > cnt)
                        min = cnt;
                }
            }
        }
        System.out.println(min);
    }
}
