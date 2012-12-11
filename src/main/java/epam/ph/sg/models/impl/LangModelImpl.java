/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.impl;

import org.apache.log4j.Logger;

import epam.ph.sg.models.LangModel;

public class LangModelImpl implements LangModel {
	private  String lang;
	
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String lang() {

		return lang;
	}

//	public Map<String, String> getRb() {
//		ResourceBundle rb = ResourceBundle.getBundle("lang_"
//				+ this.getLang());
//		log.debug("+++++++++++++++++++++++++test of RB= "+rb.getString("test")+" from lang_"+ this.getLang()+"+++++++++++");
//		Enumeration<String> keys = rb.getKeys();
//		Map<String,String> rbl = new HashMap<String,String>();
//		while(keys.hasMoreElements())
//		{
//			String key = keys.nextElement();
//			rbl.put(key, rb.getString(key));
//		}
//		log.debug("sent "+this.getLang()+" rb");
//		return rbl;
//	}
}
