package epam.ph.sg.models.points;

import java.io.IOException;

import org.eclipse.jetty.websocket.WebSocket;

import org.apache.log4j.Logger;


public class PtsWebSocketSpeeker implements WebSocket.OnTextMessage {
	
	private static Logger log = Logger.getLogger(PtsWebSocketSpeeker.class);
	private Connection conn;
	private PtsJsonParser jsonParser;
	
	public PtsWebSocketSpeeker() {
		jsonParser= new PtsJsonParser();
	}
	

	@Override
	public void onClose(int arg0, String arg1) {
		log.debug("++++++++++++Socket closed++++++++++++++");
	}

	@Override
	public void onOpen(Connection arg0) {
		log.debug("++++++++++++Socket created++++++++++++++");
		conn = arg0;
	}

	@Override
	public void onMessage(String arg0) {
		log.debug("++++++++++++Recieved message++++++++++++++");
		log.debug(arg0);
		try {
			PtsLastChanges game = PtsGameMap.getGames().get("0").getLasthangesInBoard();
			String json = jsonParser.parseObjectToJsonString(game);
			json = "{\"type\":\"message\"," + json.substring(1);
			System.out.println(json);
			conn.sendMessage(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
