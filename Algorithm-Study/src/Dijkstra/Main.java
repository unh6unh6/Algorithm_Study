package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] token = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(token[j]);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = 100_000_000;
            }
        }
        int[][] offset = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        pq.offer(new Node(0,0,0));
        dist[0][0] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(dist[node.x][node.y] != node.dist)
                continue;
            for (int i = 0; i < 4; i++) {
                int newX = node.x + offset[i][0];
                int newY = node.y + offset[i][1];
                if(newX < 0 || newX >= n || newY < 0 || newY >=m)
                    continue;
                int distance = 1;
                if(map[newX][newY] == 0)
                    distance = 0;
                if(dist[newX][newY] > dist[node.x][node.y] + distance) {
                    dist[newX][newY] = dist[node.x][node.y] + distance;
                    pq.offer(new Node(newX, newY, dist[newX][newY]));
                }
            }
        }
        System.out.println(dist[n-1][m-1]);
    }
}
class Node implements Comparable<Node>{
    int x,y;
    int dist;
    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.dist, o.dist);
    }
}
