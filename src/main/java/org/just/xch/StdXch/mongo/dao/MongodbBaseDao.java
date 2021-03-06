package org.just.xch.stdxch.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public abstract  class MongodbBaseDao<T> {
	 /** 
     * spring mongodb　集成操作类　 
     */  
    protected MongoTemplate mongoTemplate;  
    
    /** 
     * 获取需要操作的实体类class 
     *  
     * @return 
     */  
    protected abstract Class<T> getEntityClass();  
  
    /** 
     * 通过条件查询实体(集合) 
     *  
     * @param query 
     */  
    public List<T> find(Query query) {  
        return mongoTemplate.find(query, this.getEntityClass());  
    }  
  
    /** 
     * 通过一定的条件查询一个实体 
     *  
     * @param query 
     * @return 
     */  
    public T findOne(Query query) {  
        return mongoTemplate.findOne(query, this.getEntityClass());  
    }  
  
    /** 
     * 查询出所有数据 
     *  
     * @return 
     */  
    public List<T> findAll() {  
        return this.mongoTemplate.findAll(getEntityClass());  
    }  
  
    /** 
     * 查询并且修改记录 
     *  
     * @param query 
     * @param update 
     * @return 
     */  
    public T findAndModify(Query query, Update update) {  
        return this.mongoTemplate.findAndModify(query, update, this.getEntityClass());  
    }  
  
    /** 
     * 按条件查询,并且删除记录 
     *  
     * @param query 
     * @return 
     */  
    public T findAndRemove(Query query) {  
        return this.mongoTemplate.findAndRemove(query, this.getEntityClass());  
    }  
  
    /** 
     * 通过条件查询更新数据 
     *  
     * @param query 
     * @param update 
     * @return 
     */  
    public void updateFirst(Query query, Update update) { 
        Document doc= this.getEntityClass().getAnnotation(Document.class);
        mongoTemplate.updateFirst(query, update,doc.collection()); 
    } 
    
    
    
  
    /** 
     * 保存一个对象到mongodb 
     *  
     * @param bean 
     * @return 
     */  
    public T save(T bean) {  
        mongoTemplate.save(bean);  
        return bean;  
    }  
    
    
    /** 
     * 保存一个对象到mongodb 
     *  
     * @param bean 
     * @return 
     */  
    public void saveOrUpdate(Query query, Update update) {  
    }  
  
    /** 
     * 通过ID获取记录 
     *  
     * @param id 
     * @return 
     */  
    public T findById(String id) {  
        return mongoTemplate.findById(id, this.getEntityClass());  
    }  
  
    /** 
     * 通过ID获取记录,并且指定了集合名(表的意思) 
     *  
     * @param id 
     * @param collectionName 
     *            集合名 
     * @return 
     */  
    public T findById(String id, String collectionName) {  
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);  
    }  
  
      
  
}  