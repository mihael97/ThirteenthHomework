package hr.fer.zemris.java.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Class represents listener which listens when server is starting and saves
 * that moment in servlet context
 * 
 * @author Mihael
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	/**
	 * Method puts current time in miliseconds in servlet context map with key
	 * <code>time</code>
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().setAttribute("time", System.currentTimeMillis());
	}

	/**
	 * Not implemented
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}