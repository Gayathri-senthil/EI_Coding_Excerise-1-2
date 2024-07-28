package com.singleton;

public class LogisticsManager {
    public void printConfiguration() {
        ConfigurationManager configManager = ConfigurationManager.getInstance();
        String warehouseLocation = configManager.getProperty("warehouse.location");
        System.out.println("Warehouse Location: " + warehouseLocation);
    }
}
