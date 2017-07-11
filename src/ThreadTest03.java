
/**
 * 获取线程的优先级
 * @author Administrator
 *
 */
public class ThreadTest03 {
	
	public static void main(String[] args){
		Thread t = Thread.currentThread();//获取当前线程的对象；
		System.out.println(t.getName());//获取当前线程的名称
		
		Thread t1 = new Thread(new Processor1());
		//给线程起名
		t1.setName("t1");
		
		//设置线程的优先级
		t1.setPriority(1);
		
		t1.start();
		
		Thread t2 = new Thread(new Processor1());
		t2.setName("t2");
		
		//设置线程的优先级
		t2.setPriority(8);
		
		t2.start();
		
	}
}

class Processor1 implements Runnable{
	public void run(){

		for(int i = 0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"----->"+i);
		}
		
		//Thread t = Thread.currentThread();//获取当前线程的对象；
		//System.out.println(t.getName());//获取当前线程的名称    线程默认的名字是Thread-0开始依次类推
	}
}





