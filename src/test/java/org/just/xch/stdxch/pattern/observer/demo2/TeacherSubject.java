package org.just.xch.stdxch.pattern.observer.demo2;

import java.util.Observable;

public class TeacherSubject extends Observable {

		private String info;
		
		public void setHomeWork(String info){
			this.info=info;
			
			/*布置作业了*/
			setChanged();
			notifyObservers();
		}

		public String getInfo() {
			return info;
		}	
		
		
	
}
