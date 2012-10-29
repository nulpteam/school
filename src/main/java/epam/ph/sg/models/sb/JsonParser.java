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

	public Sheeps_coords parseJsonSheepsCoordenates(String json) {
		Sheeps_coords d = null;
		try {
			d = mapper.readValue(json, Sheeps_coords.class);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
