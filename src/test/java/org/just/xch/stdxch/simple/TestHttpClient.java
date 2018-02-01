package org.just.xch.stdxch.simple;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

public class TestHttpClient {

    public static void main(String[] args) {
        testHttpClient();
    }
    
    public static void testHttpClient(){

        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8085/MMAP/doctor/WhiteList.do");

        StringPart stringPart = new StringPart("pageSize", "10");
        StringPart stringPart2 = new StringPart("pageIndex", "1");
        stringPart.setCharSet("UTF-8");
        // 中文要用这个
        Part[] pars = new Part[] { stringPart,stringPart2 };

        MultipartRequestEntity reqEntity = new MultipartRequestEntity(pars, postMethod.getParams());

        postMethod.setRequestEntity(reqEntity);

        try {
            int code = httpClient.executeMethod(postMethod);
            System.out.println("返回值"+postMethod.getResponseBodyAsString());
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    static class Doctor implements Serializable{
        public Doctor(){
            
        }
        public  String name;
        public int age;
    }
    
    /*public static void testPageHelper(){
        PageInfo<Doctor> pi=new PageInfo<Doctor>();
        pi.setTotal(100);
        pi.setSize(20);
        
        List<Doctor> resultList=new ArrayList<Doctor>();
       Doctor doc1=new Doctor();
        doc1.name="xiali";
        resultList.add(doc1);
        pi.setList(resultList);
        
        
        System.out.println(JSONObject.toJSON(pi).toString());
        
    }*/
}
