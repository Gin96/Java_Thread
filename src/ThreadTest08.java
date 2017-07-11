/*
	线程优先级高的获取的CPU时间片相对多一些
	
	优先级1-10
	最低1
	最高10
	默认5
		
*/
public class ThreadTest08
{
	public static void main(String[] args){
		
		System.out.println("优先级最大："+Thread.MAX_PRIORITY);//10
		System.out.println("优先级最小："+Thread.MIN_PRIORITY);//1
		System.out.println("优先级默认："+Thread.NORM_PRIORITY);//5

		Thread t1=new Processor8();
		t1.setName("t1");
		
		Thread t2=new Processor8();
		t2.setName("t2");
		System.out.println("-----"+t1.getPriority());//5
		System.out.println("-----"+t2.getPriority());//5
		//设置优先级
		t1.setPriority(1);
		t2.setPriority(10);
		System.out.println("-----"+t1.getPriority());//1
		System.out.println("-----"+t2.getPriority());//10
		//启动线程
		t1.start();
		t2.start();
	}
}
class Processor8 extends Thread
{
	public void run(){
		for(int i=0;i<50;i++){
			System.out.println(Thread.currentThread().getName()+"--->"+i);
		}
	}
}