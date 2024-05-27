package Practice;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*; // DateFormat
public class DigitalClock extends JPanel {
    Repainter rp; // thread
    public void start() {
        rp = new Repainter(this, 1000);
        rp.start(); // *
    }
    public void paint(Graphics g) {
        super.paint(g);
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateformatter = DateFormat.getTimeInstance();
        g.setFont(new Font("굴림", Font.BOLD, 36));
        g.drawString(dateformatter.format(date), 30, 120);
        DateFormat date2Formatter = DateFormat.getDateInstance(DateFormat.SHORT);
        g.setFont(new Font("굴림", Font.BOLD, 24));
        g.drawString(date2Formatter.format(date), 30+65, 70);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("디지털 시계");
        DigitalClock dc = new DigitalClock();
        dc.start();
        f.getContentPane().add(dc);
        f.setSize(330,200);
        f.setVisible(true);
    }
    class Repainter extends Thread {
        Component comp;
        long timeInterval;
        public Repainter (Component c, long time) {
            comp = c;
            timeInterval = time;
        }
        public void run() {
            while(true) {
                try {
                    comp.repaint();
                    sleep(timeInterval);
                } catch (Exception e) {}
            }
        }
    }
}