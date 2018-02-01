package org.just.xch.stdxch.pattern.observer.demo1;

/**
 * 
 *
 *MainTest.java 文件使用说明
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
public class MainTest {

	public static void main(String[] args) {
		TeacherSubject teacher=new TeacherSubject();
		
		Observer studentA=new StudentObserver("XiaoMing", teacher);
		Observer studentB=new StudentObserver("xiaohong", teacher);
		Observer studentC=new StudentObserver("xiaozhang", teacher);
		
		
		teacher.setHomeWork("背诵古诗");
		
		Class class1=MainTest.class;
		
		try {
            Object object=class1.newInstance();
            
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		
	}
}
