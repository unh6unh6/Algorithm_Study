package Practice;


import java.util.LinkedList;
import java.util.Queue;

class min {
    int c;
    static void setC(int c) {
        //this.c = c;
    }
}

public class practice {
    public static int n = 10;
    public final int ABC;

    practice(int n) {
        ABC = n;
    }
    public static void main(String[] args) {
       min instaceMin = new min();
       instaceMin.c = 5;
       instaceMin.setC(5);
    }
}

class test {
    void k() {
        min.setC(5);
    }
}
