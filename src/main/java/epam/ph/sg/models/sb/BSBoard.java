package epam.ph.sg.models.sb;

/**
 * 
 * @author SergiyManko
 *
 */

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public class BSBoard {
	public List<String> a = new ArrayList<String>(10);
	public List<String> b = new ArrayList<String>(10);
	public List<String> c = new ArrayList<String>(10);
	public List<String> d = new ArrayList<String>(10);
	public List<String> e = new ArrayList<String>(10);
	public List<String> f = new ArrayList<String>(10);
	public List<String> g = new ArrayList<String>(10);
	public List<String> h = new ArrayList<String>(10);
	public List<String> i = new ArrayList<String>(10);
	public List<String> j = new ArrayList<String>(10);

	public BSBoard() {
		// TODO Auto-generated constructor stub
		for (int x = 0; x < 10; x++) {
			a.add("00");
			b.add("00");
			c.add("00");
			d.add("00");
			e.add("00");
			f.add("00");
			g.add("00");
			h.add("00");
			i.add("00");
			j.add("00");
		}
	}
	
	public String toString()
	{
		return a.get(0)+"test of BSBoard";
	}
}