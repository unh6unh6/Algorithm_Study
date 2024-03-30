package BinaryTree.BOJ_1991;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static Node root = null;
    public static Node find(char main, Node node) {
        if (node == null || node.data == '.') {
            return null;
        }
        if(main == node.data)
            return node;
        Node left = find(main, node.left);
        if(left != null)
            return left;
        return find(main, node.right);
    }
    public static void add(char main, char left, char right) {
        if(root == null) {
            root = new Node(main);
            root.left = new Node(left);
            root.right = new Node(right);
            return;
        }
        Node findNode = find(main, root);
        findNode.left = new Node(left);
        findNode.right = new Node(right);
    }
    public static void preorder(Node node) {
        if(node != null && node.data != '.') {
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public static void inorder(Node node) {
        if(node != null && node.data != '.') {
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }
    public static void postorder(Node node) {
        if(node != null && node.data != '.') {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            add(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}

class Node {
    char data;
    Node left = null;
    Node right = null;
    public Node(char data) {
        this.data = data;
    }
}
