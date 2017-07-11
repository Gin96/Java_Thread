/**
	线程有两种：用户线程、守护线程(在此之前的县城全部为用户线程)

	守护线程，所有的用户线程结束生命周期，守护线程才会结束生命周期，
  只要有一个用户线程存在,那么守护线程就不会结束。例如java中著名的
  垃圾回收器就是一个守护线程，只有应用程序的所有线程结束，它才会结束

  其他所有的用户线程结束，则守护线程退出
  守护线程一般都是无限之行的
	
*/
public class ThreadTest19
{
	public static void main(String[] args) throws Exception{
		Thread t1=new Processor19();
		t1.setName("t1");
		//void setDaemon(boolean on)将线程标记为守护线程或者用户线程
		//将t1用户线程修改为守护线程 
		t1.setDaemon(true);
		t1.start();
		//主线程   
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			Thread.sleep(1000);
		}
	}
}
class Processor19 extends Thread
{
	public void run(){
		int i=0;
		while(true){
			i++;
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			try{Thread.sleep(500);}catch(Exception e){}
		}
	}
}