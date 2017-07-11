/**
	1.Thread.sleep(毫秒)
	2.sleep方法是一个静态方法
	3.该方法的作用：阻塞当前线程，腾出CPU让给其他线程。这个方法出现在哪个线程中，就被阻塞
*/
public class ThreadTest09
{
	public static void main(String[] args) throws InterruptedException{
		Thread t1=new Processor9();
		t1.setName("t1");
		t1.start();
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"-----?"+i);
			Thread.sleep(500);
		}
	}
}
class Processor9 extends Thread
{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"----?"+i);
			try{
				Thread.sleep(1000);//让当前线程阻塞一秒，要抛出一个异常
							   //但是run方法是重写父类的方法
							   //重写的方法不能比被重写的方法抛出更宽泛的异常
							   //所有run方法里异常只能try catch
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}
			
		//m1();
	}

	//m1方法是可以使用throws的
	public void m1() throws Exception{
		System.out.println("m1");
	}
}