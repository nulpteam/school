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
	
	private String[][] BoardtoArray()
	{
		String arr[][] = new String[10][10];
		for(int i=0;i<10;i++)
		{
			arr[0][i] = a.get(i);
			arr[1][i] = b.get(i);
			arr[2][i] = c.get(i);
			arr[3][i] = d.get(i);
			arr[4][i] = e.get(i);
			arr[5][i] = f.get(i);
			arr[6][i] = g.get(i);
			arr[7][i] = h.get(i);
			arr[8][i] = this.i.get(i);
			arr[9][i] = j.get(i);
		}
		return arr;
	}
	
	public String toString()
	{
		
		String[][] arr = BoardtoArray();
		StringBuilder sb  = new StringBuilder();
		sb.append("a=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[0][i]).append("?");
			
//			for(int j=0;j<10;j++)
//			{
//				sb.append(arr[i][j]).append("?");
//			}
		}
		sb.append("\nb=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[1][i]).append("?");		
		}
		sb.append("\nc=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[2][i]).append("?");		
		}
		sb.append("\nd=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[3][i]).append("?");		
		}
		sb.append("\ne=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[4][i]).append("?");		
		}
		sb.append("\nf=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[5][i]).append("?");		
		}
		sb.append("\ng=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[6][i]).append("?");		
		}
		sb.append("\nh=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[7][i]).append("?");		
		}
		sb.append("\ni=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[8][i]).append("?");		
		}
		sb.append("\nj=");
		for(int i=0;i<10;i++)
		{
			sb.append(arr[9][i]).append("?");		
		}
		return sb.toString();
	}
}