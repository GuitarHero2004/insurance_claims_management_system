package com.guitarhero2004.icms.lib;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.utils.NonBlockingReader;

public class Utils {
    public static void printDivider(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static String getDivider(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static class Console {
        public static char getch(Terminal term) throws IOException {
            NonBlockingReader reader = term.reader();

            // Set terminal into raw mode to read input character by character
            term.enterRawMode();

            while (true) {
                int key = reader.read();
                if (key == -1) {
                    continue;
                }

                char input = (char) key;

                // Restore terminal to normal mode
                term.close();

                return input;
            }

        }

        public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

    }
}
