package org.jst.xch.stdxch.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.springframework.util.StopWatch;

public class PorencemTest
{

	public static List<User> collUsers()
	{
		List<User> users = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 200; i++)
		{
			users.add(new User("" + i, random.nextInt(120)));
		}

		
		return users;
	}

	public static void main(String[] args)
	{
		while (true)
		{
			List<User> users = collUsers();

			StopWatch stopWatch = new StopWatch();
			stopWatch.start("stream");
			int streamSize = stream(users);
			stopWatch.stop();

			stopWatch.start("parallStream");
			int parallStreamSize=  parallStream(users);
			stopWatch.stop();

			stopWatch.start("normal");
			int normalSize=   normal(users);
			stopWatch.stop();
			if(streamSize!=parallStreamSize||parallStreamSize!=normalSize){
				System.out.println(streamSize);
				System.out.println(parallStreamSize);
				System.out.println(normalSize);
				break;
			}
			
		}
		
		
	}

	public static int stream(List<User> users)
	{
		Map<Integer, List<User>> resultMap = users.stream()
				.collect(Collectors.groupingBy(User::getAge));
		if(MapUtils.isNotEmpty(resultMap))
		{
			for (Map.Entry<Integer, List<User>> entry : resultMap.entrySet())
			{
				// System.out.println(entry.getKey()+"----"+entry.getValue().size());
			}
			return resultMap.size();
		}
		return 0;
	}

	public static int parallStream(List<User> users)
	{
//		users = Collections.synchronizedList(users);
		
		Map<Integer, List<User>> resultMap = users.parallelStream()
				.collect(Collectors.groupingBy(User::getAge));
		if(MapUtils.isNotEmpty(resultMap))
		{
			for (Map.Entry<Integer, List<User>> entry : resultMap.entrySet())
			{
				// System.out.println(entry.getKey()+"----"+entry.getValue().size());
			}
			return resultMap.size();
		}
		return 0;
	}

	public static int normal(List<User> users)
	{
		Map<Integer, List<User>> resultMap = new HashMap<>();
		for (User user : users)
		{
			if(resultMap.containsKey(user.getAge()))
			{
				resultMap.get(user.getAge()).add(user);
			}
			else
			{
				List<User> userList = new ArrayList<>();
				userList.add(user);
				resultMap.put(user.getAge(), userList);
			}
		}

		if(MapUtils.isNotEmpty(resultMap))
		{
			for (Map.Entry<Integer, List<User>> entry : resultMap.entrySet())
			{
				// System.out.println(entry.getKey()+"----"+entry.getValue().size());
			}
			return resultMap.size();
		}
		return 0;
	}

}

class User
{

	private String name;
	private int age;

	public User(String name, int age)
	{
		this.name = name;
		this.age =age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
