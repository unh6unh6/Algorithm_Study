package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int k;
    static LinkedList<Integer>[] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            LinkedList<Integer> gear = new LinkedList<>();
            String[] tok = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear.add(Integer.parseInt(tok[j]));
            }
            gears[i] = gear;
        }
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            cal(gearNum, dir);
        }
        /**
         * right index = 2
         * left index = 6
         */
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if(gears[i].get(0) == 1)
                result += Math.pow(2,i);
        }
        System.out.println(result);
    }
    static void cal(int gearNum, int dir) {
        boolean[] haveToTurn = new boolean[4];
        int[] dirs = new int[4];
        haveToTurn[gearNum] = true;
        dirs[gearNum] = dir;
        for (int i = gearNum; i < 3; i++) {
            if(gears[i].get(2) == gears[i+1].get(6))
                break;
            haveToTurn[i+1] = true;
            dirs[i+1] = dirs[i] * -1;
        }
        for (int i = gearNum; i > 0 ; i--) {
            if(gears[i].get(6) == gears[i-1].get(2))
                break;
            haveToTurn[i-1] = true;
            dirs[i-1] = dirs[i] * -1;
        }
        for (int i = 0; i < 4; i++) {
            if(haveToTurn[i])
                turn(i, dirs[i]);
        }
    }
    static void turn(int gearNum, int dir) {
        if(dir == 1) {
            gears[gearNum].offerFirst(gears[gearNum].removeLast());
        }
        else if(dir == -1) {
            gears[gearNum].offerLast(gears[gearNum].removeFirst());
        }
    }
}
