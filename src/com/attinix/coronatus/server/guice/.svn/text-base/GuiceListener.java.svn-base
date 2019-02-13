package com.attinix.coronatus.server.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.attinix.coronatus.server.ibatis.IbatisModule;
import com.google.inject.Guice;

public final class GuiceListener implements ServletContextListener
{
    public static final String GUICE_INJECTOR = "Guice_Injector";

    public void contextDestroyed(ServletContextEvent event)
    {
        // Nothing to do
    }

    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext context = event.getServletContext();

        try
        {
            context.setAttribute(GUICE_INJECTOR, Guice.createInjector(
                    new Modulo(), new IbatisModule()));
        }
        catch (Exception exception)
        {
            context.log("Unable to load Guice Module", exception);
        }
    }
}
