package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] scores = new double[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            if (score > max) {
                max = score;
            }
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = scores[i] / max * 100;
            sum += scores[i];
        }
        System.out.println(sum / n);

    }
}
