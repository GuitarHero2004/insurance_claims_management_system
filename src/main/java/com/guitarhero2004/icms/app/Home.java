package com.guitarhero2004.icms.app;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

import com.guitarhero2004.icms.lib.menu.MenuItem;
import com.guitarhero2004.icms.lib.menu.MenuList;

public class Home {

    // private final Terminal term;

    LineReader lineReader;

    private final MenuList menu;

    public Home(Terminal term) throws Exception {
        // this.term = term;
        this.lineReader = LineReaderBuilder.builder().terminal(term).build();
        this.menu = new MenuList(term);

        // Dependents
        new DependentMenu(term, menu);

        // Policy holders
        new PolicyHolderMenu(term, menu);

        // Cards
        new CardMenu(term, menu);

        // Claims
        new ClaimMenu(term, menu);

        menu.run();
    }

}
