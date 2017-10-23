package org.just.xch.stdxch.pattern.observer.demo1;
/**
 * 
 *
 *Subject.java 文件使用说明
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
public interface Subject {

	void addObserver(Observer obj);
	
	void removeObserver(Observer obj);
	
	/**
	 * 主题改变，通知所有观察者
	 */
	void notifyObserver();
	
	
}
