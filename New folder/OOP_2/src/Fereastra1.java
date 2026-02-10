
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Fereastra1 extends JFrame {
    private JList lista;
    private JTextArea ta;
    private JButton b1,b2;
    private ColectieCarti3 colectie;
    private AscultatorButon ab;
    
    public Fereastra1(){
        setTitle("comanda carti");
        colectie=ColectieCarti3.getInstance();
        lista=new JList(colectie.getCarti());
        var jp=new JPanel();
        jp.add(lista);
        add(jp, BorderLayout.NORTH);
        
        ta=new JTextArea(100, 200);
        add(ta);
        
        var p=new JPanel();
        b1=new JButton("Adauga");
        p.add(b1);
        b2=new JButton("Calculeaza cost");
        p.add(b2);
        ab=new AscultatorButon();
        b1.addActionListener(ab);
        b2.addActionListener(ab);
        add(p, BorderLayout.SOUTH);
        
        
    }
    private class AscultatorButon implements ActionListener{
        private Carte c;
        private double costLei, costEuro;
        private ArrayList<Carte> indecsi;
        AscultatorButon(){
           indecsi=new ArrayList<>();
        }
        public void actionPerformed(ActionEvent e){
             c=colectie.getCarte(lista.getSelectedIndex());
             indecsi.add(c);
            if(e.getSource()==b1){
            
             ta.append(c.toString());
             ta.append("\n");
            }
            else {
                if(!indecsi.isEmpty()){
                    for(Carte c1: indecsi)
                        if(c1.getValuta().equals("lei")) costLei+=c1.getPret();
                                                        else costEuro+=c1.getPret();
                ta.append("You have to pay "+costLei+" lei"+" and "+costEuro+" euro\n");
                costLei=0;
                costEuro=0;
                }
            }
        }
    }
    
    public static void main(String... args){
        var f=new Fereastra1();
        f.setSize(400,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

            
}
