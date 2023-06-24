package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigPro {
		
		Properties pro;
		public  void readconfig(String path) {
			
			File src =new File(path);
			
			try {
				FileInputStream fis = new FileInputStream(src);
				pro =new Properties();
				pro.load(fis);
			}
			catch(Exception e) {
				System.out.println("exceptions is  "+e.getMessage());
			}
		}
		public String readString(String name) {
			
			String s = pro.getProperty(name);
			return s;
			
		}
}
