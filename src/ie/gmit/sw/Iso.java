package ie.gmit.sw;

public class Iso {

	// This method breaks the SRP
	public int getIsoX(int x, int y) {
		int rshift = (Properties.getDefaultViewSize() / 2) - (Properties.getTileWidth() / 2) + (x - y); // Pan camera to the right
		return (x - y) * (Properties.getTileWidth() / 2) + rshift;
	}

	// This method breaks the SRP
	public int getIsoY(int x, int y) {
		return (x + y) * (Properties.getTileHeight() / 2);
	}

	// This method breaks the SRP
	public Point getIso(int x, int y) {
		return new Point(getIsoX(x, y), getIsoY(x, y)); // Could be more efficient...
	}

}
