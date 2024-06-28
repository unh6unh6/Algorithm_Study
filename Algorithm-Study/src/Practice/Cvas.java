package Practice;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

class Cvas extends Canvas {
    KChatClient cchat;
    Point p1 = new Point(0,0), p2 = new Point(0,0);
    Cvas(KChatClient cc, int w, int h) {
        cchat = cc;
        setSize(w,h);
        setBackground(new Color(245,200,255));
        addMouseMotionListener(new DrawDragger());
        addMouseListener(new DrawMouser());
    }
    public void paint(Graphics g) { g.drawString("Graphically", 120,30); }

    void draw(int x1, int y1, int x2, int y2) {
        Graphics g = getGraphics();
        g.drawLine(x1,y1,x2,y2);
    }

class DrawMouser extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        p1.x = e.getX(); p1.y = e.getY();
        p2.setLocation(p1);
    }
    public void mouseReleased(MouseEvent e) {
        p2.x = e.getX(); p2.y = e.getY();
        draw(p1.x,p1.y,p2.x,p2.y);
        //
    }
}

class DrawDragger extends MouseMotionAdapter {
    public void mouseDragged(MouseEvent e) {
        p2.x = e.getX(); p2.y = e.getY();
        draw(p1.x,p1.y,p2.x,p2.y);
        //
        p1.setLocation(p2);
    }
}
}
