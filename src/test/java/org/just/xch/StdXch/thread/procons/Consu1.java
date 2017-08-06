package org.just.xch.StdXch.thread.procons;

/**
 * Created by hoare on 2017/8/6.
 *
 * 消费者
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
