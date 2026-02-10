import java.util.*;
import java.io.*;
public class ColectieCarti {//m.p singleton
    private static ColectieCarti instance;//=null
    private ArrayList<Carte> lc;
    private ColectieCarti(){
        lc=new ArrayList<>();
        citesteFisier();
    }
    
    public static ColectieCarti getInstance(){
        if(instance==null) instance=new ColectieCarti();
        return instance;
    }
    
     private void citesteFisier(){
      try{
          String linie;
          String[] s;
          BufferedReader br=new BufferedReader(new FileReader("src/carti.txt"));
          while((linie=br.readLine())!=null) {
              s=linie.split("[.]");
              lc.add(new Carte(s[0], s[1]));
          }
          br.close();
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
