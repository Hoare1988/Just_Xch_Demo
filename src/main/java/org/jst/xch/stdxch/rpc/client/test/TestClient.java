package org.jst.xch.stdxch.rpc.client.test;

import org.jst.xch.stdxch.rpc.client.RpcClient;
import org.jst.xch.stdxch.rpc.client.service.UserService;

public class TestClient
{

	public static void main(String[] args)
	{
		RpcClient rpcClient=new RpcClient();
		UserService userService = rpcClient.InvokeHandler(UserService.class, "localhost", 9090);
		String name= userService.getUserName(1000L);
		System.out.println("client get "+name);
	}

}
