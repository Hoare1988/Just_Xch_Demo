package org.jst.xch.stdxch.rpc.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.jst.xch.stdxch.rpc.client.service.UserService;
import org.jst.xch.stdxch.rpc.server.service.imp.UserServiceImpl;

public class RpcServer
{
	BlockingQueue<Runnable> threadQue=new ArrayBlockingQueue<>(20);
	
	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000*100, TimeUnit.SECONDS, threadQue);
	
	ExecutorService executorService = Executors.newFixedThreadPool(20);
	
	//**接口服务注册 
	private final ConcurrentHashMap<String,Object> serviceTargets=new ConcurrentHashMap<>();
	
	
	public void registerService(Class clas ){
		
	}
	
	public void start() throws IOException{
		ServerSocket serverSocket=new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost",9090));
		System.out.println("服务启动");
		UserService userService=new UserServiceImpl();
		//启动服务
		int i=0;
		while(true)
		{
			executorService.submit(new PublisTask(serverSocket.accept(),userService));
//			threadPoolExecutor.execute(new PublisTask(serverSocket.accept(),userService));
			System.out.println("服务启动"+(++i));
		}
	}
	
	
	public void stop(){}
	
	private final class PublisTask implements Runnable
	{
		Socket socket;
		Object service;
		
		public void run()
		{
			ObjectInputStream ois=null;
			ObjectOutputStream oos=null;
			
			try
			{
				ois=new ObjectInputStream(socket.getInputStream());
//				String serviceName=ois.readUTF();
//				service=serviceTargets.get(serviceName);
				
				//读取方法名
				String methodName=ois.readUTF();
				//读取参数类型
				Class<?>[] paraTypes=(Class<?>[])ois.readObject();
				//获取参数列表
				Method method= service.getClass().getMethod(methodName, paraTypes);
				 Object[] paras= ( Object[])ois.readObject();
				//调用方法
				Object result=method.invoke(service, paras);
				System.out.println(service.getClass().getName()+"."+methodName);
				//回写结果
				oos=new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(result);
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}finally {
				
					try
					{
						if(oos!=null){
							oos.close();
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					
					try
					{
						if(ois!=null){
							ois.close();
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				
					
					try
					{
						if(socket!=null){
							socket.close();
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				
			}
		}
		
		public PublisTask(Socket socket,Object service){
			this.socket=socket;
			this.service=service;
		}
	}
}


