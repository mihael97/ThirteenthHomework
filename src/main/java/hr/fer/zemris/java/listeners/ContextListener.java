package hr.fer.zemris.java.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		servletContextEvent.getServletContext().setAttribute("time", System.currentTimeMillis());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
	}
}
