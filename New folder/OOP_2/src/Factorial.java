public class Factorial extends Thread{
 private int number;
 public Factorial(int n){
  number=n;
 }
 public void run(){
  System.out.println("Factorial of "+number+" is equal with "+ calculateFactorial());
 }
 private long calculateFactorial(){
  long f=1;
  for(int i=2;i<=number; i++) f*=i;
  return f;
 }
}
