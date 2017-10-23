//package org.just.xch.stdxch.R;
//
//import org.rosuda.JRI.Rengine;
//
//public class RDemo1 {
//
//	public static void main(String[] args) {  
//		RDemo1 demo = new RDemo1();  
//        demo.callRJava();  
//    }  
//       
//    public void callRJava(){  
//    	 System.load("C:\\Program Files\\R\\R-3.4.1\\library\\rJava\\jri\\x64\\jri.dll"); 
//        Rengine re = new Rengine(new String[] {"--vanilla"},false,null);  
//        if(!re.waitForR()){  
//            System.out.println("Cannot load R");  
//            return;  
//        }  
//        //打印变量  
//        String version = re.eval("R.version.string").asString();  
//        System.out.println(version);  
//          
//        //循环答应数组  
//        double[] arr = re.eval("rnorm(10)").asDoubleArray();  
//        for (double a:arr){  
//            System.out.print(a+",");  
//        }  
//        re.end();  
//    }  
//}
