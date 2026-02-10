public class Factorial1 extends Thread{
 private int number;
 private long result;
 public Factorial1(int n){
  number=n;
 }
 public void run(){
  result=calculateFactorial();
 }
 private long calculateFactorial(){
  long f=1;
  for(int i=2;i<=number; i++) f*=i;
  return f;
 }
 public long getResult(){
  return result;
 }	
}
