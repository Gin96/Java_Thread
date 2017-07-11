/*
	在java语言中实现多线程的第一种方式：
		1).继承java.lang.Thread;
		2).重写run方法
	三个知识点:
		1.如何定义一个线程
		2.如何创建线程？
		3.如何启动线程？

	开启线程原理：
		在JVM虚拟机中，main方法栈帧
		Thread t=0x1234;//在堆中创建了一个线程对象
		t.start();//在jvm虚拟机中又单独开辟出一个t线程栈，里面有run方法栈帧等等
*/
public class ThreadTest02
{
	public static void main(String[] args){
		//创建线程
		Thread t=new Processor();
		//启动
		t.start();//这段代码执行瞬间结束，告诉java虚拟机再分配一个新的栈给t
				  //run方法不需要程序员手动调用，系统线程启动之后自动调用run方法
		//t.run();//如果不调用.start方法，而用t.run()，则只是一个线程，因为没有启动线程。
				  //属于普通方法调用，run方法结束之后，下面程序才能继续执行
		//这段代码在主线程中运行
		for(int i=0;i<10;i++){
			System.out.println("main-->"+i);
		}

		//有了多线程之后，main方法结束，只是主线程栈中没有方法栈帧了
		//但是其他线程或其他栈中还有栈帧
		//main方法结束，程序可能还在运行
	}

}

//定义一个线程
class Processor extends Thread
{
	//重写run方法，这段代码在t线程中运行
	public void run(){
		for(int i=0;i<30;i++){
			System.out.println("run-->"+i);
		}
	}
}