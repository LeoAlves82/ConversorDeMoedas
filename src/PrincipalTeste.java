import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.http.HttpRequest;

public class PrincipalTeste {
    public static void main(String[] args) {
        String endereco = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "e0e4465c196a80b550f73dc9/";
        String origem = "USD";
        String destino = "BRL";
        String valor = "100";

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Requisicao requisicao = new Requisicao(endereco, apiKey, origem, destino, valor);
        HttpRequest request = requisicao.criarRequest();

        Cliente cliente = new Cliente();
        JsonParaGson parser = new JsonParaGson();

        try {
            String json = cliente.enviarRequest(request);
            Resposta resposta = parser.parse(json);

            System.out.println(resposta);

            System.out.printf("Resultado: %s → %s %n %.2f ",
                    resposta.getBase_code(),
                    resposta.getTarget_code(),
                    resposta.getConversion_result());

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao enviar requisição: " + e.getMessage());
        }
    }
}

