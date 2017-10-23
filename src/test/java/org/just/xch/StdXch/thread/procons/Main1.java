package org.just.xch.stdxch.thread.procons;

/**
 * @author Administrator
 */
public class Main1 {

    public  static  void main(String[]args) throws  InterruptedException{

            String lock=new String("");

            for(int i=0;i<2;i++){

                ProThread1 proThread1=new ProThread1(new Pro1(lock));
                proThread1.setName("producer"+i);
                ConsuThread consuThread=new ConsuThread(new Consu1(lock));
                consuThread.setName("consumer"+i);

                proThread1.start();
                consuThread.start();
            }

            Thread.sleep(5000);

            Thread[] threads=new Thread[Thread.currentThread().getThreadGroup().activeCount()];
            Thread.currentThread().getThreadGroup().enumerate(threads);
            for(Thread thread:threads){
                    System.out.println(thread.getId()+":"+thread.getName()+":"+thread.getState());
            }

    }

}
