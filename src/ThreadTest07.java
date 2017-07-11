/*
*
	1.线程的调度与控制
		
		通常我们计算机只有一个CPU，cpu在某一时刻只能执行一条指令，线程只有得到CPU
	时间片，也就是使用权，才可以执行命令。在单核CPU的机器上线程并不是并行运行的，只有在多个Cpu
	上线程才可以并行运行。
		java虚拟机要负责线程的调度，取得CPU的使用权。
		目前有两种调度模式：分时调度模式和抢占式调度模式，java使用抢占式调度模式
		分式调度模式：所有线程轮流使用CPU的使用权，平均分配每个线程占用CPU的时间片
		抢占式调度模式：优先级高的线程获取CPU时间片相对多一些，如果线程的优先级相同，那么会随机选择一个

	2.线程优先级(从1到10)
		MAX_PRIORITY(最高级)=10，MIN_PRIORITY(最低级)=1，NORM_PRIORITY(标准)默认=5


*/

/*
*三个方法：
	1.获取当前线程对象Thread.currentThread();
	2.给线程起名 t.setName("t1");
	3.获取线程的名字 t.getName();
*/
public class ThreadTest07
{
	public static void main(String[] args){
		//如何获取当前线程对象？ 
		//static Thread currentThread()返回对当前正在执行的线程对象的引用
		Thread t=Thread.currentThread();//t保存的内存地址指向的线程是主线程对象
		//获取线程的名字
		System.out.println(t.getName());//main

		//创建线程
		Thread t1=new Thread(new Processor7());
		//给线程起名
		t1.setName("t1");
		//启动线程
		t1.start();//Thread-0

		Thread t2=new Thread(new Processor7());
		t2.setName("t2");
		t2.start();//Thread-1
	}
}

class Processor7 implements Runnable
{
	public void run(){
		Thread t=Thread.currentThread();//t保存的内存地址指向的线程是t1线程
		System.out.println(t.getName());//Thread-0
	}
}