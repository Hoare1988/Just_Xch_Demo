package org.just.xch.stdxch.thread.procons;

/**
 * 消费者
 * @author Administrator
 */
public class Consu1 {

    private String lock;

    public  Consu1(String lockStr){
        super();
        this.lock=lockStr;
    }

    public void getValue(){

        try{
            synchronized (lock){

                while (ValueObject.value.equals("")){
                    System.out.println("consumer waiting");
                    lock.wait();

                }
                System.out.println("consumer running");

                ValueObject.value="";

//                lock.notify();
                lock.notifyAll();

            }



    }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
