package ru.mrKefir.stty;

import ru.mrKefir.stty.condition.JokeWizardCondition;
import ru.mrKefir.stty.joker.Joker;
import ru.mrKefir.stty.utils.ExitCondition;
import ru.mrKefir.stty.utils.JokePatterns;
import ru.mrKefir.stty.wizard.BufferWizard;
import ru.mrKefir.stty.wizard.JokeBufferWizard;

public class App {
    public static void main(String[] args) {
        BufferWizard bufferWizard = new JokeBufferWizard();
        Joker joker = new Joker(bufferWizard);
        joker.add(new JokeWizardCondition(JokePatterns.JOKE_1.getPattern()))
             .add(new JokeWizardCondition(JokePatterns.JOKE_2.getPattern()))
             .add(new JokeWizardCondition(ExitCondition.PATTERN))
             .start();
    }
}
