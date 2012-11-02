/**
 * @author Gutey Bogdan
 */
package epam.ph.sg.models.lang;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class LangSelector {
	private static Logger log = Logger.getLogger(LangSelector.class);

	public Map<String, String> getRb(String lang) {
		ResourceBundle rb = ResourceBundle.getBundle("lang_" + lang, new UTF8Control());
		Enumeration<String> keys = rb.getKeys();
		Map<String, String> rbl = new HashMap<String, String>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			rbl.put(key, rb.getString(key));
		}
		log.debug("RB map created. Size= " + rbl.size() + " elements");

		return rbl;
	}
	
}
