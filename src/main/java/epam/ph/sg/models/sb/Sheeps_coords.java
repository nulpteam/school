/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.sb;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class Sheeps_coords {

	List<String> a = new ArrayList<String>();
	List<String> b = new ArrayList<String>();
	List<String> c = new ArrayList<String>();
	List<String> d = new ArrayList<String>();
	List<String> e = new ArrayList<String>();
	List<String> f = new ArrayList<String>();
	List<String> g = new ArrayList<String>();
	List<String> h = new ArrayList<String>();
	List<String> i = new ArrayList<String>();
	List<String> j = new ArrayList<String>();

	public List<String> getA() {
		return a;
	}

	public List<String> getB() {
		return b;
	}

	public List<String> getC() {
		return c;
	}

	public List<String> getD() {
		return d;
	}

	public List<String> getE() {
		return e;
	}

	public List<String> getF() {
		return f;
	}

	public List<String> getG() {
		return g;
	}

	public List<String> getH() {
		return h;
	}

	public List<String> getI() {
		return i;
	}

	public List<String> getJ() {
		return j;
	}

}
