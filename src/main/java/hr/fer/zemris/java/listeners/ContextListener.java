package hr.fer.zemris.java.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	/**
	 * Not implemented
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	/**
	 * Method is called when listener is initialized. Listener puts current time as
	 * attribute with key <code>"time"</code>
	 * 
	 * @param event
	 *            - servelt context event
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("time", System.currentTimeMillis());
	}

}
