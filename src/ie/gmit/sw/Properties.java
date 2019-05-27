package ie.gmit.sw;

public class Properties {

	private static final int DEFAULT_IMAGE_INDEX = 0;
	private static final int DEFAULT_VIEW_SIZE = 1280;
	private static final int TILE_WIDTH = 128;
	private static final int TILE_HEIGHT = 64;
	
	public static int getDefaultImageIndex() {
		return DEFAULT_IMAGE_INDEX;
	}
	public static int getDefaultViewSize() {
		return DEFAULT_VIEW_SIZE;
	}
	public static int getTileWidth() {
		return TILE_WIDTH;
	}
	public static int getTileHeight() {
		return TILE_HEIGHT;
	}
}
