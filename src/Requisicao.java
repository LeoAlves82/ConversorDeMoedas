
import java.net.URI;
import java.net.http.HttpRequest;

public class Requisicao{
    private final String endereco;
    private final String apiKey;
    private String origem;
    private String destino;
    private String valor;


    public Requisicao(String endereco, String apiKey, String origem, String destino, String valor) {
        this.endereco = endereco;
        this.apiKey = apiKey;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public HttpRequest criarRequest() {
        String uri = endereco + apiKey + "pair/" + origem + "/" + destino + "/" + valor;
        return HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .build();

    }
}

