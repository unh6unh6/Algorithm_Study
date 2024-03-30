package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static LinkedList<Integer> durability = new LinkedList<>();
    public static LinkedList<Integer> weight = new LinkedList<>();
    public static int[] cntBreak = new int[1000000];
    public static boolean isBreak = false;

    public static void recursion(int index, LinkedList<Integer> durability, LinkedList<Integer> weight) {
        if(durability.isEmpty())
            return;

        if(isBreak) {
            int handDurability = durability.pollFirst();
            int handWeight = weight.pollFirst();
        }
        LinkedList<Integer> newDurability = new LinkedList<>();
        LinkedList<Integer> newWeight = new LinkedList<>();
        Collections.copy(newDurability, durability);
        Collections.copy(newWeight, weight);

        for (int i = 0; i < n; i++) {

            recursion(index + 1, newDurability, newWeight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability.offerLast(Integer.parseInt(st.nextToken()));
            weight.offerLast(Integer.parseInt(st.nextToken()));
        }

        recursion(0, durability, weight);

    }
}
