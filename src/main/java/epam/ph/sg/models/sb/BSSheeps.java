package epam.ph.sg.models.sb;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class BSSheeps {
	public BSSheep sheep01 = new BSSheep();
	public BSSheep sheep02 = new BSSheep();
	public BSSheep sheep03 = new BSSheep();
	public BSSheep sheep04 = new BSSheep();
	public BSSheep sheep05 = new BSSheep();
	public BSSheep sheep06 = new BSSheep();
	public BSSheep sheep07 = new BSSheep();
	public BSSheep sheep08 = new BSSheep();
	public BSSheep sheep09 = new BSSheep();
	public BSSheep sheep10 = new BSSheep();

	public BSSheep getSheep01() {
		return sheep01;
	}

	public void setSheep01(BSSheep sheep01) {
		this.sheep01 = sheep01;
	}

	public BSSheep getSheep02() {
		return sheep02;
	}

	public void setSheep02(BSSheep sheep02) {
		this.sheep02 = sheep02;
	}

	public BSSheep getSheep03() {
		return sheep03;
	}

	public void setSheep03(BSSheep sheep03) {
		this.sheep03 = sheep03;
	}

	public BSSheep getSheep04() {
		return sheep04;
	}

	public void setSheep04(BSSheep sheep04) {
		this.sheep04 = sheep04;
	}

	public BSSheep getSheep05() {
		return sheep05;
	}

	public void setSheep05(BSSheep sheep05) {
		this.sheep05 = sheep05;
	}

	public BSSheep getSheep06() {
		return sheep06;
	}

	public void setSheep06(BSSheep sheep06) {
		this.sheep06 = sheep06;
	}

	public BSSheep getSheep07() {
		return sheep07;
	}

	public void setSheep07(BSSheep sheep07) {
		this.sheep07 = sheep07;
	}

	public BSSheep getSheep08() {
		return sheep08;
	}

	public void setSheep08(BSSheep sheep08) {
		this.sheep08 = sheep08;
	}

	public BSSheep getSheep09() {
		return sheep09;
	}

	public void setSheep09(BSSheep sheep09) {
		this.sheep09 = sheep09;
	}

	public BSSheep getSheep10() {
		return sheep10;
	}

	public void setSheep10(BSSheep sheep10) {
		this.sheep10 = sheep10;
	}

}
