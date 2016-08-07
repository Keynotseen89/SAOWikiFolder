
//Project // Folder: SAOWikiFolder
//Name: Quinatzin Sintora
//Date: 8/5/2016
//This Project is the display the Character of SAO and give some information about the first season Characters.
//Followed by the Character on a second screen not on the same as the information.

import java.awt.Dimension;
import static java.awt.GraphicsDevice.WindowTranslucency.*;


import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class SAOWiki extends JFrame implements ActionListener{
	JButton enterButton = new JButton("I am a Button");							//Used to Enter the Program
	JLabel headerTitle = new JLabel ("Sword Art Online Wiki");					//Title Label of the Program
	JButton infoButton = new JButton ("Info");									//Prompts a display Window with information
	
	private Point point = new Point();											//Point is used to drag the JFrame with the mouse
	
	public SAOWiki(){
		super("Sword Art Online");
		
		GridBagConstraints gbc = new GridBagConstraints();						//Used to put Labels,Buttons and so on in what ever order we like
		gbc.insets = new Insets(5,5,5,5);										//Spacing for GridBagConstraints
		
		final JPanel panel = new JPanel(new GridBagLayout()) {
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
		
		//At the moment used to exit program when Button is pressed
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				System.exit(0);
			}
		});
		
		//This is used for the Mouse Listener for to move the main screen
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		
		//This is the Mouse Listener that well help move the JFrame 
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e){
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
			}
		});
		
		infoButton.addActionListener(this);
		
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBorder(new CurvedBorder(2, true));
		
		gbc.gridx = 0; gbc.gridy = 0;
		panel.add(headerTitle, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		panel.add(enterButton,gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		panel.add(infoButton, gbc);
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		
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
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object sourceObject =  evt.getSource();
		
		if(sourceObject == infoButton){
			JOptionPane.showMessageDialog(this, "This Application gives information\n SAO Charaters");
		}
	
	}

}
