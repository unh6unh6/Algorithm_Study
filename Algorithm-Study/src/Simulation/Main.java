package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] map; // 빈공간 : 0, 자기몸 : 1, 사과 : 2
    public static int second = 0;

    public static LinkedList<Integer> currentY = new LinkedList<>();
    public static LinkedList<Integer> currentX = new LinkedList<>();

    public static int offset[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static int selectOffset = 0;

    public static boolean isApple() {
        int newY = currentY.getFirst();
        int newX = currentX.getFirst();
        if(map[newY][newX] == 2)
            return true;
        return false;
    }

    public static boolean canMove() {
        int newY = currentY.getFirst() + offset[selectOffset][0];
        int newX = currentX.getFirst() + offset[selectOffset][1];

        if(newY < 0 || newY >= n || newX < 0 || newX >= n) // 벽에 부딪침
            return false;

        if(map[newY][newX] == 1) // 자기몸에 맞음
            return false;

        return true;
    }

    public static void changeDirection(char c) {
        if(c == 'D') {
            selectOffset++;
            if(selectOffset == 4)
                selectOffset = 0;
        }

        if(c == 'L') {
            selectOffset--;
            if(selectOffset == -1)
                selectOffset = 3;
        }
    }

    public static boolean moveUntilTurn(int x, char c) {

        if(second == x) {
            changeDirection(c);
            return false;
        }

        if(!canMove()) // 벽이나 몸에 부딪친 경우
            return true;

        int newY = currentY.getFirst() + offset[selectOffset][0];
        int newX = currentX.getFirst() + offset[selectOffset][1];
        currentY.offerFirst(newY);
        currentX.offerFirst(newX); // 현재 위치 1만큼 이동


        if(!isApple()) { // 이동시킨 위치가 사과가 아니라면, 스택에서 pop한 좌표를 map에서 자기몸칸에서 공백칸으로 바꿈 ( 1->0 )
            map[currentY.getLast()][currentX.getLast()] = 0;
            currentY.pollLast();
            currentX.pollLast();
        }


        map[currentY.getFirst()][currentX.getFirst()] = 1; // 이동한 위치에 자기몸 체크

        second ++; // 시간 더하기
        moveUntilTurn(x, c);
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        map[0][0] = 1;
        currentY.offerFirst(0);
        currentX.offerFirst(0);

        int k = Integer.parseInt(br.readLine()); // 사과의 개수
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int appleY = Integer.parseInt(st.nextToken()) - 1;
            int appleX = Integer.parseInt(st.nextToken()) - 1;
            map[appleY][appleX] = 2;
        }

        int l = Integer.parseInt(br.readLine()); // 방향 변환 횟수
        for (int i = 0; i <= l; i++) {
            int x;
            char c;

            if(i == l) {
                x = 10000;
                c = '?';
            }

            else {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                c = st.nextToken().charAt(0);
            }
            if(moveUntilTurn(x, c))
                break;
        }

        System.out.println(second + 1);
    }
}