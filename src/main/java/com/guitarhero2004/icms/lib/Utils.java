package com.guitarhero2004.icms.lib;

import java.io.IOException;
import java.util.Collection;
import java.util.function.Consumer;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.jline.utils.NonBlockingReader;

import com.guitarhero2004.icms.database.AbstractDB;

public class Utils {
    public static void printDivider(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print("─");
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

        public static <T> T promptForInput(String prompt, LineReader lineReader, AbstractDB<T> db,
                Consumer<Collection<?>> displayData) {
            return promptForInput(prompt, lineReader, db.getAll(), displayData);
        }

        public static <T> T promptForInput(String prompt, LineReader lineReader, Collection<T> list,
                Consumer<Collection<?>> displayData) {
            while (true) {
                System.out.println("\n[v to view | s to skip]");
                String input = lineReader.readLine(prompt);
                switch (input) {
                    case "v":
                        displayData.accept(list);
                        System.out.println();
                        break;
                    case "s":
                        return null;
                    default:
                        if (input.trim().matches("\\d+")) {
                            int index = Integer.parseInt(input);
                            if (index > 0 && index <= list.size()) {
                                return list.stream().skip(index-1).findFirst().get();
                            }
                            System.out.println("Invalid index");
                        } else {
                            System.out.println("Invalid input");
                        }
                }
            }
        }

    }
}
