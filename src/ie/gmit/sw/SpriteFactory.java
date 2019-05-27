package ie.gmit.sw;

import java.awt.image.BufferedImage;

public class SpriteFactory {
	
	public static Sprite playerInstance() throws Exception{
		Sprite player = new Sprite();
		
		player.setName("Player 1");
		player.setPosition(new Point(0,0));
		player.drawSprite(ImageManager.loadImages("./resources/images/sprites/default", null));
		System.out.println("Factory drawn");
		return player;
	}
//	public Spriteator buildSprite(String type) {
//		Spriteator spriteable = null;
//		
//		if (type.equals("player")) {
//			spriteable = new Sprite(type, null);
//		}
//		
//		return spriteable;
//		
//	}
	
//	public static Tree treeInstance() throws Exception{
//		return new Tree();
//	}
	
//	public static Air airInstance() throws Exception{
//		return new Air();
//	}
//	
//	public static Hole holeInstance() throws Exception{
//		return new Hole();
//	}
//	
//	public static Chest chestInstance() throws Exception{
//		return new chest();
//	}
}
