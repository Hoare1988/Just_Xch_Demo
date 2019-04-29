package org.jst.xch.stdxch.rpc.server.test;

import java.io.IOException;

import org.jst.xch.stdxch.rpc.server.RpcServer;

public class RpcServerTest
{
	public  static void main(String[]args){
		
		RpcServer rpcServer=new RpcServer();
		try
		{
			rpcServer.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
