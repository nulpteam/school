package epam.ph.sg.models.points;

import java.util.ResourceBundle;

import epam.ph.sg.models.lang.UTF8Control;


public class PtsResources {

	private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
			"points", new UTF8Control());

	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}