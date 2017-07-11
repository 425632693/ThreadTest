/**
 * 在静态方法上使用synchronized修饰符，就是类锁，类锁不共享同一个对象对象，
 * 只要是一个类里的静态方法上添加了synchronized修饰符，一个线程拿到类锁了，别的线程就得等待
 * 
 * @author Administrator
 *
 */
public class ThreadTest08 {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Processor6());
		Thread t2 = new Thread(new Processor6());
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		//为了能保证让m1方法先执行，延迟1s
		Thread.sleep(1000);
		
		t2.start();
		
	}
}


//创建一个取款线程
class Processor6 implements Runnable{
	public void run(){
		if("t1".equals(Thread.currentThread().getName())){
			MyClass.m1();
		}
		
		if("t2".equals(Thread.currentThread().getName())){
			MyClass.m2();
		}
		
	}
	
}


class MyClass{
	//synchronized添加到静态方法上，线程执行此方法的时候会找类锁。
	public synchronized static void m1(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1......");
	}
	
	//该方法不会等m1，因为它没有被 synchronized 修饰
//	public static void m2(){
//		System.out.println("m2......");
//	}
	
	//这样这个方法因为拿不到类锁，所以会等m1方法执行完毕以后才会执行
	public synchronized static void m2(){
		System.out.println("m2......");
	}
	
}






