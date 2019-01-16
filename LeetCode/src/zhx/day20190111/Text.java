package zhx.day20190111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** 
* @author lenovo
* @date 2019年1月16日上午10:11:20 
* @Description: 
*/
public class Text {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\lenovo\\git\\leetcode_repository\\LeetCode\\src\\zhx\\day20190111\\Text.java");
			FileOutputStream fileOutputStream = new FileOutputStream("newFile11.java");
			byte[] bbuf = new byte[32];
			int hasread = 0;
			while((hasread = fileInputStream.read(bbuf)) > 0) {
				//System.out.println(new String(bbuf, 0, hasread));
				fileOutputStream.write(bbuf, 0, hasread);
				
			}
			System.out.println("成功写入");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	}
}
 