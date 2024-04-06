package com.guitarhero2004.icms;

/**
 * @author Tran Nguyen Anh Minh - s3979367
 * External sources and ideas: JLine3 documentation and examples, StackOverflow, ChatGPT
 */

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.guitarhero2004.icms.app.Home;

/**
 * The Main class serves as the entry point for the application.
 * It creates an instance of Terminal and Home.
 */
public class Main {
    /**
     * The main method is the entry point for the application.
     * It creates an instance of Terminal using the TerminalBuilder, and then creates an instance of Home, passing the Terminal instance to it.
     * @param args Command line arguments. Not used in this application.
     * @throws Exception If there's an error creating the Terminal or Home instances.
     */
    public static void main(String[] args) throws Exception {
        // Create a Terminal instance using the TerminalBuilder
        Terminal terminal = TerminalBuilder.builder().build();

        // Create a Home instance, passing the Terminal instance to it
        new Home(terminal);
    }
}