package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//03:20
public class BOJ_21608 {
    static int n;
    static int[] student;
    static int[][] like;
    static int[][] seat;
    static int[][] offset = { {-1,0}, {0,1}, {1,0}, {0,-1} };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        student = new int[n*n];
        like = new int[n*n+1][4];
        seat = new int[n][n];
        for(int i=0; i<n*n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[student[i]][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int stuNum = 0; stuNum<n*n; stuNum++) {
            int stu = student[stuNum];
            Pos bestSeat = new Pos(-1, -1, -1, -1, -1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(seat[i][j] != 0)
                        continue;
                    int like = 0;
                    int blank = 0;
                    for (int k = 0; k < 4; k++) {
                        int newX = i + offset[k][0];
                        int newY = j + offset[k][1];
                        if(newX < 0 || newX >= n || newY < 0 || newY >=n)
                            continue;
                        int result = checkSeat(stu, seat[newX][newY]);
                        if(result == 1)
                            like++;
                        else if(result == 0)
                            blank++;
                    }
                    Pos thisPos = new Pos(stu, i, j, like, blank);
                    if(bestSeat.compareTo(thisPos) < 0)
                        bestSeat = thisPos;
                }
            }
            seat[bestSeat.x][bestSeat.y] = bestSeat.stuNum;
        }
        long satisfy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int newX = i + offset[k][0];
                    int newY = j + offset[k][1];
                    if(newX < 0 || newX >= n || newY < 0 || newY >=n)
                        continue;
                    if(checkSeat(seat[i][j], seat[newX][newY]) == 1)
                        cnt++;
                }
                if(cnt == 1)
                    satisfy +=1;
                else if(cnt == 2)
                    satisfy += 10;
                else if(cnt == 3)
                    satisfy += 100;
                else if(cnt == 4)
                    satisfy += 1000;
            }
        }
        System.out.println(satisfy);
    }
    static int checkSeat(int stuNum, int seatStuNum) {
        for (int i = 0; i < 4; i++) {
            if(like[stuNum][i] == seatStuNum)
                return 1;
            else if(seatStuNum == 0)
                return 0;
        }
        return -1;
    }
}

class Pos implements Comparable<Pos> {
    int stuNum;
    int x, y;
    int likeSeat;
    int blankSeat;

    public Pos(int stuNum, int x, int y, int likeSeat, int blankSeat) {
        this.stuNum = stuNum;
        this.x = x;
        this.y = y;
        this.likeSeat = likeSeat;
        this.blankSeat = blankSeat;
    }

    @Override
    public int compareTo(Pos o) {
        if(this.likeSeat > o.likeSeat)
            return 1;
        else if(this.likeSeat < o.likeSeat)
            return -1;
        else if(this.blankSeat > o.blankSeat)
            return 1;
        else if(this.blankSeat < o.blankSeat)
            return -1;
        else if(this.x < o.x)
            return 1;
        else if(this.x > o.x)
            return -1;
        else if(this.y < o.y)
            return 1;
        else if(this.y > o.y)
            return -1;
        return 0;
    }
}
