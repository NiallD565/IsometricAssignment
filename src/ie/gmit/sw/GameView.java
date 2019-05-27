package ie.gmit.sw;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/*
 * This is a God class and is doing way too much. The instance variables cover everything from isometric to 
 * Cartesian drawing and the class has methods for loading images and converting from one coordinate space to
 * another.
 * 
 */
public class GameView extends JPanel implements ActionListener { 
	
	private static final long serialVersionUID = 777L;

	private Timer timer; //Controls the repaint interval.
	private Sprite player;
	private ImageManager img;
	private Iso iso;
	//private EventManager manager;

	//Do we really need two models like this?
	private int[][] matrix;
	private int[][] things;
	
	private BufferedImage[] tiles; //Note that all images, including sprites, have dimensions of 128 x 64. This make painting much simpler.
	private BufferedImage[] objects; //Taller sprites can be created, by using two tiles (head torso, lower body and legs) and improve animations
	private Color[] cartesian = {Color.GREEN, Color.GRAY, Color.DARK_GRAY, Color.ORANGE, Color.CYAN, Color.YELLOW, Color.PINK, Color.BLACK}; //This is a 2D representation
	
	private boolean isIsometric = true; //Toggle between 2D and Isometric (Z key)
	
	public GameView(int[][] matrix, int[][] things, Sprite player) throws Exception {
		this.player = player;
		img = new ImageManager();
		iso = new Iso();
		
		
		init();
		this.matrix = matrix;
		this.things = things;
		
		setBackground(Color.WHITE);
		setDoubleBuffered(true); //Each image is buffered twice to avoid tearing / stutter
		
		timer = new Timer(100, (ActionListener) this); //calls the actionPerformed() method every 100ms
		timer.start(); //Start the time
	}
	
	private void init() throws Exception {
		tiles = img.loadImages("./resources/images/ground", tiles);
		objects = img.loadImages("./resources/images/objects", objects);
		//player = SpriteFactory.playerInstance();
	}
	
	public void toggleView() {
		isIsometric = !isIsometric;
		this.repaint();
	}

	public void paintComponent(Graphics g) { //This method needs to execute quickly...
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int imageIndex = -1, x1 = 0, y1 = 0;
		Point point;
		
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				imageIndex = matrix[row][col];
				
				if (imageIndex >= 0 && imageIndex < tiles.length) {
					//Paint the ground tiles
					if (isIsometric) {
						x1 = iso.getIsoX(col, row);
						y1 = iso.getIsoY(col, row);
						
						g2.drawImage(tiles[Properties.getDefaultImageIndex()], x1, y1, null);
						if (imageIndex > Properties.getDefaultImageIndex()) {
							g2.drawImage(tiles[imageIndex], x1, y1, null);
						}
					} else {
						x1 = col * Properties.getTileWidth();
						y1 = row * Properties.getTileHeight();
	        			if (imageIndex < cartesian.length) {
	        				g2.setColor(cartesian[imageIndex]);
	        			}else {
	        				g2.setColor(Color.WHITE);
	        			}
						
	        			g2.fillRect(x1, y1, Properties.getTileWidth(), Properties.getTileWidth());
					}
					//Paint the object or things on the ground
					imageIndex = things[row][col];
					g2.drawImage(objects[imageIndex], x1, y1, null);
				}
			}
		}
		
		//Paint the player on  the ground
		point = iso.getIso(player.getPosition().getX(), player.getPosition().getY());
		g2.drawImage(player.getImage(), point.getX(), point.getY(), null);
	}
	

		
		

	public void actionPerformed(ActionEvent e) { //This is called each time the timer reaches zero
		this.repaint();
	}
}