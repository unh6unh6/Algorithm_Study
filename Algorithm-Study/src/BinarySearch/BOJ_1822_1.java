package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1822_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++)
            list.offerLast(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[b];
        for (int i = 0; i < b; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < b; i++) {
            while(arr[i] > list.get(index))
                index ++;
            if(arr[i] == list.get(index))
                list.remove(index);
        }

        System.out.println(list.size());
        for(int i : list)
            System.out.print(i + " ");
    }
}
