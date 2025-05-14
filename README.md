
# 💱 Conversor de Moedas - Java

Este projeto é um **conversor de moedas** que utiliza a API [ExchangeRate API](https://www.exchangerate-api.com/) 
para realizar conversões entre diferentes moedas sul-americanas e o dólar americano.

---

## 📦 Estrutura do Projeto

```bash
src/
├── Cliente.java
├── Requisição.java
├── Resposta.java
├── PrincipalTeste.java
├── JsonParaGeson.java
├── Principal.java

 
```

---

## 📋 Descrição das Classes

---
### `Cliente.java`
- Cria um `HttpClient` para enviar a requisição.
- Recebe e retorna a resposta como `String`.

---

### `Requisicao.java`
Responsável por:
- Montar a URL da API com base nas moedas de origem, destino e valor.
- Criar e retornar o `HttpRequest` a ser usado pelo `Cliente`.

---

### `Resposta.java`
Classe modelo que representa os principais campos da resposta da API:
- `conversion_result`: valor convertido.
- `base_code`: moeda de origem.
- `target_code`: moeda de destino.

---

### `PrincipalTeste.java`
Classe de exemplo para testes automatizados (modo rápido sem entrada do usuário). 
- Define valores fixos de origem, destino e valor.
- Teste mostram a resposta Json. 
- Usa `Gson` para parsear o JSON da resposta da API.

---

### `JsonParaGeson.java`
- Usa a biblioteca **Gson** para converter a resposta JSON em um objeto da classe `Resposta`.

---

### `Principal.java`
Interface de linha de comando interativa que:
- Mostra o menu com as opções de moedas.
- Recebe a moeda de origem, destino e o valor.
- Chama as classes responsáveis por criar a requisição, enviá-la e mostrar o resultado.

---

## 🌎 Moedas Suportadas

- ARS - Peso argentino
- BOB - Boliviano
- BRL - Real brasileiro
- CLP - Peso chileno
- COP - Peso colombiano
- USD - Dólar americano

---

## 🔧 Tecnologias Utilizadas

- Java 11+
- HTTP Client nativo do Java
- Gson (Google) para serialização/deserialização JSON

---

## 🚀 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/conversor-moedas-java.git
```

2. Compile os arquivos:
```bash
javac -cp gson-2.10.jar src/*.java
```

3. Execute o programa principal:
```bash
java -cp .:gson-2.10.jar src/Principal
```

> Substitua `:` por `;` no Windows ao definir o classpath.

---

## 🔑 Sobre a API Key

Você precisa de uma **chave de API válida** da [ExchangeRate API](https://www.exchangerate-api.com/).

Atualize a variável `apiKey` nos arquivos `Principal.java` e `PrincipalTeste.java`:
```java
String apiKey = "SUA_CHAVE_AQUI/";
```

---

## 📌 Exemplo de Saída

```
Digite o número da moeda de ORIGEM ( ou 0 para sair): 6
Digite o número da moeda de DESTINO ( ou 0 para sair): 3
Digite o valor a ser convertido: 100
O Valor de 100 USD corresponde  ao valor final de  --> 507.23 em BRL
--- Conversão finalizada ---
```

---

## 🛠 Melhorias Futuras

- Suporte a mais moedas.
- Interface gráfica (GUI) com JavaFX.
- Testes automatizados com JUnit.

---

## 🧑‍💻 Autor

Desenvolvido por Leonardo Alves.

---
