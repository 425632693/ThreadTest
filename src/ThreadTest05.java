
/**
 * 终止线程
 * @author Administrator
 *
 */
public class ThreadTest05 {
	
	public static void main(String[] args) throws InterruptedException{
		Processor3 p = new Processor3();
		Thread t = new Thread(p);
		t.setName("t1");
		t.start();
		//在这里使用t.sleep()方法和使用Thread.sleep()方法是一样的，只会阻塞当前线程，
		//如果想休眠哪个线程就必须在哪个线程的run方法里调用sleep()方法来进行线程的休眠
		t.sleep(5000);
		
		//唤醒睡眠中的线程，唤醒线程使用的是sleep()方法的异常机制，也就是触发了sleep()方法的try...catch...异常
//		t.interrupt();
		
		//给线程中的标识一个布尔类型的值来中断线程
		p.run = false;
		
	}
}

/**
 * Thread中的run方法不抛出异常，所以重写run方法之后，在run方法声明的位置上不能使用throws,
 * 所以run方法中的异常只能 try...catch...
 * @author Administrator
 *
 */
class Processor3 implements Runnable{
	//声明一个布尔类型的值来标识是都终止线程
	boolean run = true;
	
	public void run(){
		for(int i = 0;i<10;i++){
			if(run){
				try {
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+"----->"+i);
				} catch (InterruptedException e) {}
			}
			else{
//				System.out.println(run);
				return;
			}
		
		}
		
	}
}
