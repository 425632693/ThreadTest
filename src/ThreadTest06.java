/**
 * 以下实例是没有使用线程同步的
 * 
 * @author Administrator
 *
 */
public class ThreadTest06 {

	public static void main(String[] args) throws InterruptedException {
		//创建一个公共的账户
		Account act = new Account("zhangsan",5000.0);
		
		//创建线程对象
		Processor4 p4 = new Processor4(act);
		
		//创建线程对同一个账户开始取款操作
		Thread t1 = new Thread(p4);
		Thread t2 = new Thread(p4);
		
		
		t1.start();
		t2.start();
		
	}
}


//创建一个取款线程
class Processor4 implements Runnable{
	
	//为了实现多线程共享一个账户，需要声明一个账户的成员变量，并创建一个对外的构造方法
	Account act;
	
	Processor4(Account act){
		this.act = act;
	}
	
	
	public void run(){
		act.withdraw(1000.0);
		System.out.println("取款1000成功，余额："+act.getBalance());
	}
}




// 创建一个账户
class Account {
	private String actno;//账户
	private double balance;//余额
	

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
	
	

	//对外提供一个取款的方法
	public void withdraw(double money){
//		double before = this.balance;//取款前
		double after = balance-money;//取款后（余额）
		
		try {
			Thread.sleep(1000);//添加个延迟
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//更新余额
		this.setBalance(after);
	}

	
}