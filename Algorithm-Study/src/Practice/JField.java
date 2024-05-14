package Practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JField extends JPanel {
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
