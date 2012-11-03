/**
 * @author Gutey Bogdan
 * 
 */
package epam.ph.sg.models.sb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

import epam.ph.sg.models.points.PtsWebSocketHandler;
import epam.ph.sg.models.reversy.ReversyWebSocketHandler;

public class JettyContext implements ServletContextListener {
	Server server = null;
	Server ptsServer = null;
	Server reversyServer = null;
	private static Logger log = Logger.getLogger(JettyContext.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// Створення серверів Jetty
			this.server = new Server(8081);
			this.ptsServer = new Server(8082);
			this.reversyServer = new Server(8085);

			// Реєстрація хендлерів
			SbWebSocketHandler sbWSH = new SbWebSocketHandler();
			PtsWebSocketHandler ptsWSH = new PtsWebSocketHandler();
			ReversyWebSocketHandler reversyHandler = new ReversyWebSocketHandler();
			// Для WebSocketHandlerContainer
			sbWSH.setHandler(new DefaultHandler());
			ptsWSH.setHandler(new DefaultHandler());
			reversyHandler.setHandler(new DefaultHandler());
			// Вставляем наш хэндлер слушаться jetty
			server.setHandler(sbWSH);
			ptsServer.setHandler(ptsWSH);
			reversyServer.setHandler(reversyHandler);
			// Старт Jetty
			server.start();
			ptsServer.start();
			reversyServer.start();
			log.debug("+++++++++++++++++++++++++++Jetty started+++++++++++++++++++++++++++++++++++++++++");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (server != null && ptsServer != null) {
			try {
				// стопаєм Jetty
				server.stop();
				ptsServer.stop();
				reversyServer.stop();
				// server1.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}