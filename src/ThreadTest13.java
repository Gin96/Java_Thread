/*
	t.join（成员方法）
	线程的合并
*/
public class ThreadTest13
{
	public static void main(String[] args) throws Exception{
		Thread t=new Thread(new Processor13());
		t.setName("t");
		t.start();
		//合并线程
		t.join();//t和主线程合并，变成单线程，两个栈空间变成一个栈区
		
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}
class Processor13 implements Runnable
{
	public void run(){
		for(int i=0;i<5;i++){
			try{Thread.sleep(1000);}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}