package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Soccer {
    JField field;
    Ball ball;
    Player p, q, r, p2;
    Team team1, team2;
    boolean timeout, goal, paused;
    int clock;

    public static void main(String[] args) {
        Soccer soccer = new Soccer();
        soccer.start();

    }

    Soccer() {


        field = new JField(640/2, 480/2, this);
        ball = new Ball(field);
        team1 = new Team("Tottenham");
        team2 = new Team("Liverpool");
        p = new Player("SON", team1, field, -50, 10);
        q = new Player("LEE", team2, field, 50, 10);

        JPanel pan = new JPanel(null); // 배치관리자 없다
        pan.setBackground(Color.WHITE);
        pan.add(field);
        field.setLocation(20, 10);
        JFrame f = new JFrame("핵심J: Soccer Graphical");
        f.getContentPane().add(pan);
        f.setSize(320+56, 240+60);
        f.setVisible(true);
        f.setResizable(false);
        field.setFocusable(true);
        start();
    }

    void start() {
        System.out.println(" * START * ");
        timeout = false;
        paused = false;
        run();
    }
    void stop() {
        timeout = true;
    }

    void run() {
        clock = 0;
        while(!timeout) {
            if(!paused) {
                clock++;
                System.out.print(" [" + clock + "] ");

                int dist = p.move(ball);
                int distq = q.move(ball);
                r = p;
                System.out.print("  ," + r.name + " (" + r.getX() + ", " + r.getY() + ") ... ");
                if (distq < dist) {
                    r = q;
                    dist = distq;
                }
                if (dist < 5) {
                    r.kick(ball);
                    System.out.print(" -> " + r.name + " kicks -> ");
                }
                goal = ball.move();
                if (goal) {
                    System.out.print("*GOAL!!*");
                    if (ball.x > 0) {
                        System.out.println("  ->> " + p.team.teamName);
                        p.team.score++;
                    } else {
                        System.out.println("  ->> " + q.team.teamName);
                        q.team.score++;
                    }
                    System.out.println("TOTAL SCORE");
                    System.out.println(p.team.teamName + " " + p.team.score + " : " + q.team.teamName + " " + q.team.score);
                    ball.setX(0);
                    ball.setY(0);
                }
                //show();
                field.repaint();
            }

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

        hline(field.getRight()/dW - field.getLeft()/dW + 1);
        for(int r = field.getTop()/dH; r <= field.getBottom()/dH; r ++) {
            tpr("|");
            for(int i = field.getLeft()/dW; i<= field.getRight()/dW; i ++) {
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
        hline(field.getRight()/dW - field.getLeft()/dW + 1);
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
class JField extends JPanel {
    private int x0, x1, y0, y1, w, h;
    Soccer match;
    JField (int wide, int high, Soccer match) {
        w = wide;
        h = high;
        this.match = match;
        setSize(w, h);
        setBackground(Color.green);
        x1 = w / 2;
        x0 = -x1;
        y1 = h / 2;
        y0 = -y1;
        addKeyListener(new OMyKeyListener(match));
    }
    public class OMyKeyListener extends KeyAdapter {

        Soccer match;
        int speed = 4;
        OMyKeyListener(Soccer m) { match = m; }
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_RIGHT:
                    match.q.runtoward(5 * speed, 0);
                    break;
                case KeyEvent.VK_LEFT:
                    match.q.runtoward(-5 * speed, 0);
                    break;
                case KeyEvent.VK_UP:
                    match.q.runtoward(0, 5 * speed);
                    break;
                case KeyEvent.VK_DOWN:
                    match.q.runtoward(0, -5 * speed);
                    break;
                case KeyEvent.VK_SPACE:
                    match.paused = !match.paused;
                    break;
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
            }
        }
    }
    void drawClock(Graphics g) {

        int r = 10, x = w-r-10, y = r+10;
        double a = Math.PI/180* (-90 + match.clock*(360/90));
        g.drawOval(x-r, y-r, 2*r, 2*r);
        g.drawLine(x, y, (int)(x + r*Math.cos(a)), // 바늘 1개
                (int)(y + r*Math.sin(a)));

    }

    int getLeft() { return x0; } int getRight() { return x1; }
    int getTop() { return y0; } int getBottom() { return y1; }
    int getCx() { return x1; } int getCy() { return y1; }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white); // 테두리 흰색
        g.drawRect (0, 0, w, h); // 사각 테
        g.drawLine (getCx(), getCy()+y0, getCx(), getCy()+y1);
        g.drawOval (getCx()-40, getCy()-40, 80, 80);
        match.ball.draw(g);
        g.setColor(Color.red); match.p.draw(g);
        g.setColor(Color.blue); match.q.draw(g);
        drawClock(g);

    }

    String info() { return "동네 축구장"; }

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
    int getCx() { return x1; }
    int getCy() { return y1; }
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
    JField f;
    int x, y;
    double vx, vy;
    Ball(JField f) {
        x = 0;
        vx = 0;
        y = 0;
        this.f = f;
    }
    void draw(Graphics g) {
        int radius = 5;
        g.setColor(Color.black);
        g.fillOval(f.getCx() + x - radius,
                f.getCy() + y - radius,
                radius*2, radius*2);
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
    JField f;
    int x, y;
    double dx, dy, speed;
    String name;
    Team team;
    Player(String name, Team tm, JField f, int x0, int y0) {
        this.name = name;
        x = x0;
        y = y0;
        team = tm;
        this.f = f;
    }
    void runtoward(int dx, int dy) { x += dx; y += dy; }
    void draw(Graphics g) {
        g.drawRect(f.getCx()+x-5, f.getCy()+y-20, 10, 20);
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
