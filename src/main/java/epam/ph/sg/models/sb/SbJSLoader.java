/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.sb;

import java.util.ArrayList;
import java.util.List;


public class SbJSLoader {

	private String title="title";
	private List<String> scripts = new ArrayList<String>();
		

	public List<String> getScripts() {
		return scripts;
	}

	public void addScript(String script)
	{
		scripts.add("js/"+script+".js");
	}

	public String getTitle() {
		
		return title;
	}

}