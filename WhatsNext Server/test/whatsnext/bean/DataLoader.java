package whatsnext.bean;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class DataLoader {

	public static Map<String, Mission> loadData(String filePath) throws FileNotFoundException {
		Reader reader = new FileReader(filePath);
		return null;
	}
}
