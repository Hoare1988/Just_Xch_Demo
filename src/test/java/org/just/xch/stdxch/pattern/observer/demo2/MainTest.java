package org.just.xch.stdxch.pattern.observer.demo2;

public class MainTest {

	public static void main(String[] args) {
		TeacherSubject teacher=new TeacherSubject();
		
		Student studentA=new Student("XiaoMing", teacher);
		Student studentB=new Student("xiaohong", teacher);
		Student studentC=new Student("xiaozhang", teacher);
		Student studentD=new Student("D", teacher);
		
		teacher.setHomeWork("考试");
		
		
		studentA.cancelSubscribe();
		
		teacher.setHomeWork("数学：函数与向量 4.1");
	}
}
