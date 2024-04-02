package CAMP.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 03:00
public class BOJ_1260 {
    static int n;
    static int m;
    static int v;
    static Node[] saveNode;
    static boolean[] dfsFlag;
    static boolean[] bfsFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        saveNode = new Node[n+2];
        dfsFlag = new boolean[n+2];
        bfsFlag = new boolean[n+2];

        for (int i = 1; i <= n; i++) {
            saveNode[i] = new Node(i);
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            Node node1 = saveNode[Integer.parseInt(st.nextToken())];
            Node node2 = saveNode[Integer.parseInt(st.nextToken())];
            node1.connectNode.offer(node2);
            node2.connectNode.offer(node1);
        }
        for(int i = 1; i<=n; i++) {
            Node tempNode = saveNode[i];
            Collections.sort(tempNode.connectNode);
        }

        Node startNode = saveNode[v];
        dfs(startNode);
        System.out.println();
        bfs(startNode,n);
    }

    static void dfs(Node node) {
        System.out.print(node.name + " ");
        dfsFlag[node.name] = true;
        for(Node nextNode : node.connectNode) {
            if(!dfsFlag[nextNode.name]) {
                dfs(nextNode);
            }
        }
    }
    static void bfs(Node node, int n) {
        bfsFlag[node.name] = true;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offerLast(node);
        while(!queue.isEmpty()) {
            Node targetNode = queue.removeFirst();
            System.out.print(targetNode.name + " ");
            for(Node nextNode : targetNode.connectNode) {
                if(!bfsFlag[nextNode.name]) {
                    queue.offerLast(nextNode);
                    bfsFlag[nextNode.name] = true;
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int name;
    Node(int name) {
        this.name = name;
    }
    LinkedList<Node> connectNode = new LinkedList<>();

//    PriorityQueue<Node> connectNode = new PriorityQueue<>();
//
    @Override
    public int compareTo(Node node) {
        if(this.name > node.name)
            return 1;
        else if(this.name < node.name)
            return -1;
        return 0;
    }
}
