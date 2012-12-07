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

import epam.ph.sg.games.xo.XoWebSocketHandler;
import epam.ph.sg.models.infection.InfWebSocketHandler;
import epam.ph.sg.models.points.PtsWebSocketHandler;
import epam.ph.sg.models.reversy.ReversyWebSocketHandler;
import epam.ph.sg.tab.chat.ChatWebSocketHandler;

public class JettyContext implements ServletContextListener {
	Server server = null;
	Server ptsServer = null;
	Server reversyServer = null;
	Server infectionServer = null;
	Server xoServer = null;
	Server chatServer = null;
	private static Logger log = Logger.getLogger(JettyContext.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			// Створення серверів Jetty
			this.server = new Server(8081);
			this.ptsServer = new Server(8082);
			this.reversyServer = new Server(8085);
			this.infectionServer = new Server(8086);
			this.xoServer = new Server(8088);
			this.chatServer = new Server(8089);

			// Реєстрація хендлерів
			SbWebSocketHandler sbWSH = new SbWebSocketHandler();
			PtsWebSocketHandler ptsWSH = new PtsWebSocketHandler();
			ReversyWebSocketHandler reversyHandler = new ReversyWebSocketHandler();
			InfWebSocketHandler infWHS = new InfWebSocketHandler();
			XoWebSocketHandler xoWSH = new XoWebSocketHandler();
			ChatWebSocketHandler chatWSH = new ChatWebSocketHandler();
			// Для WebSocketHandlerContainer
			sbWSH.setHandler(new DefaultHandler());
			ptsWSH.setHandler(new DefaultHandler());
			reversyHandler.setHandler(new DefaultHandler());
			infWHS.setHandler(new DefaultHandler());
			xoWSH.setHandler(new DefaultHandler());
			chatWSH.setHandler(new DefaultHandler());
			// Вставляем наш хэндлер слушаться jetty
			server.setHandler(sbWSH);
			ptsServer.setHandler(ptsWSH);
			reversyServer.setHandler(reversyHandler);
			infectionServer.setHandler(infWHS);
			xoServer.setHandler(xoWSH);
			chatServer.setHandler(chatWSH);
			// Старт Jetty
			server.start();
			ptsServer.start();
			reversyServer.start();
			infectionServer.start();
			xoServer.start();
			chatServer.start();
			log.debug("+++++++++++++++++++++++++++Jetty started+++++++++++++++++++++++++++++++++++++++++");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (server != null && ptsServer != null) {
			try {
				// ������ Jetty
				server.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ptsServer != null) {
			try {
				// ������ Jetty
				ptsServer.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (reversyServer != null) {
			try {
				// ������ Jetty
				reversyServer.stop();
				log.debug("+++++++++++++++++++++++++++Reversy Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (infectionServer != null) {
			try {
				// ������ Jetty
				infectionServer.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (xoServer != null) {
			try {
				xoServer.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped (XO)+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (chatServer != null) {
			try {
				chatServer.stop();
				log.debug("+++++++++++++++++++++++++++Jetty stoped (Chat)+++++++++++++++++++++++++++++++++++++++++");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
