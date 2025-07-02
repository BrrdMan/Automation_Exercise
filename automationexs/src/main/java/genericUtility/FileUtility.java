package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Devayan
 */
public class FileUtility {

	/**
	 * This method is used to fetch data from properties file
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDataFromProperties(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/TestData/commondata.properties"));
		return prop.getProperty(key);
	}

}
