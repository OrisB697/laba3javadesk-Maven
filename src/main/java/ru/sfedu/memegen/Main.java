package ru.sfedu.memegen;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public final class Main {
    private Main() { }

    public static void main(String[] args) throws Exception {
        String version = loadVersion();
        System.out.println("Memegen v" + version);

        AnsiConsole.systemInstall();
        String quote = new QuoteStore().randomQuote(new Random());
        System.out.println(Ansi.ansi()
                .fgBright(Ansi.Color.CYAN)
                .a(quote)
                .reset());
        AnsiConsole.systemUninstall();
    }

    private static String loadVersion() throws Exception {
        Properties props = new Properties();
        try (InputStream in = Main.class.getResourceAsStream("/version.properties")) {
            if (in != null) {
                props.load(in);
            }
        }
        return props.getProperty("app.version", "unknown");
    }
}
