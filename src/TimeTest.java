import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 关于定时器
 * 作用： 每隔一段固定的时间执行一段代码
 * @author Administrator
 *
 */
public class TimeTest {
	
	public static void main(String[] args) throws Exception{ 
		//1.创建一个定时器
		Timer t = new Timer();
		//2.指定定时器的任务(三个参数分别是：1.定时器的任务	2.从什么时候开始执行		3.每隔多长时间执行一次)
		t.schedule(new LogTimerTask(), 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2017-07-11 09:52:00 000"), 
				10*1000);
		
	}
}


//创建定时任务
//一个非抽象类继承一个抽象类，要将抽象类中的抽象方法重写
class LogTimerTask extends TimerTask{
	public void run(){
		//打印当前系统时间
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
}


