package SamsungSW;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while(list.size() - 1 != index) {
            index++;
            list.add(list.get(index++));
        }
        System.out.println(list.get(index));
    }
}
