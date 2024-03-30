package BinaryTree.BOJ_11725;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_Tree {
    public static Node root = new Node(1);

    public static void add(int data1, int data2) {
        Node parentNode = findNode(data1, root);
        if(parentNode == null) {
            parentNode = findNode(data2, root);
            addNode(parentNode, data1);
            return;
        }
        addNode(parentNode, data2);
    }
    public static Node findNode(int data, Node node) {
        if(node.data == data)
            return node;
        for(Node nextNode : node.child) {
            Node foundNode = findNode(data, nextNode);
            if(foundNode != null)
                return foundNode;
        }
        return null;
    }
    public static void addNode(Node parentNode, int data) {
        Node newNode = new Node(data, parentNode);
        parentNode.child.add(newNode);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int data1 = Integer.parseInt(st.nextToken());
            int data2 = Integer.parseInt(st.nextToken());
            add(data1, data2);
        }         // 여기까지 트리 생성단계
        for(int i=2; i<=n; i++) {
            Node iNode = findNode(i, root);
            sb.append(iNode.parent.data).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
class Node {
    int data;
    Node parent = null;
    ArrayList<Node> child = new ArrayList<>();

    public Node(int data) {
        this(data, null);
    }

    public Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
    }
}
