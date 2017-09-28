package org.just.xch.StdXch.mongo.dao.intf;

import java.util.List;

import org.just.xch.StdXch.mongo.entity.ShAj;

public interface IMonitorDao {

	List<ShAj> findByGhdjID(String ghdjid);
	
	void  deleteByGhdjID(String ghdjid);
	
}
