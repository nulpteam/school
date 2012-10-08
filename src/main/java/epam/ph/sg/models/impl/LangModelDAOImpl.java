package epam.ph.sg.models.impl;

import epam.ph.sg.models.LangModelDAO;

public class LangModelDAOImpl implements LangModelDAO {
	private String lang;

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

}
