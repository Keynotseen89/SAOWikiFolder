package Char_Docs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class ResourceLoaderFolder {
	
	static ResourceLoaderFolder rlf = new ResourceLoaderFolder();
	
	/**
	 * 
	 * @param fileName
	 * @return string of text file
	 */
	public static  String getFile (String fileName)
	{
		InputStream is = rlf.getClass().getResourceAsStream(fileName);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		  StringBuffer sb = new StringBuffer();
		  String line;
		  try {
			while ((line = br.readLine()) != null) 
			  {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		  return sb.toString();
	}
}
