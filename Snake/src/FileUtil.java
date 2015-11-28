import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileUtil {
	
	private static final String END_OF_FILE = "\\A";
	public static final String UTF_8 = StandardCharsets.UTF_8.toString();

	public static String readFile(String filePath) throws FileNotFoundException {
		
		return readFile(new File(filePath));
	}

	public static String readFile(File file) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileInputStream(file),UTF_8);
		scan.useDelimiter(END_OF_FILE);
	    String content = scan.next();
	    scan.close();
		return content;	
	}
	


}
