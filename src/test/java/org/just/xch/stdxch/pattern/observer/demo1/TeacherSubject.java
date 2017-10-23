package org.just.xch.stdxch.pattern.observer.demo1;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubject implements Subject {

	private List<Observer> observerList = new ArrayList<Observer>();

	private String info;

	@Override
	public void addObserver(Observer obj) {
		observerList.add(obj);
	}

	@Override
	public void removeObserver(Observer obj) {
		observerList.remove(obj);
	}

	/**
	 * 通知所有观察者修改
	 * @see org.just.xch.stdxch.pattern.observer.demo1.Subject#notifyObserver()
	 * @时间: Oct 23, 2017 11:27:57 AM 
	 * @author: Administrator
	 */
	@Override
	public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.update(info);
		}
	}
	
	/**
	 * <p> 布置作业</p>
	 * @param info
	 * @author: Administrator
	 */
	public void setHomeWork(String info){
		this.info =info;
		this.notifyObserver();
	}
	
}
