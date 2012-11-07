package epam.ph.sg.models.points;

public class PtsCoord {

	private int y, x;

	public PtsCoord(int y, int x) {
		
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String toString() {
		return "[" + y + "][" + x + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PtsCoord coord = (PtsCoord) obj;
		return (this.x == coord.getX() && this.y == coord.getY());
	}
}
