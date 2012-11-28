package epam.ph.sg.tab.minesweeper;

public class MSBox {
	private boolean visible = false;
	private boolean locked = false;
	private boolean mine;
	private int minesAround = 0;
	
	public MSBox(boolean mine) {
		this.mine = mine;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isMine() {
		return mine;
	}
	
	public int getMinesAround() {
		return minesAround;
	}
	
	public void incMinesAround() {
		this.minesAround++;
	}
}
