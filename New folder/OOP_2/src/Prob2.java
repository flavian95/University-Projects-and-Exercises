import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Prob2 extends JFrame {

    private JTable jt;
    private JTableHeader jth;
    private DefaultTableModel model;
    private JScrollPane jsp;

    public Prob2() {
        super("The second table");

        String[] columnNames = {"Year", "Date", "OS", "Notes"};
        Object[][] data = {
                {"1981", "04.08.81", "MS-DOS 1.0", ""},
                {"1983", "08.03.82", "MS-DOS 2.0", "can handle floppy disks 5 25\", 360 Kb and Hard-disc of max 32 Mb"},
                {"1985", "07.03.85", "MS-DOS 3.1", "can handle floppy disks 5 25\" and local networks"},
                {"2025", "01.04.2025", "Windows 11", "can handle all"}
        };

        model = new DefaultTableModel(data, columnNames);
        jt = new JTable(model);
        jsp = new JScrollPane(jt);
        jt.setRowHeight(30);
        jt.setShowGrid(true);
        jt.setBackground(Color.lightGray);

        jth = jt.getTableHeader();
        jth.setBackground(Color.DARK_GRAY);
        jth.setForeground(Color.white);

        TableColumn tc = jt.getColumnModel().getColumn(2);
        tc.setPreferredWidth(100);

        tc = jt.getColumnModel().getColumn(3);
        tc.setPreferredWidth(450);

        add(jsp);
    }

    public static void main(String[] args) {
        var f = new Prob2();
        f.setSize(650, 300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

