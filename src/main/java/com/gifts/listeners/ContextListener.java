package com.gifts.listeners;

import com.gifts.utils.DatabaseConnection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseConnection.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseConnection.getInstance().destroy();
    }
}