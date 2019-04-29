package org.just.xch.stdxch.rpc.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class Server
{

}


class PublishTask implements Runnable
{
	Socket socket;
	Object service;
	
	public  PublishTask(Socket socket,Object service)
	{
		this.socket = socket;
		this.service = service;
	}
	
	@Override
	public void run()
	{
		ObjectInputStream ois=null;
		ObjectOutputStream oos = null;
		try
		{
			ois = new ObjectInputStream(socket.getInputStream());
			// 预定义 readutf为 函数名称， readObject 为参数类型列表
			String methodName = ois.readUTF();
		    Class<?>[] paraTypes = (Class<?>[])ois.readObject();
		     Object[] paraValues =  (Object[])ois.readObject();
		     Method method =  service.getClass().getMethod(methodName, paraTypes);
		    Object result = method.invoke(service, paraValues);
		    
		    oos = new ObjectOutputStream(socket.getOutputStream());
		    oos.writeObject(result);
		    oos.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(ois);
			IOUtils.closeQuietly(oos);
		}
		
	}

}

