import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class CurvedBorder extends AbstractBorder {

	private Color wallColor = Color.gray;									//Sets wallColor to gray 
	private int sinkLevel = 1;												//Sets Level sink to 1 but can be changed
	private boolean indent = false;											//Sets indent to be false 
	
	
	//Sets the border Curv to wall which is gray
	public CurvedBorder(Color wall){
		this.wallColor = wall;
	}
	
	//Puts in 3 variables, sets wallColor to wall in function and sinkLevel to functions sinkLevel
	public CurvedBorder(int sinkLevel, Color wall, boolean indent){
		this.wallColor = wall;
		this.sinkLevel = sinkLevel;
	}
	
	//makes sinkLevel to 1 and indent to false;
	public CurvedBorder(int sinkLevel, boolean indent){
		this.sinkLevel = sinkLevel;
		this.indent = indent;
	}
	//this is left blank 
	public CurvedBorder(){
		
	}
	
	//Override the paintBorder to my own liking
	
	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h){
		super.paintBorder(c, g, x, y, w, h);											//Setting the size and width, height to the border 
		g.setColor(getWallColor());														//Setting the Color of the Border
		
		for (int i = 0; i < sinkLevel; i++){
			g.drawRoundRect(x, y, w - 1 - i, h - 1 - i, 10 - i, 10 - i);
			if (indent) {
				g.drawRoundRect( x + i, y + i, w - 1, h - 1, 10 - 1, 10 - i);
			}
		}
		
	}
	
	//Returns true if Border is Opaque
	@Override
	public boolean isBorderOpaque() { 
		return true;
	}
	
	//returns the new value of Insets with the new value of sinkLevel
	@Override
	public Insets getBorderInsets (Component c){
		return new Insets (sinkLevel, sinkLevel, sinkLevel, sinkLevel);
		
	}
	
	//returns all the sides of the border for the JFrame
	@Override
	public Insets getBorderInsets(Component c, Insets i){
		i.left = i.right = i.bottom = i.top = sinkLevel;
		return i;
	}
	
	//Returns false because indent is false
	public boolean isIndented(){
		return indent;
	}
	
	//returns sinkLevel which is 1 at first
	public int getSinkLevel(){
		return sinkLevel;
	}
	//returns the wallColor which is gray
	public Color getWallColor() {
		return wallColor;
	}
}//end of Class Code
