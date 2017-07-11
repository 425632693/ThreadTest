/**
 * 以下实例是使用线程同步保护数据的安全
 * 
 * @author Administrator
 *
 */
public class ThreadTest07 {

	public static void main(String[] args) throws InterruptedException {
		//创建一个公共的账户
		User user = new User("zhangsan",5000.0);
		
		//创建线程对象
		Processor5 p5 = new Processor5(user);
		
		//创建线程对同一个账户开始取款操作
		Thread t1 = new Thread(p5);
		Thread t2 = new Thread(p5);
		
		
		t1.start();
		t2.start();
		
	}
}


//创建一个取款线程
class Processor5 implements Runnable{
	
	//为了实现多线程共享一个账户，需要声明一个账户的成员变量，并创建一个对外的构造方法
	User user;
	
	Processor5(User user){
		this.user = user;
	}
	
	
	public void run(){
		user.withdraw(1000.0);
		System.out.println("取款1000成功，余额："+user.getBalance());
	}
}




// 创建一个账户
class User {
	private String actno;//账户
	private double balance;//余额
	

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
	 * 第二种实现同步线程的方法，在成员方法上添加 synchronized 关键字
	 * @param money
	 */
	//对外提供一个取款的方法
	public synchronized void withdraw(double money){
		/**
		 * synchronized (this){} 语句块的原理：有t1 和 t2 来表示两个线程
		 * 		当t1线程执行到此处，遇见了 synchronized 关键字，就会去找this的对象锁，
		 * 		如果找到了this的对象锁，则进入语句块中执行程序。当 t1 线程执行完同步语句块
		 * 		中的代码，t1 会把this的对象锁归还。
		 * 
		 * 		在 t1 执行 synchronized 语句块的时候，如果 t2 也来到这了，遇见 synchronized
		 * 		关键字，也会去找 this 的对象锁，此时由于 this 的对象锁是 t1 所持有，t2 是找不到this的
		 * 		对象锁的，所以 t2 就会在这里等待，只有等 t1 把 synchronized 语句块执行完毕，并且把 this 的
		 * 		对象锁归还以后才会拿到 this 的对象锁，才可以执行 synchronized 语句块。
		 * 
		 * 		当每个线程遇见synchronized 关键字的时候都会去找 this 的对象锁，this的对象锁只有一把，
		 * 		找到就执行synchronized 语句块中的代码，找不到就等待。
		 * 		
		 */
		//线程同步的语句块，(括号里填写的是共享对象,一般是this)
//		synchronized (this) {
			double after = balance-money;//取款后（余额）
			
			try {
				Thread.sleep(1000);//添加个延迟
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//更新余额
			this.setBalance(after);
//		}
	}
}