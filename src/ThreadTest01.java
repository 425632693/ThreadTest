/**
 * ��java������ʵ�ֶ��̵߳ĵ�һ�ַ���
 * 	1.�̳�java.lang.Thread;
 * 	2.��дrun()����;
 * ��δ����̣߳�
 * ��������̣߳�
 * @author Administrator
 *
 */
public class ThreadTest01 {
	
	public static void main(String[] args){
		
		//�����߳�
		Thread t = new Processor();
		//�����߳�
		t.start();
		
		for(int i=0;i<10;i++){
			System.out.println("main--->"+i);
		}
	}
}

//����һ���߳�
class Processor extends Thread{
	//��дrun����
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("run--->"+i);
		}
	}
}
