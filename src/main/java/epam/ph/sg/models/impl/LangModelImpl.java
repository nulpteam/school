package epam.ph.sg.models.impl;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import epam.ph.sg.models.LangModel;

public class LangModelImpl implements LangModel {
	private String lang;
	private static Logger log = Logger.getLogger(LangModelImpl.class);
	// private ResourceBundle rb;

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

	public ResourceBundle getRb() {
		ResourceBundle rb = ResourceBundle.getBundle("lang_"
				+ this.getLang() + ".properties");
		log.debug("sent "+this.getLang()+" rb");
		return rb;
	}

}
