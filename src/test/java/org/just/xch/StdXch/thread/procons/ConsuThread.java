package org.just.xch.stdxch.thread.procons;

/**
 * Created by hoare on 2017/8/6.
 */
public class ConsuThread extends  Thread {

    Consu1 sonsu1;

    public  ConsuThread(  Consu1 sonsu1){
        super();
        this.sonsu1=sonsu1;

    }

    @Override
    public  void run(){

        while (true){
            sonsu1.getValue();
        }

    }
}
