package notepad;
import java.io.*;
public class Saveas {

	public static void saveas1(String s,String name) throws IOException
	{
		File f=new File(name);
		f.createNewFile();
		FileWriter fr=new FileWriter(f);
		fr.write(s);
		fr.close();
		
	}
	
	
}
