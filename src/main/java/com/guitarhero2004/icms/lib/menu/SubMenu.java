package com.guitarhero2004.icms.lib.menu;

import org.jline.terminal.Terminal;

public class SubMenu extends MenuList {

    public SubMenu(Terminal term) {
        super(term);
    }

    @Override
    protected void displayKeybinds() {
        System.out.println(String.format(
                "%s | %s | %s%n",
                "<1-9>: select option",
                "Exit: e",
                "Back: b"));
    }

}
