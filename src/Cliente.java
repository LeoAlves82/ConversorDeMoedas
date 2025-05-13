import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente{
    private final HttpClient cliente;

    public Cliente() {
        this.cliente = HttpClient.newHttpClient();
    }

    public String enviarRequest(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = cliente
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

