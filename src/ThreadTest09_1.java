/*
	面试题
*/
public class ThreadTest09_1
{
	public static void main(String[] args) throws Exception{
		//创建线程
		Thread t=new Processor09();
		t.setName("t");
		//启动线程
		t.start();
		//休眠
		//Thread.sleep(5000);
		t.sleep(5000);//不会影响run方法运行，sleep方法静态，所以本质是Thread.sleep()
					  //阻塞的是main方法
		System.out.println("HelloWord");

		A a=null;
		A.m1();//不会报错，因为m1是静态方法，类名.方法即可调用
	}
}
class Processor09 extends Thread
{
	public void run(){
		
		for(int i=0;i<200;i++){
			System.out.println(Thread.currentThread().getName()+"----->"+i);
		}
	}
}
class A
{
	public static void m1(){
		System.out.println("调用此方法会不会报错");
	}
}