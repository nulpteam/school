package epam.ph.sg.models.points;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class PtsJsonParser {

	private Logger logger;
	private ObjectMapper mapper;
	
	public PtsJsonParser() {
		logger = Logger.getLogger(PtsJsonParser.class);
		mapper = new ObjectMapper();
	}

	public PtsClientMessage parseJsonMessage(String json) {

		PtsClientMessage clientMessage = null;

		try {

			clientMessage = mapper.readValue(json, PtsClientMessage.class);

		} catch (JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		return clientMessage;
	}
	
	public String convertClientMessageToJson(PtsClientMessage message) {
		
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
	
public String convertGameInfoMessageToJson(PtsGameInfoMessage message) {
		
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
	
	/**������� �����������
	 * TODO
	 */
//	public String parseJsonMessageType(String json) {
//
//		Pattern typePattern = Pattern.compile("(?<=type\":\")\\w*");
//		Matcher matcher = typePattern.matcher(json);
//		if (matcher.find()) {
//			return matcher.group();
//		}
//		return "undefined";
//	}

	// ������� ������ ������, ���� ���� ������� ����
	// ���������� � �볺��� � ������������� �� �����
	// �� ������ ��������� ����� ���������� �� �����������
	// � ����� ���� �����, �� ���� ���������� 䳿 � ��� �����
	// togo �������
	// public String parseObjectToJsonString(Object object) {
	//
	// String jsonValue = "none";
	//
	// try {
	//
	// jsonValue = mapper.writeValueAsString(object);
	//
//	 } catch (JsonGenerationException e) {
//	 logger.error(e.getMessage());
//	 } catch (JsonMappingException e) {
//	 logger.error(e.getMessage());
//	 } catch (IOException e) {
//	 logger.error(e.getMessage());
//	 }
//	//
	// return jsonValue;
	// }
}
