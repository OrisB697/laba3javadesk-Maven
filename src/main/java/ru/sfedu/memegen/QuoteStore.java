package ru.sfedu.memegen;

import java.util.List;
import java.util.Random;

public final class QuoteStore {
    private final List<String> quotes;

    public QuoteStore() {
        this(List.of(
                "Всё будет хорошо — я проверял. Неизвестный оптимист",
                "Это же очевидно! Капитан Очевидность",
                "Работает — не трогай. Народная мудрость",
                "Сначала было слово. Программист",
                "Краткость — сестра таланта. А. П. Чехов",
                "Не откладывай на завтра то, что можно сделать послезавтра. Студент",
                "Знание — сила. Ф. Бэкон",
                "Терпение и труд всё перетрут. Пословица",
                "Семь раз отмерь — один раз отрежь. Пословица",
                "Тише едешь — дальше будешь. Пословица",
                "Утро вечера мудренее. Пословица",
                "Делу время — потехе час. Пословица",
                "Повторение — мать учения. Пословица",
                "Один в поле не воин. Пословица",
                "Не имей сто рублей, а имей сто друзей. Пословица",
                "Без труда не вытащишь и рыбку из пруда. Пословица"
        ));
    }

    public QuoteStore(List<String> quotes) {
        if (quotes.isEmpty()) {
            throw new IllegalArgumentException("Нужен хотя бы один мем");
        }
        this.quotes = List.copyOf(quotes);
    }

    public String randomQuote(Random random) {
        return quotes.get(random.nextInt(quotes.size()));
    }

    public int size() {
        return quotes.size();
    }
}