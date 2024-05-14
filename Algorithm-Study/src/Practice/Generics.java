package Practice;

import java.util.LinkedList;

public class Generics {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add("string");
        System.out.println(list.peek());
    }
}
