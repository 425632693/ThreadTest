
/**
 * 死锁
 * @author Administrator
 *
 */
public class DeadLock {

	public static void main(String[] args){
		
		Object o1 = new Object();
		Object o2 = new Object();
		
		Thread t1 = new Thread(new T1(o1,o2));
		Thread t2 = new Thread(new T2(o1,o2));
		
		t1.start();
		t2.start();
		
	}
}

//定义T1线程
class T1 implements Runnable{
	
	Object o1;
	Object o2;
	
	public T1(Object o1, Object o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}

	public void run(){
		synchronized (o1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o2) {
				
			}
		}
	}
}

//定义T2线程
class T2 implements Runnable{
	
	Object o1;
	Object o2;
	
	public T2(Object o1, Object o2) {
		super();
		this.o1 = o1;
		this.o2 = o2;
	}
	
	public void run(){
		synchronized (o2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (o1) {
				
			}
		}
	}
}


