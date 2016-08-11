package SAO_Char;
import java.awt.Image;
import java.awt.Toolkit;




public class ResourceLoader {
	//This is the variable for ResourceLoader
	static ResourceLoader rl = new ResourceLoader();
	
	//This static method obtains the images to load
	public static Image getImage (String fileName){
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource( fileName));
	}
}
