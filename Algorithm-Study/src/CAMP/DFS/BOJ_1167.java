package CAMP.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1167 {

    static Node[] saveNode;
    static int max = 0;
    static Node heavyNode;
    //02:43
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        saveNode = new Node[v+2];
        for (int i = 1; i <= v; i++) {
            Node node = new Node(i);
            saveNode[i] = node;
        }
        while(v-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int thisNodeName = Integer.parseInt(st.nextToken()); // 현재 노드번호 기억
            while(st.hasMoreTokens()) {
                int connectNodeName = Integer.parseInt(st.nextToken());
                if(connectNodeName == -1)
                    break;
                Node connectedNode = saveNode[connectNodeName];
                int connectNodeLength = Integer.parseInt(st.nextToken());
                ConnectNode connectNode = new ConnectNode(connectedNode, connectNodeLength);
                saveNode[thisNodeName].saveConnectNode.offerLast(connectNode);
            }
        }
        Node firstNode = saveNode[1];
        firstNode.flag = false;
        dfs(firstNode, 0);
        firstNode.flag = true;

        heavyNode.flag = false;
        dfs(heavyNode, 0);

//        for (Node node : saveNode) {
//            if(node == null)
//                continue;
//            node.flag = false;
//            dfs(node, 0);
//            node.flag = true;
//        }

        System.out.println(max);
    }
    static void dfs(Node node, int length) {
        for(ConnectNode connectNode : node.saveConnectNode) {
            if(!connectNode.node.flag)
                continue;
            connectNode.node.flag = false;
            dfs(connectNode.node, length + connectNode.length);
            connectNode.node.flag = true;
        }
        if(length > max) {
            max = length;
            heavyNode = node;
        }
    }
}

class Node {
    int name;
    boolean flag = true;
    LinkedList<ConnectNode> saveConnectNode = new LinkedList<>();
    Node(int name) {
        this.name = name;
    }
}

class ConnectNode {
    Node node;
    int length;
    ConnectNode(Node node, int length) {
        this.node = node;
        this. length = length;
    }
}
