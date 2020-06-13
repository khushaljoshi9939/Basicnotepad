package notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Open1 {
public static void open11(String o) throws IOException
{
		File f=new File(o);
		FileReader fr=new FileReader(o);
		char x[]=new char[(int)f.length()];
		fr.read(x);
		for(char ch1:x)
		{
			//System.out.println(ch1);
			Notepad1.textArea.append(Character.toString(ch1));
			
		}
		
		
}
}
