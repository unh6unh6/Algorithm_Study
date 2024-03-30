package BinaryTree.practice;

public class BinaryTree {
    Node root = null;

    public int minValue() {
        return minNode(this.root).value;
    }
    private Node minNode(Node root) {
        if(root.left == null)
            return root;
        return minNode(root.left);
    }
    public int maxValue() {
        return maxNode(this.root).value;
    }
    private Node maxNode(Node root) {
        if(root.right == null)
            return root;
        return maxNode(root.right);
    }
    public void add(int data) {
        Node newNode = new Node(data);
        this.root = addNode(this.root, newNode);
    }

    private Node addNode(Node root, Node newNode) {
        if(root == null)
            return newNode;
        else if(newNode.value > root.value)
            root.left = addNode(root.left, newNode);
        else if(newNode.value < root.value)
            root.right = addNode(root.right, newNode);
        return root;
    }

    public void remove(int data) {
        root = removeNode(this.root, data);
    }

    private Node removeNode(Node node, int data) {
        System.out.println(node.value);
        if(node.value > data)
            node.left = removeNode(node.left, data);
        else if(node.value < data)
            node.right = removeNode(node.right, data);
        else if(node.value == data) {
            if(node.left != null) {
                Node changeNode = maxNode(node.left);
                int removeValue = node.value;
                node.value = changeNode.value;
                changeNode.value = removeValue;
                node.left = removeNode(node.left, data);
            }
            else if(node.right != null) {
                Node changeNode = minNode(node.right);
                int removeValue = node.value;
                node.value = changeNode.value;
                changeNode.value = removeValue;
                node.right = removeNode(node.right, data);
            }
            else
                return null;
        }
        return node;
    }
    public void search(int data) {
        searchNode(this.root, data);
    }

    private Node searchNode(Node node, int data) {
        if(data < node.value)
            node.right = searchNode(node.right, data);
        else if(data > node.value)
            node.left = searchNode(node.left, data);
        else
            System.out.println("find node");
        return node;
    }

    public void ascendingTraversal() {
        inorderTraversal(this.root);
        System.out.println();
    }
    private void inorderTraversal(Node node) {
        if(node == null)
            return;
        inorderTraversal(node.left);
        System.out.printf("%d ", node.value);
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(5);
        bt.add(3);
        bt.add(11);
        bt.add(9);
        bt.add(1);
        bt.add(2);
        bt.add(3);
        bt.ascendingTraversal();
        bt.search(11);
        bt.remove(11);
        bt.ascendingTraversal();
    }
}
