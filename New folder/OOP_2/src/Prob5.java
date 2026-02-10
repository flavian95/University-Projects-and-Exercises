
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prob5 extends JFrame {
    private JLabel label;
    private JComboBox<String> chooseSign;
    private JLabel imageLabel;

    public Prob5() {
        super("The fifth table");

        String[] zodiacSigns = {"Pisces", "Taurus"};

        label = new JLabel("Please choose your zodiac sign:");
        chooseSign = new JComboBox<>(zodiacSigns);
        imageLabel = new JLabel();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(label);
        topPanel.add(chooseSign);

        add(topPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        updateImage((String) chooseSign.getSelectedItem());

        chooseSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSign = (String) chooseSign.getSelectedItem();
                updateImage(selectedSign);
            }
        });
    }

    private void updateImage(String sign) {
        String imagePath = null;
        if ("Pisces".equals(sign)) {
            imagePath = "/pisces.jpg";
        } else if ("Taurus".equals(sign)) {
            imagePath = "/taurus.jpg";
        }

        if (imagePath != null) {
            java.net.URL imgURL = getClass().getResource(imagePath);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
            } else {
                imageLabel.setText("Image not found.");
                imageLabel.setIcon(null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var f = new Prob5();
            f.setSize(650, 400);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}