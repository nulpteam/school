package epam.ph.sg.models.impl;

import epam.ph.sg.models.LangModelDAO;

public class LangModelDAOImpl implements LangModelDAO {
private String lang;




public String getDefaultLang() {
	return lang;
}


public void setDefaultLang(String defaultLang) {
	this.lang = defaultLang;
}


@Override
public String lang() {
	
	return lang;
}


}
