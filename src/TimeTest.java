import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ���ڶ�ʱ��
 * ���ã� ÿ��һ�ι̶���ʱ��ִ��һ�δ���
 * @author Administrator
 *
 */
public class TimeTest {
	
	public static void main(String[] args) throws Exception{ 
		//1.����һ����ʱ��
		Timer t = new Timer();
		//2.ָ����ʱ��������(���������ֱ��ǣ�1.��ʱ��������	2.��ʲôʱ��ʼִ��		3.ÿ���೤ʱ��ִ��һ��)
		t.schedule(new LogTimerTask(), 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2017-07-11 09:52:00 000"), 
				10*1000);
		
	}
}


//������ʱ����
//һ���ǳ�����̳�һ�������࣬Ҫ���������еĳ��󷽷���д
class LogTimerTask extends TimerTask{
	public void run(){
		//��ӡ��ǰϵͳʱ��
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
}


