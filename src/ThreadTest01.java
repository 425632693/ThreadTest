/**
 * 在java语言中实现多线程的第一种方法
 * 	1.继承java.lang.Thread;
 * 	2.重写run()方法;
 * 如何创建线程？
 * 如何启动线程？
 * @author Administrator
 *
 */
public class ThreadTest01 {
	
	public static void main(String[] args){
		
		//创建线程
		Thread t = new Processor();
		//启动线程
		t.start();
		
		for(int i=0;i<10;i++){
			System.out.println("main--->"+i);
		}
	}
}

//定义一个线程
class Processor extends Thread{
	//重写run方法
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("run--->"+i);
		}
	}
}
