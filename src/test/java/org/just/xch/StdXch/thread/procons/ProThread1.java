package org.just.xch.StdXch.thread.procons;

/**
 * Created by hoare on 2017/8/6.
 */
public class ProThread1 extends  Thread {

    Pro1 pro1;

    public  ProThread1(  Pro1 pro1){
        super();
        this.pro1=pro1;
    }

    public void run(){
        while(true){
            pro1.setValue();
        }
    }

}
