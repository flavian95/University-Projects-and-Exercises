
import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    private String text = "Bine v-am gasit!";
    private int width;
    private int height;
    public int line;
    private Dimension d;

    public void set() {
        Graphics g = getGraphics();
        FontMetrics fm = g.getFontMetrics();
        width = fm.stringWidth(text);
        height = fm.getHeight();
        d = getSize();
        line = d.height - height;
    }

    public void paint (Graphics g) {
        Color c= new Color((int)(Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        g.setColor(c);
        if (line >= height) {
            g.drawString(text, 10, line);
            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            g.clearRect(10, line, 200, 100);
            line -= height;
        }
        else {
            g.clearRect(10, line, 200, 100);
            line = d.height - height;
        }
        repaint();
    }
}

public class ScrollingTextApp extends JFrame {
    MyPanel p = new MyPanel();
    public ScrollingTextApp() {
        super("Scrolling Text App");
        add(p);
    }

    public void paint (Graphics g) {
        p.set();
        p.paint(g);
    }

    public static void main(String[] args) {
        ScrollingTextApp frame = new ScrollingTextApp();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}