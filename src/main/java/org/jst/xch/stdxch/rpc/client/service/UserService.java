package org.jst.xch.stdxch.rpc.client.service;

import org.jst.xch.stdxch.rpc.client.entity.User;

public interface UserService
{
	User findUserByID(Long id);
	
	
	String getUserName(Long id);
}
