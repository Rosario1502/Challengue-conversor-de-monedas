package conversor;

import com.google.gson.Gson;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class CurrencyService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5747981274751a78c485eb0f/latest/USD";

    public CurrencyResponse getRates() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), CurrencyResponse.class);
    }
}