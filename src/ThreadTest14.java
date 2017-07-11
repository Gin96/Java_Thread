/**
	t1和t2
	异步编程模型：t1线程执行t1的，t2线程执行t2的，两个线程之间谁也不等谁
	同步编程模型：t1线程和t2线程执行，当t1线程必须等t2线程执行结束之后，t1线程才能执行

	什么时候要同步呢？为什么要引入线程同步？(取款例子)
		1.为了数据的安全，尽管应用程序的使用率降低，但是为了保证数据是安全的，必须加入线程同步机制
		线程同步机制使程序变成了(等同)单线程
		2.什么条件下使用线程同步？
			1)必须是多线程环境
			2)多线程环境共享一个数据
			3)共享的数据涉及到修改操作
*/
/*
*	以下程序演示取款例子，以下线程不使用线程同步机制，
	多线程同时面对同一个账户进项取款操作会有什么问题？
*/
public class ThreadTest14
{
	public static void main(String[] args){
		//创建一个公共的账户
		Account act=new Account("actno001",5000);
		//创建线程对同一账户取款
		Processor14 p=new Processor14(act);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		t1.start();
		t2.start();
	}
}
//取款线程
class Processor14 implements Runnable
{
	//账户
	Account act;
	//Constructor
	Processor14(Account act){
		this.act=act;
	}
	public void run(){
		act.withdraw(1000.0);
		System.out.println("取款1000成功！余额："+act.getBalance());
	}
}
//抽象账户
class Account
{
	private String actno;//账号
	private double balance;//余额
	
	public Account(){}
	public Account(String actno,double balance){
		this.actno=actno;
		this.balance=balance;
	}
	//setter与getter
	public void setActno(String actno){
		this.actno=actno;
	}
	public String getActno(){
		return actno;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	//对外提供发一个取款的方法
	public void withdraw(double money){//对当前账户进项取款操作
		double after=balance-money;
		//延迟，两个线程取款，余额未改变时，另一个线程再次取款，去两次1000，余额都是4000
		try{Thread.sleep(1000);}catch(Exception e){}
		//更新
		this.setBalance(after);
	}
}