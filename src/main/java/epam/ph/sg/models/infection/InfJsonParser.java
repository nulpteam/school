/**
 * 
 */
package epam.ph.sg.models.infection;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author roman
 *
 */
public class InfJsonParser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9138554779613955671L;
	private Logger logger;
	private ObjectMapper mapper;

	public InfJsonParser() {
		logger = Logger.getLogger(InfJsonParser.class);
		mapper = new ObjectMapper();
	}

	public InfClientMessage parseJsonMessage(String json) {

		InfClientMessage clientMessage = null;

		try {

			clientMessage = mapper.readValue(json, InfClientMessage.class);

		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return clientMessage;
	}

	public String convertClientMessageToJson(InfClientMessage message) {

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
