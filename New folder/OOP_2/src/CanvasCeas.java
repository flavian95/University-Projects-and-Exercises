
import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.concurrent.*;
import javax.swing.JPanel;
//public class CanvasCeas extends JPanel {
//    private int sec, offset;
//    private String tara;
//    private ScheduledExecutorService ses;
//    public CanvasCeas(String t, int o){
//        tara=t;
//        offset=o;
//        ses=Executors.newSingleThreadScheduledExecutor();
//        ses.scheduleAtFixedRate(new Secundar(), 0, 1, TimeUnit.SECONDS);
//        setSize(125,125);
//    }
//    public void paint(Graphics g){
//        g.setColor(Color.white);
//        g.fillRect(0,0,100,100);
//        g.setColor(Color.black);
//        g.drawOval(0,0,100,100);
//        double unghiOra=2*Math.PI*(sec-3*60*60)/(12*60*60);
//        double unghiMinut=2*Math.PI*(sec-15*60)/(60*60);
//        double unghiSecunda=2*Math.PI*(sec-15)/60;
//        g.drawLine(50, 50, 50+(int)(30*Math.cos(unghiOra)),50+(int)(30*Math.sin(unghiOra)) );
//        g.drawLine(50, 50, 50+(int)(40*Math.cos(unghiMinut)),50+(int)(40*Math.sin(unghiMinut)) );
//        g.drawLine(50, 50, 50+(int)(45*Math.cos(unghiSecunda)),50+(int)(45*Math.sin(unghiSecunda)) );
//        g.drawString(tara, 0, 115);
//    }
//    private class Secundar implements Runnable{
//        public void run(){
//            var timp=Calendar.getInstance();
//            sec=(timp.get(Calendar.HOUR)+offset)*3600+timp.get(Calendar.MINUTE)*60+timp.get(Calendar.SECOND);
//            repaint();
//        }
//    }
//}

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.concurrent.*;
import javax.swing.JPanel;

public class CanvasCeas extends JPanel {
    private int sec, offset;
    private String tara;
    private ScheduledExecutorService ses;

    public CanvasCeas(String t, int o){
        tara = t;
        offset = o;
        ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(new Secundar(), 0, 1, TimeUnit.SECONDS);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.black);
        g.drawOval(0, 0, 100, 100);

        double unghiOra = 2*Math.PI*(sec - 3*60*60)/(12*60*60);
        double unghiMinut = 2*Math.PI*(sec - 15*60)/(60*60);
        double unghiSecunda = 2*Math.PI*(sec - 15)/60;

        g.drawLine(50, 50, 50 + (int)(30*Math.cos(unghiOra)), 50 + (int)(30*Math.sin(unghiOra)));
        g.drawLine(50, 50, 50 + (int)(40*Math.cos(unghiMinut)), 50 + (int)(40*Math.sin(unghiMinut)));
        g.drawLine(50, 50, 50 + (int)(45*Math.cos(unghiSecunda)), 50 + (int)(45*Math.sin(unghiSecunda)));
        g.drawString(tara, 0, 115);
    }

    private class Secundar implements Runnable {
        public void run(){
            var timp = Calendar.getInstance();
            sec = (timp.get(Calendar.HOUR) + offset) * 3600 +
                    timp.get(Calendar.MINUTE) * 60 +
                    timp.get(Calendar.SECOND);
            repaint();
        }
    }
}

