import java.util.*;
import java.io.*;
public class ColectieCarti3 {//m.p singleton
    private static ColectieCarti3 instance;//=null
    private ArrayList<Carte> lc;
    private ColectieCarti3(){
        lc=new ArrayList<>();
        citesteFisier();
    }
    
    public static ColectieCarti3 getInstance(){
        if(instance==null) instance=new ColectieCarti3();
        return instance;
    }
    
     private void citesteFisier(){
      try{
          String linie1, linie2;
          String[] s1, s2;
          var br1=new BufferedReader(new FileReader("src/carti.txt"));
          var br2=new BufferedReader(new FileReader("src/preturi.txt"));
          while(br1.ready()&&br2.ready()) {
              linie1=br1.readLine();
              linie2=br2.readLine();
              System.out.println(linie1+" "+linie2);
             s1=linie1.split("[.]");
              s2=linie2.split(" ");
              lc.add(new Carte(s1[0], s1[1], Double.parseDouble(s2[0]), s2[1]));
          }
          br1.close();
          br2.close();
      }catch(IOException e){e.printStackTrace();}
     }
    
     public Object[] getCarti(){
         return lc.toArray();
     }
     public Carte getCarte(int poz){
        if(poz>=0&& poz<lc.size()) return lc.get(poz);
        return null;
     }
     
    // public void scrieFisier
}
