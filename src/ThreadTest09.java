/**
 * 守护线程
 * 	从分类上线程可以分为两类：1.用户线程	2.守护线程。
 * 守护线程：所有的用户线程结束生命周期，守护线程才会结束生命周期，
 * 			只要有一个用户线程存活，守护线程就一直存在，不会结束
 * 。例如：Java中的垃圾回收器就是一个守护线程。守护线程一般都是无限执行的。
 * @author Administrator
 *
 */
public class ThreadTest09 {

	public static void main(String[] args){
		Thread t1 = new Thread(new Processor7());
		
		t1.setName("t1");
		//将一个用户线程设置为守护线程
		t1.setDaemon(true);
		
		t1.start();
		
		for(int i = 0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"----->"+i);
		}
		
	}
}


class Processor7 implements Runnable{

	public void run() {
		int i = 0;
		while(true){
			i++;
			System.out.println(Thread.currentThread().getName()+"---->"+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
