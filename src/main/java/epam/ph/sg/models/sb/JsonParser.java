/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.sb;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import epam.ph.sg.controllers.SBController;

public class JsonParser {
	private ObjectMapper mapper = new ObjectMapper();
	private static Logger log = Logger.getLogger(JsonParser.class);

	public BSBoard parseJsonSheepsCoordenates(String json) {
		BSBoard d = null;
		try {
			d = mapper.readValue(json, BSBoard.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
	public BSSheeps parseJsonSheepsReady(String json) {
		log.debug("parseJsonSheepsReady="+json);
		BSSheeps d = null;
		try {
			d = mapper.readValue(json, BSSheeps.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return d;
	}
}
