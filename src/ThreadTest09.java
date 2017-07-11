/**
 * �ػ��߳�
 * 	�ӷ������߳̿��Է�Ϊ���ࣺ1.�û��߳�	2.�ػ��̡߳�
 * �ػ��̣߳����е��û��߳̽����������ڣ��ػ��̲߳Ż�����������ڣ�
 * 			ֻҪ��һ���û��̴߳��ػ��߳̾�һֱ���ڣ��������
 * �����磺Java�е���������������һ���ػ��̡߳��ػ��߳�һ�㶼������ִ�еġ�
 * @author Administrator
 *
 */
public class ThreadTest09 {

	public static void main(String[] args){
		Thread t1 = new Thread(new Processor7());
		
		t1.setName("t1");
		//��һ���û��߳�����Ϊ�ػ��߳�
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
