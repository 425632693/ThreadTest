
/**
 * 线程的sleep睡眠方法
 * @author Administrator
 *
 */
public class ThreadTest04 {
	
	public static void main(String[] args) throws InterruptedException{
		
		Thread t = new Thread(new Processor2());
		t.setName("t1");
		t.start();
		//在这里使用t.sleep()方法和使用Thread.sleep()方法是一样的，只会阻塞当前线程，
		//如果想休眠哪个线程就必须在哪个线程的run方法里调用sleep()方法来进行线程的休眠
		t.sleep(5000);
		
		//唤醒睡眠中的线程，唤醒线程使用的是sleep()方法的异常机制，也就是触发了sleep()方法的try...catch...异常
		t.interrupt();
		
	}
}

/**
 * Thread中的run方法不抛出异常，所以重写run方法之后，在run方法声明的位置上不能使用throws,
 * 所以run方法中的异常只能 try...catch...
 * @author Administrator
 *
 */
class Processor2 implements Runnable{
	public void run(){
		
		try {
			Thread.sleep(900000000);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"----->"+i);
		}
	}
}
