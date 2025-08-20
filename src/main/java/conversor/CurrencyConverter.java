package conversor;

import java.util.Map;

public class CurrencyConverter {

    public static double convert(String from, String to, double amount, Map<String, Double> rates) {
        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            throw new IllegalArgumentException("Moneda no soportada.");
        }

        double fromRate = rates.get(from);
        double toRate = rates.get(to);

        return (amount / fromRate) * toRate;
    }
}
