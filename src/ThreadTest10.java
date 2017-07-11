/*
	某线程正在休眠，如果打断他的休眠
	以下方式依靠的是异常处理机制
*/
public class ThreadTest10
{
	public static  void main(String[]args) throws Exception{
	
		//需求：启动线程之后，5s之后打断线程的休眠
		Thread t=new Thread(new Processor10());
		//起名
		t.setName("t");
		//启动
		t.start();
		//5s之后
		Thread.sleep(5000);
		//打断t的休眠void interrupt()中断线程
		t.interrupt();

	}
}
class Processor10 implements Runnable
{
	public void run(){
		try{
			Thread.sleep(1000000);
			System.out.println("HelloWord");
		}catch(InterruptedException e){
			//e.printStackTrace();
		}
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}