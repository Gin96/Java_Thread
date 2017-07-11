/*
	回顾

	1.进程与线程的区别
		进程代表一个应用程序，提高cpu使用率。进程与进程之间内存独立
		线程是一个进程中的执行场景，一个进程可以启动多个线程，提高进程的使用率
	  线程和线程共享“堆内存和方法场景”，栈内存是独立的，一个线程一个栈
	
	2.java程序的运行原理
		 java命令会启动java虚拟机，启动jvm，等于启动了一个应用程序，启动了一个进程
		该进程会启动一个主线程，然后主线程去调用某个类的main方法，所有main方法运行在主线程中
		main方法结束之后，程序不一定结束，可能有其他线程在运行
	
	3.线程的创建和启动
		1)继承Threat类，执行run方法，直接new 继承Threat类的子类
		2)实现Runnable接口，执行run方法，new Thread(new 实现Runnable接口的类);

*/
public class ThreadTest06
{
	public static void main(String[] args){
	
	}
}