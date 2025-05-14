import java.net.http.HttpRequest;
import java.util.Scanner;

public class Principal {
    private static final String[] codigosMoeda = {
            "ARS", // 1
            "BOB", // 2
            "BRL", // 3
            "CLP", // 4
            "COP", // 5
            "USD"  // 6
    };

    private static void exibirMenu() {
        System.out.println("***************************************************************************************");
        System.out.println("\nSeja bem vindo(a) ao conversor de moedas.");
        System.out.println("\n\n Selecione suas opções para conversão.");
        System.out.println("\n OPÇÃO - COD - NOME DA MOEDA");
        System.out.println("\n   1   - ARS - Peso argentino");
        System.out.println("   2   - BOB - Boliviano boliviano");
        System.out.println("   3   - BRL - Real brasileiro");
        System.out.println("   4   - CLP - Peso chileno");
        System.out.println("   5   - COP - Peso colombiano");
        System.out.println("   6   - USD - Dólar americano");
        System.out.println("   0   - Sair");
    }

    private static String obterCodigoPorOpcao(int opcao) {
        if (opcao >= 1 && opcao <= codigosMoeda.length) {
            return codigosMoeda[opcao - 1];
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        while (true) {
            exibirMenu();
            System.out.print("Digite o número da moeda de ORIGEM (0 para sair): ");
            int origemOpcao = leitura.nextInt();
            if (origemOpcao == 0) break;

            System.out.print("Digite o número da moeda de DESTINO (0 para sair): ");
            int destinoOpcao = leitura.nextInt();
            if (destinoOpcao == 0) break;

            leitura.nextLine(); // limpa buffer do scanner
            System.out.print("Digite o valor a ser convertido: ");
            String valor = leitura.nextLine();

            String origem = obterCodigoPorOpcao(origemOpcao);
            String destino = obterCodigoPorOpcao(destinoOpcao);

            if (origem == null || destino == null) {
                System.out.println("Opção inválida. Tente novamente.\n");
                continue;
            }

            // Configurações da API
            String endereco = "https://v6.exchangerate-api.com/v6/";
            String apiKey = "e0e4465c196a80b550f73dc9/";

            // Envia requisição
            Requisicao requisicao = new Requisicao(endereco, apiKey, origem, destino, valor);
            HttpRequest request = requisicao.criarRequest();
            Cliente cliente = new Cliente();
            JsonParaGson parser = new JsonParaGson();

            try {
                String respostaJson = cliente.enviarRequest(request);
                Resposta resposta = parser.parse(respostaJson);

                System.out.printf("\nO Valor de " + valor + " "
                        + resposta.getBase_code()
                        + " corresponde  ao valor final de  --> "
                        + resposta.getConversion_result()
                        + " em " + resposta.getTarget_code()
                        + "\n");

            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }

            System.out.println("\n--- Conversão finalizada ---\n");
        }

        leitura.close();
        System.out.println("Programa encerrado.");
    }
}

