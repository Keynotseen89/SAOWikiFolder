package SAO_Char;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class ResourceLoader {
	//This is the variable for ResourceLoader
	static ResourceLoader rl = new ResourceLoader();
	private static BufferedImage bufferedImage ;
	

	/**
	 * 
	 * @param fileName
	 * @return resource obtain for imag
	 * @throws IOException 
	 */
	public static BufferedImage getImage (String fileName){
	
		InputStream input = rl.getClass().getResourceAsStream(fileName);
		ImageInputStream imageInput = null;
		try {
			imageInput = ImageIO.createImageInputStream(input);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			bufferedImage = ImageIO.read(imageInput);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return bufferedImage;
	}
}

