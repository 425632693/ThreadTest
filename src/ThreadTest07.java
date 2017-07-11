/**
 * ����ʵ����ʹ���߳�ͬ���������ݵİ�ȫ
 * 
 * @author Administrator
 *
 */
public class ThreadTest07 {

	public static void main(String[] args) throws InterruptedException {
		//����һ���������˻�
		User user = new User("zhangsan",5000.0);
		
		//�����̶߳���
		Processor5 p5 = new Processor5(user);
		
		//�����̶߳�ͬһ���˻���ʼȡ�����
		Thread t1 = new Thread(p5);
		Thread t2 = new Thread(p5);
		
		
		t1.start();
		t2.start();
		
	}
}


//����һ��ȡ���߳�
class Processor5 implements Runnable{
	
	//Ϊ��ʵ�ֶ��̹߳���һ���˻�����Ҫ����һ���˻��ĳ�Ա������������һ������Ĺ��췽��
	User user;
	
	Processor5(User user){
		this.user = user;
	}
	
	
	public void run(){
		user.withdraw(1000.0);
		System.out.println("ȡ��1000�ɹ�����"+user.getBalance());
	}
}




// ����һ���˻�
class User {
	private String actno;//�˻�
	private double balance;//���
	

	public User() {}

	public User(String actno, double balance) {
		super();
		this.actno = actno;
		this.balance = balance;
		
	}

	public String getActno() {
		return actno;
	}

	public void setActno(String actno) {
		this.actno = actno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	/**
	 * �ڶ���ʵ��ͬ���̵߳ķ������ڳ�Ա��������� synchronized �ؼ���
	 * @param money
	 */
	//�����ṩһ��ȡ��ķ���
	public synchronized void withdraw(double money){
		/**
		 * synchronized (this){} �����ԭ����t1 �� t2 ����ʾ�����߳�
		 * 		��t1�߳�ִ�е��˴��������� synchronized �ؼ��֣��ͻ�ȥ��this�Ķ�������
		 * 		����ҵ���this�Ķ������������������ִ�г��򡣵� t1 �߳�ִ����ͬ������
		 * 		�еĴ��룬t1 ���this�Ķ������黹��
		 * 
		 * 		�� t1 ִ�� synchronized �����ʱ����� t2 Ҳ�������ˣ����� synchronized
		 * 		�ؼ��֣�Ҳ��ȥ�� this �Ķ���������ʱ���� this �Ķ������� t1 �����У�t2 ���Ҳ���this��
		 * 		�������ģ����� t2 �ͻ�������ȴ���ֻ�е� t1 �� synchronized ����ִ����ϣ����Ұ� this ��
		 * 		�������黹�Ժ�Ż��õ� this �Ķ��������ſ���ִ�� synchronized ���顣
		 * 
		 * 		��ÿ���߳�����synchronized �ؼ��ֵ�ʱ�򶼻�ȥ�� this �Ķ�������this�Ķ�����ֻ��һ�ѣ�
		 * 		�ҵ���ִ��synchronized �����еĴ��룬�Ҳ����͵ȴ���
		 * 		
		 */
		//�߳�ͬ�������飬(��������д���ǹ������,һ����this)
//		synchronized (this) {
			double after = balance-money;//ȡ�����
			
			try {
				Thread.sleep(1000);//��Ӹ��ӳ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//�������
			this.setBalance(after);
//		}
	}
}