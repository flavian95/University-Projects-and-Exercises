
public class TestFirExecutie {
    public static void main(String... args){
        var f1=new Thread(new FirExecutie()); 
         var f2=new FirExecutie1();
         var f3=new Factorial(10);
         
        f1.start();
        f2.start();
        f3.start();
    }
}
