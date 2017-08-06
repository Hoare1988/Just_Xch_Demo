package org.just.xch.StdXch.thread.procons;


/**
 * Created by hoare on 2017/8/6.
 * @author  hoare
 * 生产者消费者 假死demo
 */
public class Pro1 {

        private String lock;

        public Pro1(String lockStr){
            super();
            this.lock=lockStr;
        }


        public  void setValue(){
            try {
                synchronized (lock) {

                    while (!ValueObject.value.equals("")) {
                        System.out.println("producer waiting");
                        lock.wait();
                    }

                    System.out.println("producer running");
                    ValueObject.value=System.currentTimeMillis()+"";

//                    lock.notify();
                    lock.notifyAll();
                }

            }catch (Exception ex){
                    ex.printStackTrace();
            }

        }




}
