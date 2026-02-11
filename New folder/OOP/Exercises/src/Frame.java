
import java.awt.*;

class Frame extends java.awt.Frame {

    public Frame(String title) {
        super(title);
        setLayout(new FlowLayout());
    }

    public void addComponent(Component component) {
        super.add(component);
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
}