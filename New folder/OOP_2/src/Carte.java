
public class Carte {
    private String titlu, editura;
    private double pret;
    private String valuta;
    
    public Carte(String t, String e){
        titlu=t;
        editura=e;
    }
     public Carte(String t, String e, double p, String v){
        titlu=t;
        editura=e;
        pret=p;
        valuta=v;
    }
    
   public String toString(){
       var sb=new StringBuffer();
       sb.append(titlu);
       sb.append(".");
       sb.append(editura);
       return sb.toString();
   }
   public double getPret(){
       return pret;
   }
   public String getValuta(){
       return this.valuta;
   }
}
