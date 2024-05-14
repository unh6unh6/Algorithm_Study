package Dijkstra.BOJ_1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static int n, m, x;
    static int[] maxArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        ArrayList<Node>[] come = new ArrayList[n];
        ArrayList<Node>[] comeback = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            come[i] = new ArrayList<>();
            comeback[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            come[e].add(new Node(s,t));
            comeback[s].add(new Node(e,t));
        }
        maxArray = new int[n];
        sumArray(dijkstra(come));
        sumArray(dijkstra(comeback));
        int max = 0;
        for (int num : maxArray)
            max = Math.max(num, max);
        System.out.println(max);

    }
    static void sumArray(int[] array) {
        for (int i = 0; i < n; i++) {
            maxArray[i] += array[i];
        }
    }
    static int[] dijkstra(ArrayList<Node>[] graph) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = 100_000_000;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        dist[x] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(dist[node.index] != node.dist)
                continue;
            for(Node next : graph[node.index]) {
                if(dist[next.index] > dist[node.index] + next.dist) {
                    dist[next.index] = dist[node.index] + next.dist;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int index;
    int dist;
    Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}
