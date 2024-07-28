package SamsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 05:30
public class BOJ_5373__ {
    static int t;
    static char[][][] cube;


    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                char[] tok = st.nextToken().toCharArray();
                turn(tok[0], tok[1]);
            }
        }
    }
    /**
     * up : 0
     * down : 1
     * front : 2
     * back : 3
     * left : 4
     * right : 5
     */
    static void turn(char f, char dir) {
        int face = convertToInt(f);
        int exceptFace = face + 1;
        if(face % 2 == 1) {
            exceptFace = (face + 5) % 6;
        }
        char[][][] newCube = new char[6][3][3];
        copyCube(newCube);
        for (int i = 0; i < 6; i++) {
            int changeFace;
            int row = -1;
            int col = -1;
            if(i==face || i==exceptFace)
                continue;
            if(face == 0) {
                changeFace = up(i, dir);
                row = 0;
            }
            else if(face == 1) {
                changeFace = down(i, dir);
                row = 2;
            }
            else if(face == 2) {
                changeFace = front(i, dir);

            }
            else if(face == 3) {
                changeFace = back(i, dir);
            }
            else if(face == 4) {
                changeFace = left(i, dir);
            }
            else if(face == 5) {
                changeFace = right(i, dir);
            }

        }
    }
    static void copyCube(char[][][] newCube) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    newCube[i][j][k] = cube[i][j][k];
                }
            }
        }
    }

    static int left(int face, char dir) {
        /**
         * ex) Left 반시계 방향 == Right 시계
         * up : 기존 front
         * front : 기존 down
         * down : 기존 back
         * back : 기존 up
         */

        /**
         * 반대방향
         * up : 기존 back
         * front : 기존 up
         * down : 기존 front
         * back : 기존 down
         */
        if (face == 0) {
            if (dir == '-')
                return 2;
            else
                return 1;
        } else if (face == 2) {
            if (dir == '-')
                return 1;
            else
                return 0;
        } else if (face == 1) {
            if (dir == '-')
                return 3;
            else
                return 2;
        } else if (face == 3) {
            if (dir == '-')
                return 0;
            else
                return 1;
        }
        return -1;
    }

    static int right(int face, char dir) {
        if(dir == '-')
            dir = '+';
        else
            dir = '-';
        return left(face, dir);
    }

    static int front(int face, char dir) {
        /**
         * 반시계 기준
         * up : right
         * right : down
         * down : left
         * left : up
         */
        if (face == 0) {
            if (dir == '-')
                return 5;
            else
                return 4;
        } else if (face == 5) {
            if (dir == '-')
                return 1;
            else
                return 0;
        } else if (face == 1) {
            if (dir == '-')
                return 4;
            else
                return 5;
        } else if (face == 4) {
            if (dir == '-')
                return 0;
            else
                return 1;
        }
        return -1;
    }
    static int back(int face, char dir) {
        if(dir == '-')
            dir = '+';
        else
            dir = '-';
        return front(face, dir);
    }

    static int up(int face, char dir) {
        /**
         * 반시계 기준
         * front : left
         * left : back
         * back : right
         * right : front
         */
        if (face == 2) {
            if (dir == '-')
                return 4;
            else
                return 5;
        } else if (face == 4) {
            if (dir == '-')
                return 3;
            else
                return 2;
        } else if (face == 3) {
            if (dir == '-')
                return 5;
            else
                return 4;
        } else if (face == 5) {
            if (dir == '-')
                return 2;
            else
                return 3;
        }
        return -1;
    }
    static int down(int face, char dir) {
        if(dir == '-')
            dir = '+';
        else
            dir = '-';
        return up(face, dir);
    }

    static int convertToInt(char n) {
        if(n=='U')
            return 0;
        if(n=='D')
            return 1;
        if(n=='F')
            return 2;
        if(n=='B')
            return 3;
        if(n=='L')
            return 4;
        //if(n=='R')
        return 5;
    }
    static void init() {
        cube = new char[6][3][3];
        for (int i = 0; i < 6; i++) {
            char color;
            if(i == 0)
                color = 'w';
            else if(i==1)
                color = 'y';
            else if(i==2)
                color = 'r';
            else if(i==3)
                color = 'o';
            else if(i==4)
                color = 'g';
            else
                color = 'b';
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        cube[i][j][k] = color;
                    }
                }
        }
    }
}
