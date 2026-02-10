
import javax.swing.*;

public class FereastraCeas extends JFrame {
    public static void main(String... args) {
        var c1 = new CanvasCeas("Roma", -1);
        var c2 = new CanvasCeas("Bucuresti", 0);
        var c3 = new CanvasCeas("Chisinau", 1);

        var f = new FereastraCeas();
        f.setLayout(null);

        c1.setBounds(0, 0, 125, 125);
        c2.setBounds(130, 0, 125, 125);
        c3.setBounds(260, 0, 125, 125);

        f.add(c1);
        f.add(c2);
        f.add(c3);

        f.setTitle("Ceas digital");
        f.setSize(500, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
