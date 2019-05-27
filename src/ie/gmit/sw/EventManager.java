package ie.gmit.sw;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventManager implements KeyListener{

	private Sprite player;
	
	public EventManager(Sprite player) {
		this.player = player;
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Eventator#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("right");
			System.out.println("PLayer");
			player.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("left");
			player.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("Up");
			player.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Down");
			player.setDirection(Direction.DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			System.out.println("Toggle");
		} else if (e.getKeyCode() == KeyEvent.VK_X) {
			System.out.println("Move");
			player.move();
		} else {
			return;
		}
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Eventator#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	} // Ignore
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Eventator#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	} // Ignore

	
}
