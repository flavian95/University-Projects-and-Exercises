
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Choose the color", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        DrawingPanel colorPanel = new DrawingPanel();
        colorPanel.setBackground(Color.WHITE);
        frame.add(colorPanel, BorderLayout.CENTER);

        String[] colors = { "White", "Red", "Green", "Blue" };
        JComboBox<String> colorComboBox = new JComboBox<>(colors);
        frame.add(colorComboBox, BorderLayout.SOUTH);

        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        colorPanel.setCurrentColor(Color.RED);
                        break;
                    case "Green":
                        colorPanel.setCurrentColor(Color.GREEN);
                        break;
                    case "Blue":
                        colorPanel.setCurrentColor(Color.BLUE);
                        break;
                    default:
                        colorPanel.setCurrentColor(Color.WHITE);
                        break;
                }
            }
        });

        frame.setVisible(true);
    }

    static class DrawingPanel extends JPanel {
        private Color currentColor = Color.WHITE;
        private int startX, startY, endX, endY;

        public DrawingPanel() {
            ListenerMouseEvent listener = new ListenerMouseEvent();
            addMouseListener(listener);
            addMouseMotionListener(listener);
        }

        public void setCurrentColor(Color color) {
            this.currentColor = color;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(currentColor);
            int width = Math.abs(endX - startX);
            int height = Math.abs(endY - startY);
            int x = Math.min(startX, endX);
            int y = Math.min(startY, endY);
            g.fillRect(x, y, width, height);
        }

        private class ListenerMouseEvent extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();
                repaint();
            }
        }
    }
}