/**
 * ����ʵ����û��ʹ���߳�ͬ����
 * 
 * @author Administrator
 *
 */
public class ThreadTest06 {

	public static void main(String[] args) throws InterruptedException {
		//����һ���������˻�
		Account act = new Account("zhangsan",5000.0);
		
		//�����̶߳���
		Processor4 p4 = new Processor4(act);
		
		//�����̶߳�ͬһ���˻���ʼȡ�����
		Thread t1 = new Thread(p4);
		Thread t2 = new Thread(p4);
		
		
		t1.start();
		t2.start();
		
	}
}


//����һ��ȡ���߳�
class Processor4 implements Runnable{
	
	//Ϊ��ʵ�ֶ��̹߳���һ���˻�����Ҫ����һ���˻��ĳ�Ա������������һ������Ĺ��췽��
	Account act;
	
	Processor4(Account act){
		this.act = act;
	}
	
	
	public void run(){
		act.withdraw(1000.0);
		System.out.println("ȡ��1000�ɹ�����"+act.getBalance());
	}
}




// ����һ���˻�
class Account {
	private String actno;//�˻�
	private double balance;//���
	

	public Account() {}

	public Account(String actno, double balance) {
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
	
	

	//�����ṩһ��ȡ��ķ���
	public void withdraw(double money){
//		double before = this.balance;//ȡ��ǰ
		double after = balance-money;//ȡ�����
		
		try {
			Thread.sleep(1000);//��Ӹ��ӳ�
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�������
		this.setBalance(after);
	}

	
}