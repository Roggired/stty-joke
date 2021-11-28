package ru.mrKefir.stty.reader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public final class TrickyReader {
    private final char[] buffer;
    private int bufferPointer;

    private final Reader reader;


    public TrickyReader() {
        buffer = new char[1024];
        bufferPointer = 0;
        reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    }


    public void read() {
        if (bufferPointer > buffer.length) {
            throw new RuntimeException("Internal buffer overflow error");
        }

        try {
            char symbol = (char) reader.read();
            putInBuffer(symbol);
        } catch (IOException e) {
            throw new RuntimeException("Unexpected exception", e);
        }
    }

    public void drop(int numberOfSymbols) {
        if (numberOfSymbols > bufferPointer) {
            bufferPointer = 0;
            return;
        }

        bufferPointer -= numberOfSymbols;
    }

    public boolean isLastBackspace() {
        if (bufferPointer == 0) {
            return false;
        }

        return buffer[bufferPointer - 1] == 127;
    }

    public String getCurrentLine() {
        char[] chars = new char[bufferPointer];
        System.arraycopy(buffer, 0, chars, 0, bufferPointer);
        return new String(chars);
    }

    public void clearBuffer() {
        bufferPointer = 0;
    }

    private void putInBuffer(char symbol) {
        buffer[bufferPointer] = symbol;
        bufferPointer++;
    }
}
