//Project // Folder: SAOWikiFolder
//Name: Quinatzin Sintora
//Date: 8/5/2016
//This Project is the display the Character of SAO and give some information about the first season Characters.
//Followed by the Character on a second screen not on the same as the information.

import java.awt.Dimension;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

import java.awt.Color;
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
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Char_Docs.ResourceLoaderFolder;
import SAO_Char.ResourceLoader;



public class SAOWiki extends JFrame implements ActionListener{
	JButton enterButton = new JButton("Start");									//Used to Enter the Program
	JLabel headerTitle = new JLabel ("Sword Art Online Wiki");					//Title Label of the Program
	JLabel headerSecondScreen = new JLabel("SAO Characters");					//JLabel for second Screen

	JRadioButton invisibleRadioButton = new JRadioButton();						//Radio Button that is not seen
	JButton infoButton = new JButton ("Info");									//Prompts a display Window with information
	JButton exitButton = new JButton ("Exit");									//Exits the Program
	JTextArea textArea = new JTextArea(5,15);									//Text Area for Characters

	ButtonGroup radioButtonGroup = new ButtonGroup();
	JButton perButton = new JButton("Prev");
	JButton nextButton = new JButton ("Next");
	int count = 0;
	static JFrame secondGUI = new JFrame();										//This creates a second GUI JFrame Window after clicking a button
	static JFrame charWindow = new JFrame();									//Window for Displaying the Image of the Characters
	private Point point = new Point();											//Point is used to drag the JFrame with the mouse
	
