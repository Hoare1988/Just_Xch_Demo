package org.just.xch.stdxch.thread.procons;

/**
 * @author Administrator
 */
public class ProThread1 extends  Thread {

    Pro1 pro1;

    public  ProThread1(  Pro1 pro1){
        super();
        this.pro1=pro1;
    }

    @Override
    public void run(){
        while(true){
            pro1.setValue();
        }
    }

}
