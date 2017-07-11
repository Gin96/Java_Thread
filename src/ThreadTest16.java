/*
	以下程序使用线程同步机制控制数据的安全
*/
public class ThreadTest16
{
	public static void main(String[] args){
		//创建一个公共的账户
		Account16 act=new Account16("actno001",5000);
		//创建线程对同一账户取款
		Processor16 p=new Processor16(act);
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		t1.start();
		t2.start();
	}
}
//取款线程
class Processor16 implements Runnable
{
	//账户
	Account16 act;
	//Constructor
	Processor16(Account16 act){
		this.act=act;
	}
	public void run(){
		act.withdraw(1000.0);
		System.out.println("取款1000成功！余额："+act.getBalance());
	}
}


//抽象账户
class Account16
{
	private String actno;//账号
	private double balance;//余额
	
	public Account16(){}
	public Account16(String actno,double balance){
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
	//synchronized关键字添加到成员方法上，线程拿走的也是this的对象锁
	/*
		synchronized关键字放在方法上控制的是整个方法，而在语句块的synchronized
	*/
	public synchronized void withdraw(double money){//对当前账户进项取款操作
		double after=balance-money;
		//延迟，两个线程取款，余额未改变时，另一个线程再次取款，去两次1000，余额都是4000
		try{Thread.sleep(1000);}catch(Exception e){}
		//更新
		this.setBalance(after);
	}
}