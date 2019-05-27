package ie.gmit.sw;

import java.awt.*;

import javax.swing.*;
public class GameWindow {
	/*
	 * This matrix represents the isometric game model, with each number mapping to an
	 * image in the images/ground/ directory.
	 */
	private int[][] model = { 
			{ 1, 0, 0, 0, 0, 0 , 0, 0, 0, 2, 2},
			{ 0, 1, 0, 0, 0, 0 , 0, 0, 0, 2, 2},
			{ 0, 0, 2, 0, 0, 0 , 0, 0, 0, 2, 2},
			{ 0, 0, 0, 1, 0, 0 , 0, 0, 0, 2, 2},
			{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2, 2},
			{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1, 2},
			{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1, 1},
			{ 4, 4, 4, 5, 3, 3 , 1, 0, 0, 0, 0},
			{ 4, 4, 4, 4, 5, 3 , 1, 6, 6, 6, 6},
			{ 4, 4, 4, 4, 4, 3 , 1, 7, 7, 7, 7},
			{ 4, 4, 4, 4, 3 , 1, 7, 7, 7, 7, 6}

	};
	
	//This matrix is a representation of where objects (things) in the game are placed
	private int[][] objects = { 
			{ 0, 0, 0, 5, 5, 5 , 5, 5, 5, 0, 0},
			{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0, 0},
			{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9, 0},
			{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0, 0},
			{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0, 0}
	};
	
	private ImageManager img;
	private Sprite player;
	
	public GameWindow() throws Exception {
		
		img = new ImageManager();
		//player = new Sprite("Player 2", new Point(0, 0), img.loadImages("./resources/images/sprites/default", null));
		player = SpriteFactory.playerInstance();
		
		GameView view = new GameView(model, objects, player);
		EventManager manager = new EventManager(player);
		Dimension d = new Dimension(Properties.getDefaultViewSize(), Properties.getDefaultViewSize()/2);
		view.setPreferredSize(d);
		view.setMinimumSize(d);
		view.setMaximumSize(d);

		JFrame f = new JFrame("GMIT - B.Sc. in Computing (Software Development)");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout());
		f.add(view);
		f.addKeyListener(manager);
		f.setSize(1000, 1000);
		f.setLocation(100, 100);
		f.pack();
		f.setVisible(true);
	}
}