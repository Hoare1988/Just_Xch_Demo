package org.just.xch.stdxch.mongo.dao.intf;

import java.util.List;

import org.just.xch.stdxch.mongo.entity.Ghdj;

public interface IMonitorDao {

	List<Ghdj> findByGhdjID(String ghdjid);
	
	void  deleteByGhdjID(String ghdjid);
	
}
