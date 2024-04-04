package com.guitarhero2004.icms;


import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import com.guitarhero2004.icms.app.Home;

public class Main {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.builder().build();

        new Home(terminal);
    }
}
