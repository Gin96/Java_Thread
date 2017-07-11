/*
	类锁，类只有一个，所以锁是类级别，只有一个
	synchronized添加到静态方法上，线程执行就需要类锁，类锁与对象无关。
*/
public class ThreadTest17
{
	public static void main(String[] args) throws Exception{
		Thread t1=new Thread(new Processor17());
		Thread t2=new Thread(new Processor17());
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		Thread.sleep(1000);//延迟，保证t1先执行
		t2.start();
	}
}
class Processor17 implements Runnable
{
	public void run(){
		if("t1".equals(Thread.currentThread().getName())){
			Myclass.m1();
		}
		if("t2".equals(Thread.currentThread().getName())){
			Myclass.m2();
		}
	}
}
class Myclass
{
	//synchronized添加到静态方法上，线程执行此方法的时候会找类锁
	public synchronized static void m1(){
		try{Thread.sleep(10000);}catch(Exception e){}
		System.out.println("m1.....");
	}
	//不会等m1结束，因为该方法没有被synchronized修饰
	/*
	public static void m2(){
		System.out.println("m2.....");
	}*/

	//该方法有synchronized，线程执行该方法需要类锁，不管上面共享了还是没有，类锁只有一把，所以等待
	public synchronized static void m2(){
		System.out.println("m2.....");
	}
}