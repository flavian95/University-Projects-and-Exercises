
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Prob3 extends JFrame {

    private JTable jt;
    private JTableHeader jth;
    private DefaultTableModel model;
    private JScrollPane jsp;

    public Prob3() {
        super("The third table");

        String[] columnNames = {"Primitive", "Semantics(Effect)"};
        Object[][] data = {
                {"socket()", "Creates a new endpoint for communication"},
                {"bind()", "Attaches the local address to a socket"},
                {"listen()", "Prepare a socket for accepting connections"},
                {"accept()", "Accept a connection request"},
                {"connect()", "Try to establish a connection"}
        };

        model = new DefaultTableModel(data, columnNames);
        jt = new JTable(model);
        jsp = new JScrollPane(jt);
        jt.setRowHeight(30);
        jt.setShowGrid(true);
        jt.setBackground(Color.white);

        jth = jt.getTableHeader();
        jth.setBackground(Color.LIGHT_GRAY);
        jth.setForeground(Color.black);

        TableColumn tc = jt.getColumnModel().getColumn(0);
        tc.setPreferredWidth(200);

        tc = jt.getColumnModel().getColumn(1);
        tc.setPreferredWidth(200);

        JLabel label = new JLabel("Primitives that act on sockets");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(jsp, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        var f = new Prob3();
        f.setSize(650, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}