package epam.ph.sg.models.sb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;

import epam.ph.sg.models.points.PtsWebSocketHandler;

public class JettyContext implements ServletContextListener {
	Server server = null;
	Server ptsServer = null;
	private static Logger log = Logger.getLogger(JettyContext.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// Створення серверів Jetty
			this.server = new Server(8081);
			this.ptsServer = new Server(8082);

			// Реєстрація хендлерів
			SbWebSocketHandler sbWSH = new SbWebSocketHandler();
			PtsWebSocketHandler ptsWSH = new PtsWebSocketHandler();
			// Для WebSocketHandlerContainer
			sbWSH.setHandler(new DefaultHandler());
			ptsWSH.setHandler(new DefaultHandler());
			// Вставляем наш хэндлер слушаться jetty
			server.setHandler(sbWSH);
			ptsServer.setHandler(ptsWSH);
			// Старт Jetty
			server.start();
			ptsServer.start();
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
				// server1.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}