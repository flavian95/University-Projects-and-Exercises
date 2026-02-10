public class NumberCombinations extends Thread{
 private int n, m;
 private Factorial1 f;
 public NumberCombinations(int n, int m){
  this.n=n;
  this.m=m;
 }
 public void run(){
  System.out.println("Combinations of "+n+" taken by "+ m+"="+ 
   calculateCombinations());
 }
 private long calculateCombinations(){
  Factorial1 f=new Factorial1(n);
  f.start();
  try{
   f.join(); 
  }catch(InterruptedException e){}
  long numerator=f.getResult();
  f=new Factorial1(m);
  f.start();
  try{
	f.join(); 
  }catch(InterruptedException e){}
  long denominator1=f.getResult();
  f=new Factorial1(n-m);
  f.start();
  try{
	f.join(); 
  }catch(InterruptedException e){}
  long denominator2=f.getResult();
  return numerator/(denominator1*denominator2);
 }
}
