/**
 * �ھ�̬������ʹ��synchronized���η�����������������������ͬһ���������
 * ֻҪ��һ������ľ�̬�����������synchronized���η���һ���߳��õ������ˣ�����߳̾͵õȴ�
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
		//Ϊ���ܱ�֤��m1������ִ�У��ӳ�1s
		Thread.sleep(1000);
		
		t2.start();
		
	}
}


//����һ��ȡ���߳�
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
	//synchronized��ӵ���̬�����ϣ��߳�ִ�д˷�����ʱ�����������
	public synchronized static void m1(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1......");
	}
	
	//�÷��������m1����Ϊ��û�б� synchronized ����
//	public static void m2(){
//		System.out.println("m2......");
//	}
	
	//�������������Ϊ�ò������������Ի��m1����ִ������Ժ�Ż�ִ��
	public synchronized static void m2(){
		System.out.println("m2......");
	}
	
}






