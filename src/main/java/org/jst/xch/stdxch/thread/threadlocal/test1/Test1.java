package org.jst.xch.stdxch.thread.threadlocal.test1;

public class Test1
{
	private static ThreadLocal<String> tl1= new ThreadLocal<>();

	public static void main(String[] args)
	{
		ThreadA threadA = new ThreadA(tl1);
		ThreadB threadB = new ThreadB(tl1);
		
		threadA.start();
		threadB.start();
	}

}
