
/**
 * ��ȡ�̵߳����ȼ�
 * @author Administrator
 *
 */
public class ThreadTest03 {
	
	public static void main(String[] args){
		Thread t = Thread.currentThread();//��ȡ��ǰ�̵߳Ķ���
		System.out.println(t.getName());//��ȡ��ǰ�̵߳�����
		
		Thread t1 = new Thread(new Processor1());
		//���߳�����
		t1.setName("t1");
		
		//�����̵߳����ȼ�
		t1.setPriority(1);
		
		t1.start();
		
		Thread t2 = new Thread(new Processor1());
		t2.setName("t2");
		
		//�����̵߳����ȼ�
		t2.setPriority(8);
		
		t2.start();
		
	}
}

class Processor1 implements Runnable{
	public void run(){

		for(int i = 0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"----->"+i);
		}
		
		//Thread t = Thread.currentThread();//��ȡ��ǰ�̵߳Ķ���
		//System.out.println(t.getName());//��ȡ��ǰ�̵߳�����    �߳�Ĭ�ϵ�������Thread-0��ʼ��������
	}
}





