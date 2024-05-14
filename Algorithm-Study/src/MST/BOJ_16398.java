package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16398 {
    static int n;
    static int[][] cost;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));
        long result = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visit[edge.node])
                continue;

            result += edge.cost;
            visit[edge.node] = true;

            for (int i = 0; i < n; i++) {
                if (!visit[i])
                    pq.offer(new Edge(i, cost[edge.node][i]));
            }
        }
        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {
    int node, cost;
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
