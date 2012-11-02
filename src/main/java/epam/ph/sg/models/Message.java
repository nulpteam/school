/**
 * 
 */
package epam.ph.sg.models;

/**
 * @author Roman Makovyak
 *
 */
public class Message {

	private boolean alreadyReg;
	private boolean noUserFound;

	public Message(){
		this.setAlreadyReg(false);
		this.setNoUserFound(false);
	}

	public boolean isAlreadyReg() {
		return alreadyReg;
	}

	public void setAlreadyReg(boolean alreadyReg) {
		this.alreadyReg = alreadyReg;
	}

	public boolean isNoUserFound() {
		return noUserFound;
	}

	public void setNoUserFound(boolean noUserFound) {
		this.noUserFound = noUserFound;
	}




}