	private ImageIcon[] saoImageList = {new ImageIcon(ResourceLoader.getImage("Kirito.png")),new ImageIcon(ResourceLoader.getImage("Kirito's_Avatar.png")),new ImageIcon(ResourceLoader.getImage("Kirito's_GGO.png")),
			new ImageIcon(ResourceLoader.getImage("Asuna.png")),new ImageIcon(ResourceLoader.getImage("Asuna's_SAO.png")),new ImageIcon(ResourceLoader.getImage("Asuna'sSAO2.png")),
			new ImageIcon(ResourceLoader.getImage("Asuna's_Avatar.png")),new ImageIcon(ResourceLoader.getImage("Asada_Shino's_RL.png")),new ImageIcon(ResourceLoader.getImage("Sinon's_GGO.png")),
			new ImageIcon(ResourceLoader.getImage("Sinon's_ALO.png"))
		
	};//end of ImageIcon Array
	JLabel imageLabel = new JLabel(saoImageList[0]);
	
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
		exitButton.addActionListener(new ActionListener() {
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
		
		//infoButton.addActionListener(this);
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBorder(new CurvedBorder(2, true));
		
		gbc.gridx = 0; gbc.gridy = 0;
		panel.add(headerTitle, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		panel.add(enterButton,gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		panel.add(exitButton, gbc);
		gbc.gridx = 0; gbc.gridy = 3;
		panel.add(infoButton, gbc);
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		actionListener();
		//secondGUIDisplay();											//Goes to the second Display Method for the second window
	}
	
	public void actionListener(){
		infoButton.addActionListener(this);
		enterButton.addActionListener(this);
	//	radioButton.addActionListener(this);
	//	radioButton2.addActionListener(this);
		
	//	infoButton.addActionListener(this);
		perButton.addActionListener(this);
		nextButton.addActionListener(this);
	}
	
	//Layout for the second GUI Window
	public void secondGUIDisplay(){
		GridBagConstraints gbc = new GridBagConstraints();						//Used to put Labels,Buttons and so on in what ever order we like
		gbc.insets = new Insets(5,5,5,5);										//Spacing for GridBagConstraints
		
		final JPanel secondPanel = new JPanel(new GridBagLayout()) {
	/*	@Override
		public Dimension getPreferredSize(){
			return new Dimension(300,450);
			}*/
		};
		
		addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
			setShape(new RoundRectangle2D.Float(secondPanel.getX(), secondPanel.getY(), secondPanel.getWidth(), secondPanel.getHeight(), 10, 10));
			}
		});
		
		//This is used for the Mouse Listener for to move the main screen
		secondGUI.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				point.x = e.getX();
				point.y = e.getY();
				}
			});
				
				//This is the Mouse Listener that well help move the JFrame 
				secondGUI.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent evt){
						Point p = secondGUI.getLocation();
						secondGUI.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
					}
				});
				
		secondGUI.setUndecorated(true);										//Remove borders from JFrame
		secondPanel.setBorder(new CurvedBorder(2,true));					//Adds Line Around Border of JFrame
		secondGUI.add(secondPanel);
		
		gbc.gridx = 0; gbc.gridy = 0;
		secondPanel.add(headerSecondScreen, gbc);
		
		gbc.gridx =0; gbc.gridy = 1;
		secondPanel.add(perButton,gbc);
		
		gbc.gridx =0; gbc.gridy= 2;
		secondPanel.add(nextButton, gbc);
		gbc.gridx=0; gbc.gridy=3;
		secondPanel.add(textArea,gbc);
		
		charGUI();
		invisibleRadioButton.setSelected(true);
		secondGUI.setLocationRelativeTo(null);								//Set the Location to Null
		secondGUI.pack();													//Sets Size to certain position
		secondGUI.setVisible(true);											//sets Visible to true
	}
	public void charGUI(){
	//	GridBagConstraints gbc = new GridBagConstraints();						//Used to put Labels,Buttons and so on in what ever order we like
	//	gbc.insets = new Insets(5,5,5,5);										//Spacing for GridBagConstraints
		JPanel mainPanel = new JPanel();
		
	/*	final JPanel charPanel = new JPanel(new GridBagLayout()) {
		@Override
		public Dimension getPreferredSize(){
			return new Dimension(300,450);
			}
		};
		
		addComponentListener(new ComponentAdapter() {
		@Override
		public void componentResized(ComponentEvent e) {
			setShape(new RoundRectangle2D.Float(charPanel.getX(), charPanel.getY(), charPanel.getWidth(), charPanel.getHeight(), 10, 10));
			}
		});
		*/
		//This is used for the Mouse Listener for to move the main screen
		charWindow.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				point.x = e.getX();
				point.y = e.getY();
				}
			});
				
				//This is the Mouse Listener that well help move the JFrame 
				charWindow.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent evt){
						Point p = charWindow.getLocation();
						charWindow.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
					}
				});
	
	//	charPanel.setBorder(new CurvedBorder(2,true));
		
		charWindow.setUndecorated(true);
		charWindow.add(mainPanel);
		charWindow.setBackground(new Color(0, 0, 0, 0));

		mainPanel.setOpaque(false);
		mainPanel.add(imageLabel);

		charWindow.setResizable(false);
		charWindow.pack();
		charWindow.setVisible(true);
	}//end of charGUI code

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
	 
	 
	       
	}//end of main
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		
		Object sourceObject =  evt.getSource();
		imageLabel.setIcon(saoImageList[0]);
		
		//String line = ResourceLoaderFolder.getFile("KiritoDoc.txt");
		//System.out.println(line);
		
		System.out.println(ResourceLoaderFolder.getFile("KiritoDoc.txt"));
		textArea.setText(ResourceLoaderFolder.getFile("KiritoDoc.txt"));
		
		if(sourceObject == infoButton){
			JOptionPane.showMessageDialog(this, "This Application gives information\n about SAO Characters");
		}
		
		//Used to open Character display
		if(sourceObject == enterButton){
			secondGUIDisplay();
			}
		//Used to move to following Character
		if(sourceObject == nextButton){
			
			if(count < saoImageList.length - 1)
			{
			System.out.println(++count);
			imageLabel.setIcon(saoImageList[count]);
			}
			else
			{
				count = 0;
				System.out.println(count);
			}
		}
		
		//Used to move to previous Characters
		if(sourceObject == perButton)
		{
			if(count <= 0 )
			{
				count = saoImageList.length ;
			}
			--count;
			System.out.println(count);
			imageLabel.setIcon(saoImageList[count]);
			}
		}
	}//end of ActionPerformed
