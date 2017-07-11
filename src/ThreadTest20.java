/*
	关于Timer定时器的应用
	作用：每隔一段固定的时间执行一段代码
	
	wait();等待
	notify();唤醒
*/
import java.util.*;
import java.text.*;

public class ThreadTest20
{
	public static void main(String[] args) throws Exception{
		//1.创建定时器
		Timer t=new Timer();
		//2.指定定时任务t.schedule(TimerTask task, Date firstTime,long period);参数一为定时任务，参数二为开始时间，参数三为间隔时间
		t.schedule(
			new LogTimerTask(),
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse("2017-07-11 18:26:00 000"),
			10*1000);

	}
}
//指定定时任务
class LogTimerTask extends TimerTask
{
	public void run(){
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
	}
}