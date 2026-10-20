package com.yourdomain;

import com.yourdomain.dao.ScenarioDao;
import com.yourdomain.ui.ScenarioMenu;

public class Main {
    public static void main(String[] args) {
        try {
            ScenarioDao dao = new ScenarioDao();
            dao.initializeDatabase();
            new ScenarioMenu(dao).run();
        } catch (Exception e) {
            System.err.println("Unable to start the Water Refilling Station system.");
            System.err.println("Details: " + e.getMessage());
            System.err.println("Check that scenario.db is in the project root and that it is writable.");
        }
    }
}
