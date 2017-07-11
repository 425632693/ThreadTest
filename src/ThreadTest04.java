
/**
 * �̵߳�sleep˯�߷���
 * @author Administrator
 *
 */
public class ThreadTest04 {
	
	public static void main(String[] args) throws InterruptedException{
		
		Thread t = new Thread(new Processor2());
		t.setName("t1");
		t.start();
		//������ʹ��t.sleep()������ʹ��Thread.sleep()������һ���ģ�ֻ��������ǰ�̣߳�
		//����������ĸ��߳̾ͱ������ĸ��̵߳�run���������sleep()�����������̵߳�����
		t.sleep(5000);
		
		//����˯���е��̣߳������߳�ʹ�õ���sleep()�������쳣���ƣ�Ҳ���Ǵ�����sleep()������try...catch...�쳣
		t.interrupt();
		
	}
}

/**
 * Thread�е�run�������׳��쳣��������дrun����֮����run����������λ���ϲ���ʹ��throws,
 * ����run�����е��쳣ֻ�� try...catch...
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
