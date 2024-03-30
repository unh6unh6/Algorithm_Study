package Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6603 {
    public static int k;
    public static int[] s;
    public static boolean[] use;
    public static int[] result;
    public static void recursion(int start, int index) {
        if(index == 6) {
            for(int num : result)
                System.out.print(num + " ");
            System.out.println();
            return;
        }
        for(int i=start; i<k; i++) {
            if (!use[i]) {
                use[i] = true;
                result[index] = s[i];
                recursion(i + 1, index + 1);
                use[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;
            s = new int[k];
            use = new boolean[k];
            for(int i=0; i<k; i++)
                s[i] = Integer.parseInt(st.nextToken());
            result = new int[6];
            recursion(0, 0);
            System.out.println();
        }
    }
}

/*
package Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int k;
    public static ArrayList<Integer> s;
    public static ArrayList<Boolean> use;
    public static ArrayList<Integer> result;
    public static void recursion(int index) {
        if(result.size() == 6) {
            System.out.println(result);
            //result.remove(5);
            return;
        }
        for(int i=0; i<k; i++) {
            if (!use.get(i)) {
                use.set(i, true);
                result.add(index, s.get(i));
                recursion(index + 1);
                use.set(i, false);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(0,3);
        System.out.println(test);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;
            s = new ArrayList<>();
            use = new ArrayList<>();
            for(int i=0; i<k; i++)
                use.add(false);
            for(int i=0; i<k; i++)
                s.add(Integer.parseInt(st.nextToken()));
            result = new ArrayList<>();
            recursion(0);
            System.out.println();
        }
    }
}

 */