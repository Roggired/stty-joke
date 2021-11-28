package ru.mrKefir.stty.condition;

public final class JokeWizardCondition implements WizardCondition {
    private final String pattern;


    public JokeWizardCondition(String pattern) {
        this.pattern = pattern;
    }


    @Override
    public boolean handle(String buffer) {
        return buffer.contains(pattern);
    }
}