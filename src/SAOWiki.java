
//Project // Folder: SAOWikiFolder
//Name: Quinatzin Sintora
//Date: 8/5/2016
//This Project is the display the Character of SAO and give some information about the first season Characters.
//Followed by the Character on a second screen not on the same as the information.

import java.awt.Dimension;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SAOWiki extends JFrame {

	public SAOWiki(){
		super("Sword Art Online");
		
		final JPanel panel = new JPanel() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(300,500);
			}
		};
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Float(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight(), 10, 10));
			}
		});
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBorder(new CurvedBorder(2, true));
		panel.add(new JButton("I am a Button"));
		add(panel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		
	
		 if (!gd.isWindowTranslucencySupported(PERPIXEL_TRANSPARENT)) {
	            System.err.println("Shaped windows are not supported");
	            System.exit(0);
	        }


	        // Create the GUI on the event-dispatching thread
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new SAOWiki();
	            }
	        });
	}

}
