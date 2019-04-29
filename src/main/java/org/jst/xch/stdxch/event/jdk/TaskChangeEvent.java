package org.jst.xch.stdxch.event.jdk;

import java.util.EventObject;

public class TaskChangeEvent extends EventObject
{

	public TaskChangeEvent(Task task)
	{
		super(task);
	}

}
