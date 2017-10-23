package org.just.xch.stdxch.mongo.dao.intf;

import java.util.List;

import org.just.xch.stdxch.mongo.entity.ShAj;

public interface IMonitorDao {

	List<ShAj> findByGhdjID(String ghdjid);
	
	void  deleteByGhdjID(String ghdjid);
	
}
