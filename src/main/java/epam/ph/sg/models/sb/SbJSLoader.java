/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.sb;

import java.util.LinkedHashSet;
import java.util.Set;


public class SbJSLoader {

	//Ліст скріптів
	private Set<String> scripts = new LinkedHashSet<String>();
	
	public Set<String> getScripts() {
		return scripts;
	}

	public void addScript(String script)
	{
		scripts.add("js/"+script+".js");
	}
}
