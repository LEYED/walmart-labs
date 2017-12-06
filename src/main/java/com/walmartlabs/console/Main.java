package com.walmartlabs.console;

/**
 * Created by LEYED on 12/4/17.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManagerImpl();
        consoleManager.startListeningCommands();
    }
}
