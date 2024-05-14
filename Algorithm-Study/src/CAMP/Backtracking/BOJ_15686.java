package CAMP.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15686 {

    static int[][] arr;
    static LinkedList<Chicken> saveChicken = new LinkedList<>();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    saveChicken.offerLast(new Chicken(i,j));
                    arr[i][j] = 0;
                }
            }
        }
        pickChickenM(0);
        System.out.println(minCityChicken);
    }

    static LinkedList<Chicken> pickChicken = new LinkedList<>();
    static void pickChickenM (int index) { // cnt <= m
        if(pickChicken.size() == m) {
            cityChicken();
            return;
        }
        for (int i = index; i < saveChicken.size(); i++) {
            Chicken chicken = saveChicken.get(i);
            pickChicken.offerLast(chicken);
            pickChickenM(i + 1);
            pickChicken.removeLast();
        }
    }

    static int minCityChicken = Integer.MAX_VALUE;
    static void cityChicken() {
        int thisCityChicken = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    thisCityChicken += calculate(i, j);
                }
            }
        }
        minCityChicken = Math.min(minCityChicken, thisCityChicken);
    }
    static int calculate(int x, int y) {
        int minLen = Integer.MAX_VALUE;
        for(Chicken chicken : pickChicken) {
            int len = Math.abs(x - chicken.x) + Math.abs(y - chicken.y);
            minLen = Math.min(minLen, len);
        }
        return minLen;
    }
}

class Chicken {
    int x, y;
    Chicken(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


