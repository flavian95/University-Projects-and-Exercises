package Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex2 extends JFrame {
    private JList list;
    private JTextArea textarea;
    private JButton btn;
    private BooksCollection collection;
    private BtnListener btnListener;

    public ex2() {
        setTitle("Order books");
        collection = BooksCollection.getInstance();
        collection = BooksCollection.getInstance();
        list = new JList(collection.getBooks());

        add(list, BorderLayout.NORTH);

        textarea = new TextArea(100, 200);
        add(textarea);

        var panel = new JPanel;
        btn= new JButton("Add");
        panel.add(btn);
        p.add(b2);
        btn.addActionListener(btnListener);
        b2.addActionListener(b2);
        add(panel, BorderLayout.SOUTH)

        private class BtnListener implements ActionListener(){
            private double costL, costE;
            if(e.getSource=b1){
            public void ActionListener(ActionEvent e){
                collection..getBook(list.getSelectedIndex());
                textarea.append(c.getInfo());
                textarea.append("\n");
            }
            }
            else(){
                if(c.getCurrency().equals("lei")) costL += c.getPrice;
                else costE+= c.getPrice();
                textarea.append("You have to pay" + costL + "lei" + "and" + costE "euro\n");
                costL = 0;
                costE= 0;
            }
        }

        public static void main(String... args){
            var window = new ex2();
            window.setSize(400, 300);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }
}
