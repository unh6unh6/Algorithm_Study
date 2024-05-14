package MST.BOJ_13418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_13418 {

    static int[] parent;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 건물 개수
        m = Integer.parseInt(st.nextToken()); // 도로 개수

        parent = new int[n+1];

        Edge[] edges = new Edge[m+1];
        for (int i = 0; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node1, node2, cost);
        }
        Arrays.sort(edges);
        setParent();
        int max = (int) Math.pow(kruskal(edges), 2);

        Arrays.sort(edges, Collections.reverseOrder());
        setParent();
        int min = (int) Math.pow(kruskal(edges), 2);

        System.out.println(max - min);
    }
    static int kruskal(Edge[] edges) {
        int index = 0;
        int cnt = 0;
        int tired = 0;
        while(cnt < n) {
            Edge edge = edges[index++];
            if(union(edge.node1, edge.node2)) {
                cnt++;
                if(edge.cost == 0)
                    tired ++;
            }
        }
        return tired;
    }
    static int find(int node1) {
        if(parent[node1] == node1)
            return node1;
        return parent[node1] = find(parent[node1]);
    }
    static Boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if(parent1 != parent2) {
            parent[parent1] = parent2;
            return true;
        }
        return false;
    }
    static void setParent() {
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
    }
}

class Edge implements Comparable<Edge> {
    int node1, node2, cost;
    Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
