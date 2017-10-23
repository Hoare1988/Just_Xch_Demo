package org.just.xch.stdxch.pattern.observer.demo1;
/**
 * 
 *
 *StudentObserver.java 文件使用说明
 * 说明：XXXX<br/>
 *  
 * 公开方法：
 * <ul>
 * 		<li>XXXX：</li>
 * </ul>
 *
 * @version ver 4.0.0
 * @author Shanghai Kinstar Winning Software .co.ltd. Administrator
 * @since 作成日期：Oct 23, 2017（Administrator）<br/>
 *        改修日期：
 */
public class StudentObserver implements Observer {
	
	TeacherSubject teacher;
	
	private String name;
	
	public StudentObserver(String name,TeacherSubject teacher){
		this.name=name;
		
		this.teacher=teacher;
		teacher.addObserver(this);
	}

	@Override
	public void update(String info) {
		System.out.println(name+":\"老师又布置作业了，开始......\"");
	}

}
