package Practice;

public class Soccer {
    Filed filed;
    Ball ball;
    Player p, q, r;
    Team team1, team2;
    boolean timeout, goal;
    int clock;

    public static void main(String[] args) {
        Soccer soccer = new Soccer();
        soccer.start();

    }

    Soccer() {
        filed = new Filed(128, 96);
        ball = new Ball(filed);
        team1 = new Team("Tottenham");
        team2 = new Team("Liverpool");
        p = new Player("SON", team1, filed, -50, 10);
        q = new Player("LEE", team2, filed, 50, 10);
    }

    void start() {
        System.out.println(" * START * ");
        timeout = false;
        run();
    }
    void stop() {
        timeout = true;
    }

    void run() {
        clock = 0;
        while(!timeout) {
            clock ++;
            System.out.print(" [" + clock + "] ");

            int dist = p.move(ball);
            int distq = q.move(ball);
            r = p;
            System.out.print("  ," + r.name + " (" + r.getX() + ", " + r.getY() + ") ... ");
            if(distq < dist) {
                r = q;
                dist = distq;
            }
            if(dist < 5) {
                r.kick(ball);
                System.out.print(" -> " + r.name + " kicks -> ");
            }
            goal = ball.move();
            if (goal) {
                System.out.print("*GOAL!!*");
                if(ball.x > 0) {
                    System.out.println("  ->> " + p.team.teamName);
                    p.team.score ++;
                }
                else {
                    System.out.println("  ->> " + q.team.teamName);
                    q.team.score ++;
                }
                System.out.println("TOTAL SCORE");
                System.out.println(p.team.teamName + " " +p.team.score + " : " + q.team.teamName + " " + q.team.score);
                ball.setX(0);
                ball.setY(0);
            }
            show();
            try {
                Thread.sleep(200);
            } catch (Exception e) {}

            if(clock > 45)
                stop();
        }
        System.out.println(" * TIME OUT * ");
        System.out.println("FINAL SCORE");
        System.out.println(p.team.teamName + " " +p.team.score + " : " + q.team.teamName + " " + q.team.score);
        if(p.team.score > q.team.score) {
            System.out.println(p.team.teamName + " WIN !! ");
        }
        else if(p.team.score < q.team.score) {
            System.out.println(q.team.teamName + " WIN !! ");
        }
        else
            System.out.println(" DRAW ");
    }
    void show() {			/* member variables: {field, b, p, q} */
        int dH = 10, dW = 3;	/* ground cell dimension: dHxdW */
        int bx = ball.getX() / dW;
        int by = ball.getY() / dH;
        int px = p.getX() / dW;
        int py = p.getY() / dH;
        int qy = q.getY() / dH;
        int qx = q.getX() / dW;

        hline(filed.getRight()/dW - filed.getLeft()/dW + 1);
        for(int r = filed.getTop()/dH; r <= filed.getBottom()/dH; r ++) {
            tpr("|");
            for(int i = filed.getLeft()/dW; i<= filed.getRight()/dW; i ++) {
                if (r == by && i == bx) {
                    tpr("*");
                    if (r == py && i == px) {
                        tpr("p"); i++;
                        if (r == qy && i == qx) { tpr("q"); i++; }
                    } else if (r == qy && i == qx) { tpr("q"); i++; }
                } else if (r == py && i == px) {
                    tpr("p");
                    if (r == qy && i == qx) { tpr("q"); i++; }
                } else if (r == qy && i == qx) { tpr("q");
                } else { /* if (r == 0 && i == 0) tpr("+"); else  */
                    tpr(" ");
                }
            }
            tprl("|"+r);
        }
        hline(filed.getRight()/dW - filed.getLeft()/dW + 1);
    }
    void hline(int n) {
        tpr("+");
        for(int i = 1; i<=n; i++)  tpr("-");
        tprl("+");
    }
    void tpr(String s) { System.out.print(s); }
    void tprl(String s) { System.out.println(s); }

}
class Team {
    String teamName;
    int score = 0;
    Team (String teamName) {
        this.teamName = teamName;
    }
}

class Filed {
    int x0, x1, y0, y1, w, h;
    Filed(int wide, int high) {
        w = wide;
        h = high;
        x1 = w/2;
        y1 = h/2;
        x0 = -x1;
        y0 = -y1;
    }
    int getLeft() {
        return x0;
    }

    int getRight() {
        return x1;
    }

    int getTop() {
        return y0;
    }

    int getBottom() {
        return y1;
    }
}

class Ball {
    Filed f;
    int x, y;
    double vx, vy;
    Ball(Filed f) {
        x = 0;
        vx = 0;
        y = 0;
        this.f = f;
    }
    boolean move() {
        x = x + (int)vx;
        y = y + (int)vy;
        System.out.println("Ball(" + x + ", " + y + "). " );
        vx = vx * 0.8;
        vy = vy * 0.8;
        boolean checkGoal = (x > f.getRight() - 1 || x < f.getLeft() + 1);
        checkBounds();
        return checkGoal;
    }
    void checkBounds() {
        if(x < f.getLeft()) {
            vx = -vx;
            x = 2 * f.getLeft() - x;
        }
        if(x > f.getRight()) {
            vx = -vx;
            x = 2 * f.getRight() - x;
        }
        if(y < f.getTop()) {
            vy = -vy;
            y = 2 * f.getTop() - y;
        }
        if(y > f.getBottom()) {
            vy = -vy;
            y = 2 * f.getBottom() - y;
        }
    }
    void fly(double kx, double ky) {
        vx = vx + kx;
        vy += ky;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

}

class Player {
    Filed f;
    int x, y;
    double dx, dy, speed;
    String name;
    Team team;
    Player(String name, Team tm, Filed f, int x0, int y0) {
        this.name = name;
        x = x0;
        y = y0;
        team = tm;
        this.f = f;
    }
    int move(Ball b) {
        dash(b);
        x = x + (int)dx;
        y = y + (int)dy;
        int dist = (int) distance(b);
        System.out.print(name + " " + dist + " ");
        return dist;
    }
    double distance(Ball b) {
        double x2x = x - b.getX();
        double y2y = y - b.getY();
        return Math.sqrt(x2x * x2x + y2y * y2y);
    }
    void kick(Ball b) {
        double kx = dx * 2 + randM(10) - 5;
        double ky = dy * 2 + randM(8) - 4;
        b.fly(kx, ky);
        speed = speed / 2;
    }
    double randM(int M) {
        return Math.random() * M;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
    void dash(Ball b) {
        double dist = distance(b) + 1;
        speed = speed * 0.8 + randM(4);
        dx = (b.getX() - x) / dist * speed;
        dy = (b.getY() - y) / dist * speed;
    }
}
