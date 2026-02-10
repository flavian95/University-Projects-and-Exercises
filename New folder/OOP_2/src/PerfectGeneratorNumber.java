public class PerfectGeneratorNumber extends Thread{
 private int limit;
 public PerfectGeneratorNumber (int l){
  limit=l;
 }
 public void run(){
  int i=1;
  int nr=1;
  while(nr<=limit){
   if(verifyPerfectNr(nr)) System.out.println("A perfect number: "+nr);
   try{
    Thread.sleep(100);
   }catch(InterruptedException e){e.printStackTrace();}
   nr++;
  }
 }
 private boolean verifyPerfectNr(int n){
  int sum=1;
  for(int i=2;i<=n/2; i++) if (n%i==0) sum+=i;
  return sum==n;
 }
 public static void main(String[] args){
  var gnp=new PerfectGeneratorNumber(10000);
  gnp.start();
 }	
}
