package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20055 {
    static int[] belt;
    static LinkedList<Integer> robot = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        belt = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            int hp = Integer.parseInt(st.nextToken());
            belt[i] = hp;
        }
        int step = 1;
        int stop = 0;
        int upPos = 0;
        int downPos = n-1;
        while(true) {
            downPos = setNewPos(downPos, n);
            if(robot.contains(downPos))
                robot.remove(robot.indexOf(downPos));
            upPos = setNewPos(upPos, n);

            for(int i=robot.size()-1; i>=0; i--) {
                int nextPos = (robot.get(i) + 1) % belt.length;

                if(belt[nextPos] > 0 && !robot.contains(nextPos)) {
                    robot.set(i, nextPos);
                    belt[nextPos]--;
                    if(belt[nextPos] == 0)
                        stop++;

                    if(nextPos == downPos) {
                        robot.remove(i);
                    }
                }
            }
            if(belt[upPos] > 0 && !robot.contains(upPos)) {
                robot.offerFirst(upPos);
                belt[upPos] --;
                if(belt[upPos] == 0)
                    stop++;
            }
            if(stop >= k)
                break;

            step++;
        }
        System.out.println(step);
    }
    static int setNewPos(int pos, int n) {
        pos--;
        if (pos == -1)
            pos = 2 * n - 1;
        return pos;

    }
}
