package Practice;

import java.util.*;

public class Lab {

    private int labTest;
    Lab(int labTest) {
        this.labTest = labTest;
    }
    void print() {
        System.out.println(labTest);
    }


    public static void main(String[] args) {
        Set<Tree> binarySearchTree = new TreeSet<>();
        binarySearchTree.add(new Tree(5));
        binarySearchTree.add(new Tree(2));
        binarySearchTree.add(new Tree(9));
        binarySearchTree.add(new Tree(5));

        for (Tree tree: binarySearchTree
             ) {
            System.out.println(tree.n);
        }
    }

}

class Tree implements Comparator<Tree> {
    int n;

    Tree(int n) {
        this.n = n;
    }


    @Override
    public int compare(Tree t1, Tree t2) {
        return t1.n - t2.n;
    }
}



class newClass {

    void method1() {
        Lab lab = new Lab(9);
        lab.print();
    }

}
