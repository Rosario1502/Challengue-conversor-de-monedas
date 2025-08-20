package conversor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConversionHistory {
    private final List<String> history = new ArrayList<>();

    public void add(String from, String to, double amount, double result) {
        String entry = String.format("%s - %.2f %s -> %.2f %s",
                LocalDateTime.now(), amount, from, result, to);
        history.add(entry);
    }

    public void show() {
        if (history.isEmpty()) {
            System.out.println("No hay historial.");
        } else {
            System.out.println("\nHistorial de conversiones:");
            history.forEach(System.out::println);
        }
    }
}
