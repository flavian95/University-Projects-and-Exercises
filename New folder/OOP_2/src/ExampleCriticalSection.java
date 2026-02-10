class Counter implements Runnable{
	public static int number; 
	
	public synchronized void increment(){
		//synchronized(this){
		number++;
		System.out.print(number+" ");
		//}
		}
	public void run(){
		increment();
		increment();
		increment();
increment();
		}	
	}
public class ExampleCriticalSection{
    public static void main(String[] args) {
    	Counter c=new Counter();
    	Thread t1=new Thread(c);
    	Thread t2=new Thread(c);
    	Thread t3=new Thread(c);
    	t1.start();
    	t2.start();
    	t3.start();
    }
}
