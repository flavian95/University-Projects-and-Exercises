
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Fereastra extends JFrame {
    private JList lista;
    private JTextArea ta;
    private JButton b;
    private ColectieCarti colectie;
    private AscultatorButon ab;
    
    public Fereastra(){
        setTitle("comanda carti");
        colectie=ColectieCarti.getInstance();
        lista=new JList(colectie.getCarti());
        var jp=new JPanel();
        jp.add(lista);
        add(jp, BorderLayout.NORTH);
        
        ta=new JTextArea(100, 200);
        add(ta);
        
        var p=new JPanel();
        b=new JButton("Adauga");
        p.add(b);
        ab=new AscultatorButon();
        b.addActionListener(ab);
        add(p, BorderLayout.SOUTH);
        
        
    }
    private class AscultatorButon implements ActionListener{
        private Carte c;
        public void actionPerformed(ActionEvent e){
             c=colectie.getCarte(lista.getSelectedIndex());
             ta.append(c.toString());
            ta.append("\n");
        }
    }
    
    public static void main(String... args){
        var f=new Fereastra();
        f.setSize(400,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}