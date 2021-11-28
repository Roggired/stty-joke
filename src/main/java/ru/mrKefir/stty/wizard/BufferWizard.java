package ru.mrKefir.stty.wizard;

/**
 * Defines some magic that will be invoked on current line buffer.
 * The result of {@link BufferWizard#transform(String)} will be printed on
 * the screen.
 *
 * @author Mr.Kefir
 */
public interface BufferWizard {
    String transform(String buffer);
}
