/**
 * @author Bogdan Gutey
 */
package epam.ph.sg.models.sb;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonParser {
	private ObjectMapper mapper = new ObjectMapper();

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
}
