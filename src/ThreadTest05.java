
/**
 * ��ֹ�߳�
 * @author Administrator
 *
 */
public class ThreadTest05 {
	
	public static void main(String[] args) throws InterruptedException{
		Processor3 p = new Processor3();
		Thread t = new Thread(p);
		t.setName("t1");
		t.start();
		//������ʹ��t.sleep()������ʹ��Thread.sleep()������һ���ģ�ֻ��������ǰ�̣߳�
		//����������ĸ��߳̾ͱ������ĸ��̵߳�run���������sleep()�����������̵߳�����
		t.sleep(5000);
		
		//����˯���е��̣߳������߳�ʹ�õ���sleep()�������쳣���ƣ�Ҳ���Ǵ�����sleep()������try...catch...�쳣
//		t.interrupt();
		
		//���߳��еı�ʶһ���������͵�ֵ���ж��߳�
		p.run = false;
		
	}
}

/**
 * Thread�е�run�������׳��쳣��������дrun����֮����run����������λ���ϲ���ʹ��throws,
 * ����run�����е��쳣ֻ�� try...catch...
 * @author Administrator
 *
 */
class Processor3 implements Runnable{
	//����һ���������͵�ֵ����ʶ�Ƕ���ֹ�߳�
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
