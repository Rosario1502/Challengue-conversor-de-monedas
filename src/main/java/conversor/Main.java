package conversor;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyService service = new CurrencyService();
        ConversionHistory history = new ConversionHistory();
        Scanner scanner = new Scanner(System.in);

        try {
            CurrencyResponse response = service.getRates();
            Map<String, Double> rates = response.getConversionRates();

            while (true) {
                System.out.println(" *************************************************************** ");

                System.out.println("\n ¬¬¬¬¬  Menu Conversor de Monedas  ¬¬¬¬¬ ");
                System.out.println("1. Convertir monedas");
                System.out.println("2. Ver historial de conversiones ");
                System.out.println("3. Ver monedas disponibles");
                System.out.println("0. Salir ");
                System.out.print(" Selecciona una Opción: ");
               int option = scanner.nextInt();

                if (option == 0) break;

                switch (option) {
                    case 1:
                        System.out.print(" Selecciona la Moneda Origen (eje. MXN): ");
                        String from = scanner.next().toUpperCase();
                        System.out.print(" Selecciona la Moneda Destino (eje. USD): ");
                        String to = scanner.next().toUpperCase();
                        System.out.print("Cantidad : ");
                        double amount = scanner.nextDouble();

                        try {
                            double result = CurrencyConverter.convert(from, to, amount, rates);
                            System.out.printf("Resultado : %.2f %s\n", result, to);
                            history.add(from, to, amount, result);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error : " + e.getMessage());

                        }

                        break;

                    case 2:
                        history.show();
                        break;

                    case 3:
                        System.out.println(" Monedas disponibles: ");
                        rates.keySet().forEach(System.out::println);
                        break;

                    default:
                        System.out.println(" Error Opción inválida. ");
                }
            }

        } catch (Exception e) {
            System.out.println(" Error Datos Invalidos , vuelve a intenrarlo : " + e.getMessage());
        }
    }
 }
