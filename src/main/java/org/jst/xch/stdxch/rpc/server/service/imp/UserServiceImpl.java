package org.jst.xch.stdxch.rpc.server.service.imp;

import java.io.Serializable;

import org.jst.xch.stdxch.rpc.client.entity.User;
import org.jst.xch.stdxch.rpc.client.service.UserService;

public class UserServiceImpl implements UserService, Serializable
{
	private static final long serialVersionUID = -5026025201086672187L;

	@Override
	public User findUserByID(Long id)
	{
		return new User(100L, "xiaosa");
	}

	public String getUserName(Long id)
	{
		return "abcd1234";
	}

}
