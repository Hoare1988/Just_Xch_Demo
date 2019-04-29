package org.jst.xch.stdxch.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

import org.springframework.beans.factory.InitializingBean;

public class RpcClient 
{
	public static <T> T InvokeHandler(Class<T> interfaceClass, String host,
			int port)
	{
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
				new Class<?>[]
				{ interfaceClass }, new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable
					{

						ObjectInputStream ois = null;
						ObjectOutputStream oos = null;
						Socket socket = new Socket(host, port);
						
						socket.setTcpNoDelay(true);
						
						try
						{
							oos = new ObjectOutputStream(socket.getOutputStream());
							
							// 写入顺序与server端读取顺序一致
//							oos.writeUTF(interfaceClass.getName());
						
							oos.writeUTF(method.getName());

							oos.writeObject(method.getParameterTypes());

							oos.writeObject(args);

							// 获取返回结果
							 ois = new ObjectInputStream(socket.getInputStream());

							Object result = ois.readObject();
							
							if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
							if(result != null)
							{
								System.out.println(result.toString());
							}
							return result;
						}
						finally
						{
							try
							{
								if(ois!=null){
									ois.close();
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							
							try
							{
								if(oos!=null){
									oos.close();
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
							
							try
							{
								if(socket!=null){
									socket.close();
								}
							}
							catch (Exception e)
							{
								e.printStackTrace();
							}
						}
						
					}
				});
	}
}
