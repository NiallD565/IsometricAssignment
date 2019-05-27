package ie.gmit.sw;

/*
 *   
 *   BufferedImage[][]
 *   --------------------------
 *   {U0, U1, U2, U3}, =>Up
 *   {D0, D1, D2, D3}, =>Down
 *   {L0, L1, L2, L3}, =>Left
 *   {R0, R1, R2, R3}, =>Right
 * 
 */

import java.awt.image.*;
public class Sprite implements Spriteator { //Sprite belongs in some sort of hierarchy....
	private String name; //The name of the sprite
	private BufferedImage[][] images = new BufferedImage[4][3]; //The images used in the animation 
	private Direction direction = Direction.DOWN; //The current orientation of the sprite
	private int index = 0; //The current image index.
	private Point position; //The current x, y position
	
	public Sprite() {
		super();
	}
	
	public Sprite(String name, Point p) {
		super();
		this.name = name;
		this.position = p;
		System.out.println("position set");
	}
	
	public void drawSprite(BufferedImage[] img) {
		int row = 0, col = 0;
		for (int i = 0; i < img.length; i++) {
			images[row][col] = img[i];
			if (col == images[row].length - 1) {
				row++;
				col = 0;
			}else {
				col++;
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#getPosition()
	 */
	@Override
	public Point getPosition() {
		return position;
	}

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#getImage()
	 */
	public BufferedImage getImage() {
		return images[direction.getOrientation()][index];
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#step(ie.gmit.sw.Direction)
	 */
	public BufferedImage step(Direction d) {
		setDirection(d);
		if (index < images[direction.getOrientation()].length - 1) {
			index++;
		}else {
			index = 0;
		}
		
		return images[d.getOrientation()][index];
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#setDirection(ie.gmit.sw.Direction)
	 */
	public void setDirection(Direction d) {
		direction = d;
	}
	
    /* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#getDirection()
	 */
    public Direction getDirection() {
        return this.direction;
    }
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Moveable#move()
	 */
	public void move() { //This method is suspiciously like one I've seen already....
		step(direction);
		
		switch(direction.getOrientation()) {
		case 1:
			position.setY(position.getY() + 1); //UP
			System.out.println("up");
			break;
		case 2:
			position.setX(position.getX() - 1); //DOWN
			System.out.println("down");
			break;
		case 3:
			position.setX(position.getX() + 1); //LEFT
			System.out.println("left");
			break;
		default:
			position.setY(position.getY() - 1); //RIGHT
			System.out.println("right");
			break;
		}
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		this.position = position;
	}
}