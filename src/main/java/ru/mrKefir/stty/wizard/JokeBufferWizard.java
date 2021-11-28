package ru.mrKefir.stty.wizard;

import ru.mrKefir.stty.utils.JokePatterns;

public final class JokeBufferWizard implements BufferWizard {
    @Override
    public String transform(String buffer) {
        for (JokePatterns jokePattern : JokePatterns.values()) {
            if (buffer.contains(jokePattern.getPattern())) {
                return jokePattern.getAnswer();
            }
        }

        throw new RuntimeException("No such pattern in the JokePatterns");
    }
}
