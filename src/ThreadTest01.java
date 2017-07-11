/*
	分析以下程序有几个线程
		以下程序只有一个线程，就是主线程，main,m1,m2,m3在同一个栈空间中，m3在栈顶
		（堆是先进先出，栈是先进后出）
*/
public class ThreadTest01
{
	public static void main(String[] args){
		m1();
	}

	public static void m1(){
		m2();
	}
	public static void m2(){
		m3();
	}
	public static void m3(){
		System.out.println("m3.....");
	}
}