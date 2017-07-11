/*
	以下程序使用线程同步机制控制数据的安全
*/
public class ThreadTest15
{
	public static void main(String[] args){
		//创建一个公共的账户
		Account15 act=new Account15("actno001",5000);
		//创建线程对同一账户取款
		Processor15 p=new Processor15(act);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		t1.start();
		t2.start();
	}
}
//取款线程
class Processor15 implements Runnable
{
	//账户
	Account15 act;
	//Constructor
	Processor15(Account15 act){
		this.act=act;
	}
	public void run(){
		act.withdraw(1000.0);
		System.out.println("取款1000成功！余额："+act.getBalance());
	}
}


//抽象账户
class Account15
{
	private String actno;//账号
	private double balance;//余额
	
	public Account15(){}
	public Account15(String actno,double balance){
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
	//对外提供发一个取款的方法,以下代码只能有一个线程执行
	public void withdraw(double money){//对当前账户进项取款操作
		//把需要同步的代码放入同步语句块中
		/*
			原理：t1线程和t2线程
			t1线程执行到此处，遇到了synchronized关键字，就会去找
			synchronized小括号里的this对象锁
			如果找到了this对象锁，则进入同步语句块中执行程序，
			当同步语句块中的代码之行结束之后，t1线程归还this的对象锁

			在t1线程执行同步语句块的过程中。如果t2线程也过来执行以下代码，也遇到了
			synchronized关键字，所以也会去找this的对象锁，但是该对象锁被t1持有
			只能等待this对象锁的归还
		*/
		synchronized(this){//小括号中放入共享对象
			double after=balance-money;
			//延迟，两个线程取款，余额未改变时，另一个线程再次取款，去两次1000，余额都是4000
			try{Thread.sleep(1000);}catch(Exception e){}
			//更新
			this.setBalance(after);
		}
	}
}