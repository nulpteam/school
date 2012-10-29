package epam.ph.sg.models.points;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PtsJsonParser {
	private ObjectMapper mapper = new ObjectMapper();
	private JsonGenerator jsonGenerator;

	public String parseObjectToJsonString(Object object) {
		String jsonValue = "none";
		try {
			jsonValue = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonValue;
	}
}
