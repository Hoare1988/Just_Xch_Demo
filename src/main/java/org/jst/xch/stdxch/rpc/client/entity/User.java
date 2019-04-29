package org.jst.xch.stdxch.rpc.client.entity;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = -8371366929717057354L;

	private Long id;
	
	private String name;
	
	public User(){}
	
	public User(Long id,String name){
		this.id=id;
		this.name=name;
	}
	

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
