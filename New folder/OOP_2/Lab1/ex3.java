import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Order Pizza");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        JPanel margheritaPanel = new JPanel();
        margheritaPanel.setLayout(new FlowLayout());
        JLabel margheritaLabel = new JLabel("Margherita: (5.5 EUR)");
        JTextField margheritaField = new JTextField(5);
        margheritaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        margheritaPanel.add(margheritaLabel);
        margheritaPanel.add(margheritaField);

        JPanel quattroFormaggiPanel = new JPanel();
        quattroFormaggiPanel.setLayout(new FlowLayout());
        JLabel quattroFormaggiLabel = new JLabel("Quattro Formaggi: (4.5 EUR)");
        JTextField quattroFormaggiField = new JTextField(5);
        quattroFormaggiField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        quattroFormaggiPanel.add(quattroFormaggiLabel);
        quattroFormaggiPanel.add(quattroFormaggiField);

        JPanel funghiPorciniPanel = new JPanel();
        funghiPorciniPanel.setLayout(new FlowLayout());
        JLabel funghiPorciniLabel = new JLabel("Funghi Porcini: (6.0 EUR)");
        JTextField funghiPorciniField = new JTextField(5);
        funghiPorciniField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        funghiPorciniPanel.add(funghiPorciniLabel);
        funghiPorciniPanel.add(funghiPorciniField);

        JPanel quattroStagioniPanel = new JPanel();
        quattroStagioniPanel.setLayout(new FlowLayout());
        JLabel quattroStagioniLabel = new JLabel("Quattro Stagioni: (5.8 EUR)");
        JTextField quattroStagioniField = new JTextField(5);
        quattroStagioniField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        quattroStagioniPanel.add(quattroStagioniLabel);
        quattroStagioniPanel.add(quattroStagioniField);

        JPanel totalPanel = new JPanel();
        totalPanel.setLayout(new FlowLayout());
        JLabel totalLabel = new JLabel("Total");
        JTextField totalField = new JTextField(5);
        totalField.setEditable(false);
        totalPanel.add(totalLabel);
        totalPanel.add(totalField);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton btn = new JButton("Order");
        btn.setPreferredSize(new Dimension(frame.getWidth() / 2, 20));
        btnPanel.add(btn);
        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(frame.getWidth() / 2, 20));
        btnPanel.add(spacer);

        frame.add(margheritaPanel);
        frame.add(quattroFormaggiPanel);
        frame.add(funghiPorciniPanel);
        frame.add(quattroStagioniPanel);
        frame.add(totalPanel);
        frame.add(btnPanel);

        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal(margheritaField, quattroFormaggiField, funghiPorciniField, quattroStagioniField,
                        totalField);
            }
        });
    }

    public static void calculateTotal(
            JTextField margheritaField, JTextField quattroFormaggiField, JTextField funghiPorciniField,
            JTextField quattroStagioniField, JTextField totalField) {
        double total = 0;

        try {
            int margheritaQuantity = Integer.parseInt(margheritaField.getText().trim());
            if (margheritaQuantity > 0) {
                total += 5.5 * margheritaQuantity;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Margherita quantity");
        }

        try {
            int quattroFormaggiQuantity = Integer.parseInt(quattroFormaggiField.getText().trim());
            if (quattroFormaggiQuantity > 0) {
                total += 4.5 * quattroFormaggiQuantity;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Quattro Formaggi quantity");
        }

        try {
            int funghiPorciniQuantity = Integer.parseInt(funghiPorciniField.getText().trim());
            if (funghiPorciniQuantity > 0) {
                total += 6 * funghiPorciniQuantity;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Funghi Porcini quantity");
        }

        try {
            int quattroStagioniQuantity = Integer.parseInt(quattroStagioniField.getText().trim());
            if (quattroStagioniQuantity > 0) {
                total += 5.8 * quattroStagioniQuantity;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Quattro Stagioni quantity");
        }

        totalField.setText(String.format("%.2f", total));

        System.out.println("Total: $" + total);
    }
}