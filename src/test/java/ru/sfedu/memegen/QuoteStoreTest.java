package ru.sfedu.memegen;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuoteStoreTest {

    @Test
    void randomQuoteComesFromStore() {
        List<String> given = List.of("Раз. Автор Раза", "Два. Автор Два");
        QuoteStore store = new QuoteStore(given);
        for (int i = 0; i < 10; i++) {
            assertTrue(given.contains(store.randomQuote(new Random())));
        }
    }

    @Test
    void defaultStoreIsBigEnough() {
        assertTrue(new QuoteStore().size() >= 15);
    }

    @Test
    void emptyStoreIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuoteStore(List.of()));
    }
}