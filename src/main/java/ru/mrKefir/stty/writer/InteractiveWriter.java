package ru.mrKefir.stty.writer;

import ru.mrKefir.stty.utils.Delay;

import java.io.PrintStream;

public final class InteractiveWriter {
    private final PrintStream printStream = System.out;


    public void write(String message) {
        clearLine();

        // trick to write at the same line
        printStream.print('\r');

        for (char symbol : message.toCharArray()) {
            if (symbol == ' ') {
                Delay.delay(300);
            } else {
                Delay.delay(100);
            }

            printStream.print(symbol);
        }
    }

    public void clearLine() {
        // trick to hide old input
        printStream.print('\r');
        printStream.print("                                                                                         ");
        printStream.print('\r');
    }

    public void writeImmediately(String message) {
        clearLine();

        printStream.print('\r');
        printStream.print(message);
    }

    public void writeln(String message) {
        write(message);
        printStream.println();
    }

    public void writeln() {
        printStream.println();
    }
}
