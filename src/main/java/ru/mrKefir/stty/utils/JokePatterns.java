package ru.mrKefir.stty.utils;

public enum JokePatterns {
    JOKE_1("Я хочу закрыть прогу", "Не мечтай, ты отправишься на допсу."),
    JOKE_2("Пожалуйста...", "Ничего не могу поделать, такова судьба :)");

    private final String pattern;
    private final String answer;

    JokePatterns(String pattern, String answer) {
        this.pattern = pattern;
        this.answer = answer;
    }

    public String getPattern() {
        return pattern;
    }

    public String getAnswer() {
        return answer;
    }
}
