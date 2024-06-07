package HelperPages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReference {
	public Properties prop;

	public PropertiesReference() throws Exception {
		FileInputStream f = new FileInputStream(System.getProperty("user.dir") + File.separator + "PropertiesFile"
				+ File.separator + "data.properties");
		prop = new Properties();
		prop.load(f);
	}
	public String getValue(String s) {
		return prop.getProperty(s);
		
		
	}

}
