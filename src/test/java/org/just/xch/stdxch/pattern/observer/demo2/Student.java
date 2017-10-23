package org.just.xch.stdxch.pattern.observer.demo2;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
	
	private Observable teacher;
	
	private String name;
	
	public Student(String name,Observable ob){
		this.name=name;
		ob.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.teacher= o;
		
		String info=((TeacherSubject)teacher).getInfo();
		
		System.out.println(name+":拿到老师的作业了，，，"+info);
	}
	
	/**
	 * <p> 取消订阅</p>
	 * @author: Administrator
	 */
	public void  cancelSubscribe(){
		teacher.deleteObserver(this);
	}

}
