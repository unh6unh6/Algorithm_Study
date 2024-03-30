package BinaryTree.practice;

public class Node {
    Node left;
    Node right;
    int value;

    public Node(int data) {
        this(data, null, null);
    }
    public Node(int data, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.value = data;
    }
}
