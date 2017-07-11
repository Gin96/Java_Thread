/*
	如何正确的更好的终止一个正在执行的线程

	需求：线程启动5s之后终止
*/
public class ThreadTest11
{
	public static void main(String[] args) throws Exception{
		Processor11 pro=new Processor11();
		Thread t=new Thread(pro);
		t.setName("t");
		t.start();
		//5s之后终止
		Thread.sleep(5000);
		//终止
		pro.isRun=false;
	}
}
class Processor11 implements Runnable
{
	boolean isRun=true;
	public void run(){
		for(int i=0;i<10;i++){
			if(isRun){
				try{Thread.sleep(1000);}catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+"-->"+i);
			}else{
				return;
			}
		}
	}
}