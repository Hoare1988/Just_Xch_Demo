package org.jst.xch.stdxch.thread.threadlocal.test1;

public class ThreadB extends Thread
{
	
	private ThreadLocal<String> tl;
	
	public ThreadB(ThreadLocal<String> TL){
		this.tl = TL;
	}

	@Override
	public void run()
	{
		for(int i=0;i<5;i++)
		{
			if(tl.get()!=null){
				System.out.println("B：before -get"+  tl.get());
			}
			
			tl.set("B"+i);
			if(tl.get()!=null){
				System.out.println("B：after -get"+  tl.get());
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
