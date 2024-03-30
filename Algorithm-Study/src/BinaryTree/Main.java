package BinaryTree;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static int level = 1;
    public static int maxLevel;
    public static int end;
    public static LinkedList<Integer> list = new LinkedList<>();

    public static void printTree() {
        for (; level < maxLevel; level++) {
            int before = 1;
            for (int i = 1; i <= level; i++) {
                for (int j = 1; j <= i; j++) {
                    //int midIndex = ((end / i) * j + ((end / i) * j - 2)) / 2 - 1;
                    int midIndex = (before + (end/i + 1) * j) / 2;
                    before = midIndex + 1;
                    System.out.print(list.get(midIndex - 1));
                    list.set(midIndex - 1, -1);
                }
            }
            before = 1;
            while(list.contains(-1))
                list.remove(list.indexOf(-1));
            end = list.size();
            System.out.println();
        }
        while(!list.isEmpty())
            System.out.print(list.removeFirst() + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        maxLevel = k;
        //int[][] treeResult = new int[k][k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfNode = (int) (Math.pow(2, k) - 1);
        for (int i = 0; i < numOfNode; i++) {
             int num = Integer.parseInt(st.nextToken());
             list.offerLast(num);
        }
        end = numOfNode;
        printTree();
    }
}

//class Node {
//    char data;
//    Node left = null;
//    Node right = null;
//    public Node(char data) {
//        this.data = data;
//    }
//}