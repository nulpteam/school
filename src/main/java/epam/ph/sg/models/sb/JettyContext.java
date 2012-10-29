package epam.ph.sg.models.sb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;


public class JettyContext implements ServletContextListener{
 Server server = null;
 private static Logger log = Logger.getLogger(JettyContext.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
            // Создание сервера Jetty на 8081 порту
            this.server = new Server(8081);
            
            // Регистрируем ChatWebSocketHandler в сервере Jetty
            SbWebSocketHandler sbWSH = new SbWebSocketHandler();
            // Это вариант хэндлера для WebSocketHandlerContainer
            sbWSH.setHandler(new DefaultHandler());
            
            // Вставляем наш хэндлер слушаться jetty
            server.setHandler(sbWSH);
            
            // Запускаем Jetty
            server.start();
            log.debug("+++++++++++++++++++++++++++Jetty started+++++++++++++++++++++++++++++++++++++++++");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 // Если сервер jetty когда-нибудь запустился
        if (server != null) {
            try {
                // останавливаем Jetty
                server.stop();
                log.debug("+++++++++++++++++++++++++++Jetty stoped+++++++++++++++++++++++++++++++++++++++++");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
		
}