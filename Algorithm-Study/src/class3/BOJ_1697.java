package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        find(n, k);
    }

    static void find(int n, int k) {
        Queue<PosAndSec> queue = new LinkedList<>();
        boolean[] visit = new boolean[100_001];
        visit[n] = true;
        queue.offer(new PosAndSec(n, 0));

        while(!queue.isEmpty()) {
            PosAndSec posAndSec = queue.poll();
            if(posAndSec.n == k) {
                System.out.println(posAndSec.sec);
                break;
            }

            for (int i = 0; i < 3; i++) {
                int nextPos = posAndSec.n;
                if (i == 0) {
                    nextPos++;
                } else if (i == 1) {
                    nextPos--;
                } else {
                    nextPos *= 2;
                }
                if (canGo(nextPos, visit)) {
                    visit[nextPos] = true;
                    queue.offer(new PosAndSec(nextPos, posAndSec.sec + 1));
                }
            }
        }
    }
    static boolean canGo(int n, boolean[] visit) {
        return n >= 0 && n <= 100_000 && !visit[n];
    }
}

class PosAndSec {
    int n;
    int sec;
    PosAndSec(int n, int sec){
        this.n = n;
        this.sec = sec;
    }
}
