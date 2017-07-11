/**
	java中实现线程的第二种方式：
		第一步：写一个类实现java.lang.Runnable接口
		第二步：实现run方法

		一般选择这种方式，因为保留了类的继承
*/
public class ThreadTest04
{
	public static void main(String[]args){
		
		//创建线程
		Thread t=new Thread(new Processor4());
		//启动线程
		t.start();
	}
}
//定义一个线程，推荐
class Processor4 implements Runnable
{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("run-->"+i);
		}
	}
}