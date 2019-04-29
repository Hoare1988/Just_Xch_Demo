package org.jst.xch.stdxch.event.jdk;

import java.util.EventListener;

public class TaskStatusChangeListener implements EventListener
{
	public void eventHandler(TaskChangeEvent changeEvent)
	{
		Task task = (Task)changeEvent.getSource();
		System.out.println(task.name+"状态改变事件");
	}
}
