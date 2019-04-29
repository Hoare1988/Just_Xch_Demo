package org.jst.xch.stdxch.thread.threadlocal.test1;

public class ThreadA  extends Thread
{
	private ThreadLocal<String> tl;
	
	public ThreadA(ThreadLocal<String> TL){
		this.tl = TL;
	}

	@Override
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			if(tl.get()!=null){
				System.out.println("A：before -get"+  tl.get());
			}
			
			tl.set("A"+i);
			if(tl.get()!=null){
				System.out.println("A：after -get"+  tl.get());
			}
			
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
