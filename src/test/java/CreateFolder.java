import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *
 *CreateFolder.java 文件使用说明
 * 说明：XXXX<br/>
 *  配置使用
 * @version ver 4.0.0
 * @author Shanghai Kinstar Winning Software .co.ltd. XuChuanHou
 * @since 作成日期：2017年9月25日（XuChuanHou）<br/>
 *        改修日期：
 */
public class CreateFolder {

	public static void main(String[] args) {
		
		System.out.println("输入文件地址");
		  Scanner scan = new Scanner(System.in);
		  String read = scan.nextLine();
		
		if (read == null ) {
			System.out.println("需要输入文件地址");
			return;
		}

		File foler = new File(read);
		if(!foler.isDirectory()){
			System.out.println("需要输入文件目录");
		}
		
		FileWriter fWriter;
		try {
			fWriter = new FileWriter("c:/folder.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fWriter);
			List<String> folderList =new ArrayList<String>();
			 writeFolder(foler,folderList);
			 for(String dir:folderList){
				 bufferedWriter.write(dir);  
				 bufferedWriter.newLine();
			 }
			bufferedWriter.flush();
			// 关闭缓冲区,同时关闭了fw流对象
			bufferedWriter.close();
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}

	 private static void writeFolder(File foler,List<String> folderList ){
		 folderList.add(foler.getName());
		 if(foler.isDirectory()){
			 for(File file:foler.listFiles()){
				 writeFolder(file,folderList);
			 }
		 }
	 }
}
