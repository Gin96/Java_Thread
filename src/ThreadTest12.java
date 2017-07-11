/*
	Thread.yield();
	它与sleep()类似，只是不能用户指定暂停多长时间，并且yield()方法只能让同优先级的线程有执行的机会

	1.该方法是一个静态方法
	2.作用：给同一个优先级的线程让位，但是让位时间不固定
	3.和sleep()方法相同，就是yield()时间不固定
*/
public class ThreadTest12
{
	public static void main(String[]agrs){
		Thread t=new Processor12();
		t.setName("t");
		t.start();
		//主线程中
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}
class Processor12 extends Thread
{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			if(i%20==0){
				Thread.yield();
			}
		}
	}
}