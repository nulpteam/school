/**
 * 
 */
package epam.ph.sg.tab.twopenguins;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import epam.ph.sg.models.infection.InfJsonParser;

/**
 * @author roman
 * 
 */
public class TwoPenguinsJsonParser {
	private Logger logger;
	private ObjectMapper mapper;

	public TwoPenguinsJsonParser() {
		logger = Logger.getLogger(InfJsonParser.class);
		mapper = new ObjectMapper();
	}

	public TwoPenguinsMessage parseJsonMessage(String json) {

		TwoPenguinsMessage clientMessage = null;

		try {

			clientMessage = mapper.readValue(json, TwoPenguinsMessage.class);

		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return clientMessage;
	}

	public String convertClientMessageToJson(TwoPenguinsMessage message) {

		String jsonValue = null;

		try {

			jsonValue = mapper.writeValueAsString(message);

		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return jsonValue;
	}
}
