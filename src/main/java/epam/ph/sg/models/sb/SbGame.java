package epam.ph.sg.models.sb;

import java.util.ArrayList;
import java.util.List;


public class SbGame {

	private String title;
	private List<String> scripts = new ArrayList<String>();

	public List<String> getScripts() {
		return scripts;
	}

	public void addScript(String script)
	{
		/*доробити*/
	}

	public String getTitle() {
		
		return "lang"+title;
	}

}
